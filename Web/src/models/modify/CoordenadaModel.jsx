import API_URL from '../../service/api';
const CoordenadaModel = () => {

    const fetchDataCoordenadaParticipante = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/historico-punto?phone=' + id);
            const json = await response.json();
            const jsonData = Object.values(json);


            //console.log(obtenerFechaMasReciente(jsonData));
            return JSON.stringify(obtenerFechaMasReciente(jsonData));
            // Simulación de los datos de JSON
            /*if(id===11){ 
                const jsonData =   `{"id": 1,"latitud": "10.465773","longitud": "-66.972684", "fecha": "09/11/2023 10:23"}`;
                return jsonData;
            }
            else{
                const jsonData =   `{"id": 2,"latitud": "10.468505","longitud": "-66.966966", "fecha": "09/11/2023 10:25"}`;
                return jsonData;
            }*/

        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function obtenerFechaMasReciente(json) {
        let fechaMasReciente = null;
        let objetoMasReciente = null;
      
        for (let i = 0; i < json.length; i++) {
          const fecha = new Date(json[i].fechaInicio);
      
          if (fechaMasReciente === null || fecha > fechaMasReciente) {
            fechaMasReciente = fecha;
            objetoMasReciente = json[i];
          }
        }
      
        if (objetoMasReciente !== null) {
          const id = objetoMasReciente.id;
          const latitud = objetoMasReciente.puntoGeografico.latitude;
          const longitud = objetoMasReciente.puntoGeografico.longitude;
          const fechaFormateada = `${fechaMasReciente.getDate()}/${fechaMasReciente.getMonth() + 1}/${fechaMasReciente.getFullYear()} ${fechaMasReciente.getHours()}:${fechaMasReciente.getMinutes()}:${fechaMasReciente.getSeconds()}`;
      
          return {
            id: id,
            latitud: latitud,
            longitud: longitud,
            fecha: fechaFormateada
          };
        } else {
          return null;
        }
    }



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
        /*
            // Simulación de los datos de JSON
            const jsonData =   `[{"coordinates": [
                                            { "lat": 10.469649, "lng": -66.972363 },
                                            { "lat": 10.471200, "lng": -66.968909 },
                                            { "lat": 10.472117, "lng": -66.969525 }]},
                                {"coordinates": [
                                            { "lat": 10.462639, "lng": -66.983928 },
                                            { "lat": 10.461775, "lng": -66.983643 },
                                            { "lat": 10.462205, "lng": -66.982985 },
                                            { "lat": 10.462920, "lng": -66.983508 }]},
                                {"coordinates": [
                                            { "lat": 10.463445, "lng": -66.978693 },
                                            { "lat": 10.462854, "lng": -66.978125 },
                                            { "lat": 10.463793, "lng": -66.974884 },
                                            { "lat": 10.465207, "lng": -66.973672 },
                                            { "lat": 10.465429, "lng": -66.977331 }]}]`;
            return jsonData;*/


                        
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
                    coordenadas.push({ lat: data[i].punto.latitude, lng: data[i].punto.longitude });
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

    const fetchDataZonaID = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/zona-punto?zona=' + id);
            const json = await response.json();
            const jsonData = Object.values(json);
            const transformedData = await transformDataPoints(jsonData);
            //console.log(transformedData);
            return JSON.stringify(transformedData);
        /*
            // Simulación de los datos de JSON
            const jsonData =   `[{"coordinates": [
                                { "lat": 10.463445, "lng": -66.978693 },
                                { "lat": 10.462854, "lng": -66.978125 },
                                { "lat": 10.463793, "lng": -66.974884 },
                                { "lat": 10.465207, "lng": -66.973672 },
                                { "lat": 10.465429, "lng": -66.977331 }]}]`;
            return jsonData;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    async function transformDataPoints(data) {
        const transformedData = [];
        const coordinates = [];
      
        for (const item of data) {
            if(item.punto.status==="Activo"){
                coordinates.push({
                    lat: item.punto.latitude,
                    lng: item.punto.longitude,
                  });
            }
        }
        transformedData.push({ coordinates });
        return transformedData;
    }

    return {
        fetchDataCoordenadaParticipante,
        fetchDataZonas,
        fetchDataZonaID
    };
};

export default CoordenadaModel;