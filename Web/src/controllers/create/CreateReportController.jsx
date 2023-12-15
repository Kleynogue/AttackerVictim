import CreateReportModel from '../../models/create/CreateReportModel';

const CreateReportController = () => {

    const createReportModel = CreateReportModel();

    const handleCrear = (event, lat, lng, id) => {
        event.preventDefault();

        const telefono = event.target.elements.ReportTelefono.value;
        
        const fecha = event.target.elements.ReportFecha.value;
        const descripcion = event.target.elements.ReportDescripcion.value;

        createReportModel.handleCreateSQL(id);

        
        if(telefono){
            console.log('Telefono: '+ telefono);
        }
        if(fecha){
            console.log('Fecha: '+ fecha);
        }
        if(descripcion){
            console.log('Descripcion: '+ descripcion);
        }
        if (lat !== null && lng !== null) {
            console.log('Coordenadas: ('+ lat+' , '+lng+')');
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


    return {
        handleCrear,
        handleMapClick
    };
};

export default CreateReportController;