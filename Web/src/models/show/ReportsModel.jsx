import API_URL from '../../service/api';
const ReportsModel = () => {

    const fetchDataPoints = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/reporte/1?phone=' + extractLastNumber(id));
            const json = await response.json();
            const jsonData = Object.values(json);
            return JSON.stringify(transformData(jsonData));
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function transformData(data) {
        return data.map(item => {
          const { id,type ,date, puntoGeografico: { latitude, longitude } } = item;
          //const formattedFecha = formatDate(fechaInicio);
      
          return {
            id,
            type,
            fecha: date,
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

export default ReportsModel;