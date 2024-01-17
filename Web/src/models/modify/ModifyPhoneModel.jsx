import API_URL from '../../service/api';
const ModifyPhoneModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el telefono: ' + id); 
    };

    const handleUpdateSQL = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el telefono: ' + data); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/telefono/update';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            alert('El telefono se actualiza con exito');
            window.location.reload();
          } else {
            alert('Error');
            throw new Error('Error al actualizar el telefono');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const fetchData = async (id) => {
        try {
          // Obtener los datos de la API
          const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/telefono/' + id);
          const jsonData = await response.json();
      
          console.log(jsonData);
          const transformedData = await transformData2(jsonData, id);
          console.log(transformedData);
      
          return JSON.stringify(transformedData);
        } catch (error) {
          console.error('Error al obtener los datos:', error);
          return null;
        }
    };
      
      
    async function transformData2(data) {
        if (data) {
            
            return {
                bluetooth: data.bluetooth,
                inicio: data.fechaInicio,
                final: data.fechaFin,
                usuario: data.usuario.persona.name +" "+data.usuario.persona.lastName,
                idUsuario: data.usuario.id,
                caso: data.querella.id,
                /*idVictima: idVictimas,
                distancia: data.distanciaMin,
                tiempo: data.tiempoControl,
                status: data.status*/
            };
        } else {
          return null;
        }
    }


    const getTelefonoByBluetooth = async (data) => {
        console.log('Verificamos el bluetooth: ' + data); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/query/telefono/1?bluetooth='+data;
      
        try {
          const response = await fetch(url, {
            method: 'GET',
            headers: {
              'Content-Type': 'application/json',
            },
          });
      
          if (response.ok) {
            return false;
          } else{
            return true;
            throw new Error('Error al actualizar el telefono');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    return {
        handleDeleteSQL,
        handleUpdateSQL,
        fetchData,
        getTelefonoByBluetooth
    };
};

export default ModifyPhoneModel;