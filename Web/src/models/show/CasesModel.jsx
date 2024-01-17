import API_URL from '../../service/api';
const CasesModel = () => {

    const fetchData = async (token) => {
        try {
          // Configurar cors
          const corsOptions = {
            origin: 'http://localhost:3000', // Reemplaza con el origen de tu aplicación React
            credentials: 'include', // Incluir siempre las credenciales en la solicitud
          };
      
          // Obtener los datos de la API
          const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/querella', {
            /*headers: {
              'Authorization': token
            },
            corsOptions, // Agrega las opciones de cors a la solicitud*/
          });
      
          const jsonData = await response.json();
      
          const transformedData = await transformData(Object.values(jsonData));
          return JSON.stringify(transformedData);
        } catch (error) {
          console.error('Error al obtener los datos:', error);
          return null;
        }
      };

    async function transformData(data) {
        const transformedData = [];
        for (const item of data) {
          const victimas = await obtenerNombreApellidoVictima(item.id);
          const agresores = await obtenerNombreApellidoAgresor(item.id);
          transformedData.push({
            id: item.id,
            atacante: agresores,
            victima: victimas,
            distancia: item.distanciaMin,
            tiempo: item.tiempoControl,
            status: item.status
          });
        }
        return transformedData;
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

    return {
        fetchData,
    };
};

export default CasesModel;