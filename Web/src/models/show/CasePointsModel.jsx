import API_URL from '../../service/api';
const CasePointsModel = () => {

    const fetchDataPoints = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/historico-punto?phone=' + extractLastNumber(id));
            const json = await response.json();
            const jsonData = Object.values(json);
            return JSON.stringify(transformData(jsonData));
        
            // Simulación de los datos de JSON
            /*const jsonData2 =   `[{ "id": 1, "fecha": "00/00/0000 00:00", "latitud": 10.463445, "longitud": -66.978693 },
                                { "id": 2, "fecha": "00/00/0000 00:00", "latitud": 10.462854, "longitud": -66.978125 },
                                { "id": 3, "fecha": "00/00/0000 00:00", "latitud": 10.463793, "longitud":  -66.974884},
                                { "id": 4, "fecha": "00/00/0000 00:00", "latitud": 10.465207, "longitud": -66.973672 },
                                { "id": 5, "fecha": "00/00/0000 00:00", "latitud": 10.466315, "longitud": -66.973672 },
                                { "id": 6, "fecha": "00/00/0000 00:00", "latitud": 10.467425, "longitud": -66.973672 },
                                { "id": 7, "fecha": "00/00/0000 00:00", "latitud": 10.468535, "longitud": -66.973672 },
                                { "id": 8, "fecha": "00/00/0000 00:00", "latitud": 10.469645, "longitud": -66.973672 },
                                { "id": 9, "fecha": "00/00/0000 00:00", "latitud": 10.461755, "longitud": -66.973672 },
                                { "id": 10, "fecha": "00/00/0000 00:00", "latitud": 10.465429, "longitud": -66.977331 }]`;

            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function transformData(data) {
        return data.map(item => {
          const { id, fechaInicio, puntoGeografico: { latitude, longitude } } = item;
          const formattedFecha = formatDate(fechaInicio);
      
          return {
            id,
            fecha: fechaInicio,
            latitud: latitude,
            longitud: longitude
          };
        });
      }
      
    function formatDate(dateString) {
        const date = new Date(dateString);
        const day = date.getDate().toString().padStart(2, '0');
        const month = (date.getMonth() + 1).toString().padStart(2, '0');
        const year = date.getFullYear().toString();
        const hours = date.getHours().toString().padStart(2, '0');
        const minutes = date.getMinutes().toString().padStart(2, '0');
        
        return `${day}/${month}/${year} ${hours}:${minutes}`;
    }

    function extractLastNumber(str) {
        const regex = /\((\d+)\)[^\(\)]*$/;
        const match = str.match(regex);
        
        if (match && match[1]) {
          return parseInt(match[1]);
        }
        
        return null;
    }

    return {
        fetchDataPoints,
    };
};

export default CasePointsModel;