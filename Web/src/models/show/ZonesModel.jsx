import API_URL from '../../service/api';
const ZonesModel = () => {

    const fetchData = async (id) => {
        try {
            const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/zona-seguridad/2?querella=' + id);
            const json = await response.json();
            const jsonData = Object.values(json);
            const transformedData = await transformData(jsonData);
            
            return JSON.stringify(transformedData);

            // Simulación de los datos de JSON
            /*const jsonData2 = `[ {"id": 1,"nombre": "Zona 1"},
                                {"id": 2,"nombre": "Zona 2"},
                                {"id": 3,"nombre": "Zona 3"},
                                {"id": 4,"nombre": "Zona 4"}]`;
        
            return jsonData2;*/
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    async function transformData(data) {
        const transformedData = [];
        for (const item of data) {
            transformedData.push({
                id: item.id,
                nombre: item.name,
            });
        }
        return transformedData;
    }

    return {
        fetchData,
    };
};

export default ZonesModel;