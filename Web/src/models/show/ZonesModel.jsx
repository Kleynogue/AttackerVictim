const ZonesModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = `[ {"id": 1,"nombre": "Zona 1"},
                                {"id": 2,"nombre": "Zona 2"},
                                {"id": 3,"nombre": "Zona 3"},
                                {"id": 4,"nombre": "Zona 4"}]`;
        
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

export default ZonesModel;