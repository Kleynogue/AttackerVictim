const PhonesModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = `[ {"id": 1,"bluetooth": "aaaaaa","usuario": "1","caso": "1", "numero": "00000000"},
                                {"id": 2,"bluetooth": "bbbbbb","usuario": "5","caso": "1", "numero": "00000000"},
                                {"id": 3,"bluetooth": "cccccc","usuario": "10","caso": "2", "numero": "00000000"},
                                {"id": 4,"bluetooth": "dddddd","usuario": "4","caso": "2", "numero": "00000000"},
                                {"id": 5,"bluetooth": "eeeeee","usuario": "7","caso": "3", "numero": "00000000"},
                                {"id": 6,"bluetooth": "ffffff","usuario": "12","caso": "3", "numero": "00000000"}]`;
        
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

export default PhonesModel;