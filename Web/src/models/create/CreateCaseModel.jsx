import API_URL from '../../service/api';
const CreateCaseModel = () => {

    const handleCreateSQL = async (data) => {
        console.log('Este método debe realizar la petición SQL para crear un caso ' + JSON.stringify(data));
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/querella';
      
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

    const fetchDataAttackers = async () => {
        try {
            const response = await fetch(API_URL + 'cmcapp-backend-1.0/api/v1/query/usuario/2?type=Agresor');
            const jsonData = await response.json();
            //console.log("---> " + JSON.stringify(jsonData));

            const transformedData = transformData(Object.values(jsonData));
            return JSON.stringify(transformedData);
            // Simulación de los datos de JSON
            /*const jsonData2 = `[ {"id": 1,"nombre": "John","apellido": "Doe"},
                                {"id": 2,"nombre": "Jane","apellido": "Smith"},
                                {"id": 3,"nombre": "Jane","apellido": "Smith"},
                                {"id": 5,"nombre": "Jane","apellido": "Smith"},
                                {"id": 11,"nombre": "John","apellido": "Doe"},
                                {"id": 12,"nombre": "Jane","apellido": "Smith"}]`;
            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };


    const fetchDataVictims = async () => {
        try {
            const response = await fetch(API_URL + 'cmcapp-backend-1.0/api/v1/query/usuario/2?type=Victima');
            const jsonData = await response.json();
            //console.log("---> " + JSON.stringify(jsonData));

            const transformedData = transformData(Object.values(jsonData));
            return JSON.stringify(transformedData);
        
            // Simulación de los datos de JSON
            /*const jsonData2 = `[ {"id": 3,"nombre": "John","apellido": "Doe"},
                                {"id": 4,"nombre": "Jane","apellido": "Smith"},
                                {"id": 20,"nombre": "Jane","apellido": "Smith"},
                                {"id": 21,"nombre": "John","apellido": "Doe"},
                                {"id": 22,"nombre": "Jane","apellido": "Smith"}]`;
            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function transformData(data) {
        return data.map(item => ({
            id: item.id,
            nombre: item.persona.name,
            apellido: item.persona.lastName,
        }));
    }

    return {
        handleCreateSQL,
        fetchDataAttackers,
        fetchDataVictims,
    };
};

export default CreateCaseModel;