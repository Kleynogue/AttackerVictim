import API_URL from '../service/api';
const CreateUserModel = () => {

    const handleCreateSQLPunto = async (data) => {
        //console.log('Este metodo debe realizar la peticion SQL para crear un punto: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/punto-geografico';
      
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
            throw new Error('Error al crear el punto');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const handleCreateSQLPosicion = async (data) => {
        //console.log('Este metodo debe realizar la peticion SQL para crear un punto de un caso: '+  JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/historico-punto';
      
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
            throw new Error('Error al crear la posicion');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const handleCreateSQLMovimiento = async (data) => {
        //console.log('Este metodo debe realizar la peticion SQL para crear un movimiento: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/movimiento';
      
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
            throw new Error('Error al crear el movimiento');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const handleCreateSQLReporte = async (data) => {
        //console.log('Este metodo debe realizar la peticion SQL para crear un reporte: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/reporte';
      
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
            throw new Error('Error al crear el reporte');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const handleCreateSQLWifi = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para crear un historico de conexion: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/conexion';
      
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
            throw new Error('Error al crear el wifi de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
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
        handleCreateSQLPunto,
        handleCreateSQLPosicion,
        handleCreateSQLMovimiento,
        handleCreateSQLWifi,
        handleValidarBluetooth,
        handleCreateSQLReporte
    };
};

export default CreateUserModel;