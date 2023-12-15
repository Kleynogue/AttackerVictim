const ModifyCaseModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el caso: ' + id); 
    };

    const handleUpdateSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el caso: ' + id); 
    };

    const fetchDataCase = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `{"id": 1,"atacante": "11","victima": "12","distancia": "500","tiempo": "00:00","inicio": "00/00/0000","final": "00/00/0000","status": "activo"}`;
        
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    const fetchDataParticipante = async (id) => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            if(id===11){
                const jsonData =   `{"id": 1,"nombre": "Pedro","apellido": "Perez"}`;
                return jsonData;
            }
            else{
                const jsonData =   `{"id": 2,"nombre": "Paula","apellido": "Rodriguez"}`;
                return jsonData;
            }

        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    return {
        handleDeleteSQL,
        handleUpdateSQL,
        fetchDataCase,
        fetchDataParticipante
    };
};

export default ModifyCaseModel;