const ModifyZoneModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar la zona de seguridad: ' + id); 
    };

    const handleUpdateSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar la zona de seguridad: '+ id); 
    };

    const handleCreatePointSQL = (point, zona) => {
        console.log('Este metodo debe realizar la peticion SQL para agregar el punto (' +point.lat+','+point.lng+ ') a la zona de seguridad: ' + zona); 
    };

    const handleDeletePointSQL = (id,zona) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el punto: ' + id + ' de la zona: '+ zona); 
    };

    const fetchDataPoints = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `[{ "id": 1, "latitud": 10.463445, "longitud": -66.978693 },
                                { "id": 2, "latitud": 10.462854, "longitud": -66.978125 },
                                { "id": 3, "latitud": 10.463793, "longitud":  -66.974884},
                                { "id": 4, "latitud": 10.465207, "longitud": -66.973672 },
                                { "id": 5, "latitud": 10.465429, "longitud": -66.977331 }]`;

            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    const fetchDataZones = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `{"id": 1,"nombre": "Zona 1"}`;
        
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };


    return {
        handleDeleteSQL,
        handleUpdateSQL,
        handleCreatePointSQL,
        handleDeletePointSQL,
        fetchDataPoints,
        fetchDataZones
    };
};

export default ModifyZoneModel;