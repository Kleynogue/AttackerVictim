import API_URL from '../../service/api';
const CaseWifiModel = () => {

    const fetchData = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/conexion/2?phone=' + extractLastNumber(id));
            const json = await response.json();
            const jsonData = Object.values(json);
            return JSON.stringify(transformData(jsonData));
        
            // Simulación de los datos de JSON
            const jsonData2 =   `[{ "id": 1, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 2, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 3, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 4, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 5, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 }]`;

            return jsonData2;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function transformData(data) {
        return data.map(item => {
          const { id, date, x, y, z } = item;
          const formattedDate = formatDate(date);
      
          return {
            id,
            fecha: date,
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
        fetchData,
    };
};

export default CaseWifiModel;