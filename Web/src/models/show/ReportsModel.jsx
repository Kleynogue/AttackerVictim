const ReportsModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = `[ {"id": 1,"telefono": "2","fecha": "00/00/0000","localizacion": "Localizacion 1"},
                                {"id": 2,"telefono": "4","fecha": "00/00/0000","localizacion": "Localizacion 2"},
                                {"id": 3,"telefono": "7","fecha": "00/00/0000","localizacion": "Localizacion 3"},
                                {"id": 4,"telefono": "1","fecha": "00/00/0000","localizacion": "Localizacion 4"},
                                {"id": 5,"telefono": "5","fecha": "00/00/0000","localizacion": "Localizacion 5"},
                                {"id": 6,"telefono": "3","fecha": "00/00/0000","localizacion": "Localizacion 6"}]`;
        
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    return {
        fetchData,
    };
};

export default ReportsModel;