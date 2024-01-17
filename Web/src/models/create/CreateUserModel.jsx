import API_URL from '../../service/api';
const CreateUserModel = () => {

    const handleCreateSQLPersona = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para crear un persona: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/persona';
      
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
    };

    const handleCreateSQLUsuario = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para crear un usuario: '+  JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/usuario';
      
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
    };

    return {
        handleCreateSQLPersona,
        handleCreateSQLUsuario
    };
};

export default CreateUserModel;