const CoordenadaModel = () => {

    const fetchDataCoordenadaParticipante = async (id) => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            if(id===11){ 
                const jsonData =   `{"id": 1,"latitud": "10.465773","longitud": "-66.972684", "fecha": "09/11/2023 10:23"}`;
                return jsonData;
            }
            else{
                const jsonData =   `{"id": 2,"latitud": "10.468505","longitud": "-66.966966", "fecha": "09/11/2023 10:25"}`;
                return jsonData;
            }

        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    const fetchDataZonas = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `[{"coordinates": [
                                            { "lat": 10.469649, "lng": -66.972363 },
                                            { "lat": 10.471200, "lng": -66.968909 },
                                            { "lat": 10.472117, "lng": -66.969525 }]},
                                {"coordinates": [
                                            { "lat": 10.462639, "lng": -66.983928 },
                                            { "lat": 10.461775, "lng": -66.983643 },
                                            { "lat": 10.462205, "lng": -66.982985 },
                                            { "lat": 10.462920, "lng": -66.983508 }]},
                                {"coordinates": [
                                            { "lat": 10.463445, "lng": -66.978693 },
                                            { "lat": 10.462854, "lng": -66.978125 },
                                            { "lat": 10.463793, "lng": -66.974884 },
                                            { "lat": 10.465207, "lng": -66.973672 },
                                            { "lat": 10.465429, "lng": -66.977331 }]}]`;
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    const fetchDataZonaID = async (id) => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `[{"coordinates": [
                                { "lat": 10.463445, "lng": -66.978693 },
                                { "lat": 10.462854, "lng": -66.978125 },
                                { "lat": 10.463793, "lng": -66.974884 },
                                { "lat": 10.465207, "lng": -66.973672 },
                                { "lat": 10.465429, "lng": -66.977331 }]}]`;
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    return {
        fetchDataCoordenadaParticipante,
        fetchDataZonas,
        fetchDataZonaID
    };
};

export default CoordenadaModel;