import API_URL from '../../service/api';
const PhonesModel = () => {

    const fetchData = async () => {
        try {
            //Obtener los datos de la API
            const response = await fetch(API_URL + 'cmcapp-backend-1.0/api/v1/telefono');
            const jsonData = await response.json();
            //console.log("---> " + JSON.stringify(jsonData));

            const transformedData = transformData(Object.values(jsonData));
            // Simulación de los datos de JSON
 /*           const jsonData = `[ {"id": 1,"bluetooth": "aaaaaa","usuario": "1","caso": "1", "numero": "00000000"},
                                {"id": 2,"bluetooth": "bbbbbb","usuario": "5","caso": "1", "numero": "00000000"},
                                {"id": 3,"bluetooth": "cccccc","usuario": "10","caso": "2", "numero": "00000000"},
                                {"id": 4,"bluetooth": "dddddd","usuario": "4","caso": "2", "numero": "00000000"},
                                {"id": 5,"bluetooth": "eeeeee","usuario": "7","caso": "3", "numero": "00000000"},
                                {"id": 6,"bluetooth": "ffffff","usuario": "12","caso": "3", "numero": "00000000"}]`;
        */
                                //console.log("---> " + transformedData);
            return JSON.stringify(transformedData);
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    function transformData(data) {
        return data.map(item => ({
          id: item.id,
          bluetooth: item.bluetooth,
          usuario: item.usuario.persona.name +" "+item.usuario.persona.lastName+" ("+item.usuario.id+")",
          caso: item.querella.id,
          fecha_inicial: item.fechaInicio,
          fecha_final: item.fechaFin,
        }));
    }

    return {
        fetchData,
    };
};

export default PhonesModel;