import API_URL from '../../service/api';
const CreatePhoneModel = () => {

    const handleCreateSQL = async (data) => {
        console.log('Este método debe realizar la petición SQL para crear un telefono ' + JSON.stringify(data));
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/telefono';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            
          } else {
            throw new Error('Error al crear el telefono');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    return {
        handleCreateSQL,
    };
};

export default CreatePhoneModel;