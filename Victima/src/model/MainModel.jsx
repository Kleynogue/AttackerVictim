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

    const fetchDataZonas = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/zona-seguridad/2?querella=' + id);
            const json = await response.json();
            const jsonData2 = Object.values(json);

            const idsPuntosGeografico = obtenerIDsPuntosGeograficos(jsonData2);
            //console.log(idsPuntosGeografico);

            const resultado = obtenerCoordenadas(idsPuntosGeografico);

            return resultado
            .then(jsonFinal => {
                //console.log(JSON.stringify(jsonFinal));
                return JSON.stringify(jsonFinal);
            })
            .catch(error => {
                //console.error('Error al obtener las coordenadas:', error);
                throw error; // O maneja el error adecuadamente aquí
            });                
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function obtenerIDsPuntosGeograficos(json) {
        const idsPrincipales = [];
        for (let i = 0; i < json.length; i++) {
            idsPrincipales.push(json[i].id);
        }
        return idsPrincipales;
    }

    async function obtenerCoordenadas(idsPuntosGeograficos) {
        const resultados = [];
      
        for (const id of idsPuntosGeograficos) {
          const url = API_URL + 'cmcapp-backend-1.0/api/v1/query/zona-punto?zona=' + id;
          //console.log("-------->  " + id);
      
          try {
            const response = await fetch(url);
            const data = await response.json();
            //console.log(data);
      
            const coordenadas = [];
            for (let i = 0; i < data.length; i++) {
                if(data[i].punto.status === "Activo"){
                    coordenadas.push({ latitude: data[i].punto.latitude, longitude: data[i].punto.longitude });
                }
            }
      
            if (coordenadas.length >= 3) {
              const resultado = { coordinates: coordenadas };
              resultados.push(resultado);
            }
          } catch (error) {
            console.error(`Error al obtener las coordenadas para el id ${id}:`, error);
          }
        }
      
        return resultados;
    }

    return {
        handleCreateSQLPunto,
        handleCreateSQLPosicion,
        handleCreateSQLMovimiento,
        handleCreateSQLWifi,
        handleValidarBluetooth,
        handleCreateSQLReporte,
        fetchDataZonas
    };
};

export default CreateUserModel;