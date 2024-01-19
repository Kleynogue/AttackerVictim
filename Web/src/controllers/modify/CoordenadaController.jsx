import CoordenadaModel from '../../models/modify/CoordenadaModel';
import geolib from 'geolib';
const CoordenadaController = () => {

    const coordenadaModel = CoordenadaModel();

    const handleGetCoordenada = async (id) => {
        const jsonDataString = await coordenadaModel.fetchDataCoordenadaParticipante(id);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            //console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    const handleGetZonas = async (id) => {
        
        const jsonDataString = await coordenadaModel.fetchDataZonas(id);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            //console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    const handleGetZonaID = async (id) => {
        const jsonDataString = await coordenadaModel.fetchDataZonaID(id);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            //console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    const verificarCoordenadaEnZonaSeguridad = (latitud, longitud, zonasDeSeguridad) => {
        console.log(latitud, longitud, zonasDeSeguridad);
        const punto = { latitude: latitud, longitude: longitud };
        
        for (const zona of zonasDeSeguridad) {
          const dentroDeZonaSeguridad = geolib.isPointInside(punto, zona.coordinates);
          
          if (dentroDeZonaSeguridad) {
            return true; // La coordenada se encuentra dentro de al menos una zona de seguridad
          }
        }
        
        return false; // La coordenada no se encuentra dentro de ninguna zona de seguridad
    };


    return {
        handleGetCoordenada,
        handleGetZonas,
        handleGetZonaID,
        verificarCoordenadaEnZonaSeguridad
    };
};

export default CoordenadaController;