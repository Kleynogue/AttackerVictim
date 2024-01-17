import API_URL from '../../service/api';
const ModifyCaseModel = () => {

    const handleDeleteSQL = (id) => {
        console.log('Este metodo debe realizar la peticion SQL para eliminar el caso: ' + id); 
    };

    const handleUpdateSQL = async (data) => {
        console.log('Este metodo debe realizar la peticion SQL para actualizar el caso: ' + JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/querella/update';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            alert('El caso se actualiza con exito');
            window.location.reload();
          } else {
            
            throw new Error('Error al actualizar el caso');
          }
        } catch (error) {
            alert('Error');
            console.log('Error en la solicitud: ', error);
        }
    };

    const fetchDataCase = async (id) => {
        try {
          // Obtener los datos de la API
          const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/querella/' + id);
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
      
      
      async function transformData2(data, id) {
        if (data) {
            const victimas = await obtenerNombreApellidoVictima(id);
            const agresores = await obtenerNombreApellidoAgresor(id);
            const idVictimas = await obtenerIdVictima(id);
            const idAgresores = await obtenerIdAgresor(id);
            return {
                id: data.id,
                atacante: agresores,
                victima: victimas,
                idAtacante: idAgresores,
                idVictima: idVictimas,
                distancia: data.distanciaMin,
                tiempo: data.tiempoControl,
                status: data.status
            };
        } else {
          return null;
        }
      }

    async function obtenerNombreApellidoVictima(id) {
        const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/telefono/2?querella=' + id);
        const json = await response.json();
        const jsonData = Object.values(json);
        const victimas = jsonData.filter(item => item.usuario.tipo === "Victima");
        const nombresApellidos = victimas.map(item => `${item.usuario.persona.name} ${item.usuario.persona.lastName} (${item.id})`);
        return nombresApellidos;
    }
      
    async function obtenerNombreApellidoAgresor(id) {
        const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/telefono/2?querella=' + id);
        const json = await response.json();
        const jsonData = Object.values(json);
        const agresores = jsonData.filter(item => item.usuario.tipo === "Agresor");
        const nombresApellidos = agresores.map(item => `${item.usuario.persona.name} ${item.usuario.persona.lastName} (${item.id})`);
        return nombresApellidos;
    }

    async function obtenerIdVictima(id) {
        const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/telefono/2?querella=' + id);
        const json = await response.json();
        const jsonData = Object.values(json);
        const victimas = jsonData.filter(item => item.usuario.tipo === "Victima");
        const ids = victimas.map(item => item.id);
        return ids;
    }
    
    async function obtenerIdAgresor(id) {
        const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/telefono/2?querella=' + id);
        const json = await response.json();
        const jsonData = Object.values(json);
        const agresores = jsonData.filter(item => item.usuario.tipo === "Agresor");
        const ids = agresores.map(item => item.id);
        return ids;
    }






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