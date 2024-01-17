import API_URL from '../../service/api';
const ModifyZoneModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar la zona de seguridad: ' + id); 
    };

    const handleUpdateSQL = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar la zona de seguridad: '+ data); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/zona-seguridad/update';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            window.location.reload();
          } else {
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
      };

    const handleCreatePointSQLGeografico = async (data) => {
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
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
      };

    const handleCreatePointSQLZona = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para agregar el punto de zona  ' + JSON.stringify(data)); 

        const url = API_URL + 'cmcapp-backend-1.0/api/v1/zona-punto';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            window.location.reload();
          } else {
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    const handleDeletePointSQL = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el punto: ' + data );
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/punto-geografico/update';
      
        try {
            const response = await fetch(url, {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json',
              },
              body: JSON.stringify(data),
            });
        
            if (response.ok) {
              alert('La zona se actualiza con exito');
              window.location.reload();
            } else {
              alert('Error');
              throw new Error('Error al actualizar el telefono');
            }
        } catch (error) {
            console.log('Error en la solicitud: ', error);
        }
    };

    const fetchDataPoints = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/zona-punto?zona=' + id);
            const json = await response.json();
            const jsonData = Object.values(json);
            const transformedData = await transformDataPoints(jsonData);
            console.log(transformedData);
            return JSON.stringify(transformedData);
        
            // Simulación de los datos de JSON
            /*const jsonData2 =   `[{ "id": 1, "latitud": 10.463445, "longitud": -66.978693 },
                                { "id": 2, "latitud": 10.462854, "longitud": -66.978125 },
                                { "id": 3, "latitud": 10.463793, "longitud":  -66.974884},
                                { "id": 4, "latitud": 10.465207, "longitud": -66.973672 },
                                { "id": 5, "latitud": 10.465429, "longitud": -66.977331 }]`;

            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    async function transformDataPoints(data) {
        const transformedData = [];
        for (const item of data) {
            if(item.punto.status==="Activo"){
                transformedData.push({
                    id: item.punto.id,
                    latitud: item.punto.latitude,
                    longitud: item.punto.longitude,
                });
            }
            
        }
        return transformedData;
    }

    const fetchDataZones = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/zona-seguridad/' + id);
            const json = await response.json();
            const transformedData = await transformDataZone(json);
            return JSON.stringify(transformedData);

            // Simulación de los datos de JSON
            /*const jsonData2 =   `{"id": 1,"nombre": "Zona 1"}`;
            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    async function transformDataZone(data) {
            return{
                id: data.id,
                nombre: data.name,
            };
    }

    return {
        handleDeleteSQL,
        handleUpdateSQL,
        handleCreatePointSQLZona,
        handleCreatePointSQLGeografico,
        handleDeletePointSQL,
        fetchDataPoints,
        fetchDataZones
    };
};

export default ModifyZoneModel;