const ModifyReportModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el reporte: ' + id); 
    };

    const handleUpdateSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el reporte: ' + id); 
    };

    const handleUpdatePointSQL = (point, reporte) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el punto  (' +point.lat+','+point.lng+ ') del reporte: ' + reporte); 
    };

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = '{"telefono": "1","latitud": "10.464636790105592","longitud": "-66.97466127804883","fecha": "00/00/0000", "descripcion": "00000000"}';   
            return jsonData; // Devolver la cadena JSON directamente
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    return {
        handleDeleteSQL,
        handleUpdateSQL,
        handleUpdatePointSQL,
        fetchData
    };
};

export default ModifyReportModel;