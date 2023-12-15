import CoordenadaModel from '../../models/modify/CoordenadaModel';

const CoordenadaController = () => {

    const coordenadaModel = CoordenadaModel();

    const handleGetCoordenada = async (id) => {
        const jsonDataString = await coordenadaModel.fetchDataCoordenadaParticipante(id);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    const handleGetZonas = async () => {
        const jsonDataString = await coordenadaModel.fetchDataZonas();
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    const handleGetZonaID = async () => {
        const jsonDataString = await coordenadaModel.fetchDataZonaID();
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };


    return {
        handleGetCoordenada,
        handleGetZonas,
        handleGetZonaID,
    };
};

export default CoordenadaController;