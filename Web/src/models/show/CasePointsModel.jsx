const CasePointsModel = () => {

    const fetchDataPoints = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `[{ "id": 1, "fecha": "00/00/0000 00:00", "latitud": 10.463445, "longitud": -66.978693 },
                                { "id": 2, "fecha": "00/00/0000 00:00", "latitud": 10.462854, "longitud": -66.978125 },
                                { "id": 3, "fecha": "00/00/0000 00:00", "latitud": 10.463793, "longitud":  -66.974884},
                                { "id": 4, "fecha": "00/00/0000 00:00", "latitud": 10.465207, "longitud": -66.973672 },
                                { "id": 5, "fecha": "00/00/0000 00:00", "latitud": 10.466315, "longitud": -66.973672 },
                                { "id": 6, "fecha": "00/00/0000 00:00", "latitud": 10.467425, "longitud": -66.973672 },
                                { "id": 7, "fecha": "00/00/0000 00:00", "latitud": 10.468535, "longitud": -66.973672 },
                                { "id": 8, "fecha": "00/00/0000 00:00", "latitud": 10.469645, "longitud": -66.973672 },
                                { "id": 9, "fecha": "00/00/0000 00:00", "latitud": 10.461755, "longitud": -66.973672 },
                                { "id": 10, "fecha": "00/00/0000 00:00", "latitud": 10.465429, "longitud": -66.977331 }]`;

            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };




    return {
        fetchDataPoints,
    };
};

export default CasePointsModel;