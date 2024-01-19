import API_URL from '../service/api';
const LoginModel = (navigation) => {

    const handleValidarUser = async (userData) => {

        console.log('Este método debe validar el usuario y contraseña');
      
        try {
          const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/login', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
          });
      
          if (response.ok) {
            return true;

          } else {
            return false;
          }
        } catch (error) {
          console.error('Error al validar el usuario:', error);
        }
        return false;
    };

    const handleValidarBluetooth = async (blueTooth) => {

        console.log('Este metodo debe validar el bluetooth'); 
        try {
            // Obtener los datos de la API
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/telefono/1?bluetooth=' + blueTooth);
            const jsonData = await response.json();

            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }

    };


    return {
        handleValidarUser,
        handleValidarBluetooth
    };
};
export default LoginModel;