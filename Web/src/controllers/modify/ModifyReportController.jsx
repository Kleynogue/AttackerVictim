import ModifyReportModel from '../../models/modify/ModifyReportModel';

const ModifyReportController = () => {

    const modifyReportModel = ModifyReportModel();

    const handleDelete = (id) => { 
        modifyReportModel.handleDeleteSQL(id);
    };

    const handleGet = async (id) => {
        const jsonDataString = await modifyReportModel.fetchData();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
          const jsonData = JSON.parse(jsonDataString);
          return(jsonData);
          //console.log("========= ", jsonData.nombre);
        }
    };

    const handleActualizar = (event,id) => {
        event.preventDefault();

        const telefono = event.target.elements.ReportTelefono.value;
        
        const fecha = event.target.elements.ReportFecha.value;
        const descripcion = event.target.elements.ReportDescripcion.value;

        modifyReportModel.handleUpdateSQL(id);

        if(telefono){
            console.log('Se actualiza el telefono: '+ telefono);
        }
        if(fecha){
            console.log('Se actualiza la fecha: '+ fecha);
        }
        if(descripcion){
            console.log('Se actualiza la descripcion: '+ descripcion);
        }
        
    };

    //Cuando presionas el mapa muestra un punto
    const handleMapClick = (event, setMarkerPosition) => {
        const clickedLatLng = {
            lat: event.latLng.lat(),
            lng: event.latLng.lng()
        };
        setMarkerPosition(clickedLatLng);
    };


    const handleRestartPoint = ( lat, lng, setMarkerPosition) => {
        setMarkerPosition({ lat: parseFloat(lat), lng: parseFloat(lng) });  
    };

    //Submit para crear un nuevo punto de la zona
    const handleUpdatePoint = (event, lat, lng, setLatActual, setLngActual , reporte) => {    
        event.preventDefault();
          
        if (lat !== null && lng !== null) {
            const point = {
                lat: lat,
                lng: lng,
            };
          
            setLatActual(lat);
            setLngActual(lng);
            event.target.reset();
            modifyReportModel.handleUpdatePointSQL(point, reporte);
        } else {
            alert('Ingrese datos válidos');
        }
    };


    return {
        handleDelete,
        handleGet,
        handleActualizar,
        handleMapClick,
        handleRestartPoint,
        handleUpdatePoint
    };
};

export default ModifyReportController;