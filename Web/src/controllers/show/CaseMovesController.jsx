import CaseMovesModel from '../../models/show/CaseMovesModel';

const CaseMovesController = () => {

    const caseMovesModel = CaseMovesModel();

    //Obtener puntos de la zona
    const handleGetData = async (id) => {
        const jsonDataString = await caseMovesModel.fetchData(id);
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };
    
    return {
        handleGetData
    };
};

export default CaseMovesController;