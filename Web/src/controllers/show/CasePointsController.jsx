import CasePointsModel from '../../models/show/CasePointsModel';

const CasePointsController = () => {

    const casePointsModel = CasePointsModel();

    //Cuando presionas un punto de la lista este se muestra en el mapa
    const handleRowClick = (punto,setPuntoSeleccionado) => {
        const clickedLatLng = {
            lat: punto.latitud,
            lng: punto.longitud,
            id: punto.id,
        };
          setPuntoSeleccionado(clickedLatLng);
    };

    //Obtener puntos de la zona
    const handleGetPoints = async () => {
        const jsonDataString = await casePointsModel.fetchDataPoints();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };
    
    return {
        handleRowClick,
        handleGetPoints
    };
};

export default CasePointsController;