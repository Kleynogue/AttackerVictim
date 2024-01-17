import ModifyZoneModel from '../../models/modify/ModifyZoneModel';

const ModifyZoneController = () => {

    const modifyZoneModel = ModifyZoneModel();

    //Actualizar zona de seguridad
    const handleUpdate = (event, id, caso) => {
        event.preventDefault();
            
        const nombre = event.target.elements.ZoneNombre.value;
            
        if(nombre){
            console.log('Se actualiza el nombre: '+ nombre);
            const data = {
                name: nombre,
                querella: {id: caso},
                id: id
            };
            modifyZoneModel.handleUpdateSQL(data);
            alert('La zona se actualiza con exito');
        }

        
    };

    //Borrar zona de seguridad
    const handleDeleteZone = (id) => { 
        modifyZoneModel.handleDeleteSQL(id);      
    };

    //Submit para crear un nuevo punto de la zona
    const handleCreatePoint = async (event, lat, lng, zona) => {    
        event.preventDefault();
      
        if (lat !== null && lng !== null) {
          const point = {
            lat: lat,
            lng: lng,
            
          };
      
          event.target.reset();
      
          // Crear el punto geografico
          const dataGeografico = {
            latitude: point.lat,
            longitude: point.lng,
            status: "Activo",
          };
      
          const puntoGeografico = await modifyZoneModel.handleCreatePointSQLGeografico(dataGeografico);
      
          // Crear el punto de la zona
          

          const dataPuntoZona = {
            zona: {id: zona},
            punto: { id: puntoGeografico.id}
          };
          modifyZoneModel.handleCreatePointSQLZona(dataPuntoZona);
      
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
    const handleDeletePoint = (punto, zona) => { 
        const data = {
            latitude: punto.lat,
            longitude: punto.lng,
            id: punto.id,
            status: "Inactivo"
        };
        modifyZoneModel.handleDeletePointSQL(data, zona);
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
    const handleGetPoints = async (id) => {
        const jsonDataString = await modifyZoneModel.fetchDataPoints(id);
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    //Obtener datos de la zona
    const handleGetZones = async (id) => {
        const jsonDataString = await modifyZoneModel.fetchDataZones(id);
        console.log("La data", jsonDataString);
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