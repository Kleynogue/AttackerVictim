const CasesModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = `[ {"id": 1,"atacante": "11","victima": "12","distancia": "500","tiempo": "00:00","inicio": "00/00/0000","final": "00/00/0000","status": "activo"},
                                {"id": 2,"atacante": "11","victima": "12","distancia": "500","tiempo": "00:00","inicio": "00/00/0000","final": "00/00/0000","status": "activo"},
                                {"id": 3,"atacante": "11","victima": "12","distancia": "500","tiempo": "00:00","inicio": "00/00/0000","final": "00/00/0000","status": "activo"}]`;
        
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

export default CasesModel;