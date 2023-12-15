import ModifyZoneModel from '../../models/modify/ModifyZoneModel';

const ModifyZoneController = () => {

    const modifyZoneModel = ModifyZoneModel();

    //Actualizar zona de seguridad
    const handleUpdate = (event, id) => {
        event.preventDefault();
            
        const nombre = event.target.elements.ZoneNombre.value;
            
        modifyZoneModel.handleUpdateSQL(id);

        if(nombre){
            console.log('Se actualiza el nombre: '+ nombre);
        }
    };

    //Borrar zona de seguridad
    const handleDeleteZone = (id) => { 
        modifyZoneModel.handleDeleteSQL(id);      
    };

    //Submit para crear un nuevo punto de la zona
    const handleCreatePoint = (event, lat, lng, zona) => {    
        event.preventDefault();
      
        if (lat !== null && lng !== null) {
            const point = {
                lat: lat,
                lng: lng,
            };
      
            event.target.reset();
            modifyZoneModel.handleCreatePointSQL(point, zona);
        } else {
          alert('Ingrese datos válidos');
        }
    };

    //Cuando presionas un punto de la lista este se muestra en el mapa
    const handleRowClick = (punto,setPuntoSeleccionado) => {
        const clickedLatLng = {
            lat: punto.latitud,
            lng: punto.longitud,
            id: punto.id,
        };
        setPuntoSeleccionado(clickedLatLng);

        console.log(clickedLatLng)
    };

    //Borrar punto de la zona de seguridad
    const handleDeletePoint = (id, zona) => { 
        modifyZoneModel.handleDeletePointSQL(id, zona);
    };

    //Cuando presionas el mapa muestra un punto
    const handleMapClick = (event, setMarkerPosition) => {
        const clickedLatLng = {
            lat: event.latLng.lat(),
            lng: event.latLng.lng()
        };
        setMarkerPosition(clickedLatLng);
    };

    //Obtener puntos de la zona
    const handleGetPoints = async () => {
        const jsonDataString = await modifyZoneModel.fetchDataPoints();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    //Obtener datos de la zona
    const handleGetZones = async (id) => {
        const jsonDataString = await modifyZoneModel.fetchDataZones();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
            
        }
    };

    
    return {
        handleMapClick,
        handleCreatePoint,
        handleRowClick,
        handleDeleteZone,
        handleDeletePoint,
        handleUpdate,
        handleGetPoints,
        handleGetZones,
    };
};

export default ModifyZoneController;