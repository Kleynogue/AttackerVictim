import CaseWifiModel from '../../models/show/CaseWifiModel';

const CaseWifiController = () => {

    const caseWifiModel = CaseWifiModel();

    //Obtener puntos de la zona
    const handleGetData = async (id) => {
        const jsonDataString = await caseWifiModel.fetchData(id);
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

export default CaseWifiController;