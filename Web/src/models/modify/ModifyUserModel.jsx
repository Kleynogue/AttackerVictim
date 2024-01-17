import API_URL from '../../service/api';
const ModifyUserModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el usuario: ' + id); 
    };

    const handleUpdateSQL = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el usuario: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/persona/update';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            const responseData = await response.json();
            return responseData; 
          } else {
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    } 

    const handleUpdateSQLUser = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el usuario: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/usuario/update';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            alert('El usuario se actualiza con exito');
            window.location.reload();
          } else {
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    } 

    const fetchData = async (id) => {
        try {
            // Obtener los datos de la API
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/usuario/' + id);
            const jsonData = await response.json();
        
            console.log(jsonData);
            const transformedData = await transformData(jsonData, id);
            console.log(transformedData);
        
            return JSON.stringify(transformedData);
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    async function transformData(data, id) {
        if (data) {
            return {
                nombre: data.persona.name,
                apellido: data.persona.lastName,
                usuario: data.username,
                //password: data.,
                direccion: data.persona.address,
                tipo: data.tipo,
                id: data.persona.id
            };
        } else {
          return null;
        }
      }

    return {
        handleDeleteSQL,
        handleUpdateSQL,
        handleUpdateSQLUser,
        fetchData,
    };
};

export default ModifyUserModel;