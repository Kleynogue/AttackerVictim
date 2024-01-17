import CreateCaseModel from '../../models/create/CreateCaseModel';
import CreatePhoneModel from '../../models/create/CreatePhoneModel';
import ModifyPhoneModel from '../../models/modify/ModifyPhoneModel';
import { useNavigate } from 'react-router-dom';

const CreateCaseController = () => {

    const createCaseModel = CreateCaseModel();
    const createPhoneModel = CreatePhoneModel();
    const modifyPhoneModel = ModifyPhoneModel();
    const navigate = useNavigate();

    const handleRowClickParticipantes = (participante, setParticipante, setIdParticipante) => {
        const participanteString = ' (' + participante.id + ') ' + participante.nombre + ' ' + participante.apellido;
        setParticipante(participanteString);
        setIdParticipante(participante.id);
    };
        
    const handleCreate = async (event,user , idAgresorSeleccionado, idVictimaSeleccionada, bluetoothAgresor, bluetoothVictima) => {
        event.preventDefault();
        
        const distancia = event.target.elements.CaseDistancia.value;
        const tiempo = event.target.elements.CaseTiempo.value;
        
        const status = event.target.elements.CaseStatus.value;
        console.log(distancia +"&&"+ tiempo +"&&"+ status +"&&"+ bluetoothVictima +"&&"+ idVictimaSeleccionada +"&&"+ bluetoothAgresor +"&&"+ idAgresorSeleccionado);

        //Se debe validar que el bluetooth este disponible
        const bluetoothValidoVictima = await modifyPhoneModel.getTelefonoByBluetooth(bluetoothVictima);
        const bluetoothValidoAgresor = await modifyPhoneModel.getTelefonoByBluetooth(bluetoothAgresor);

        if(distancia && tiempo && status && bluetoothVictima && idVictimaSeleccionada && bluetoothAgresor && idAgresorSeleccionado && bluetoothValidoVictima && bluetoothValidoAgresor){
            const jsonDataCase = {
                distanciaMin: distancia,
                tiempoControl: tiempo,
                status: status
            };
            //Esto me debe devolver el id del caso
            const caso = await createCaseModel.handleCreateSQL(jsonDataCase);
            
            const fechaInicio = new Date();
            // Formatear la fecha manualmente
            const formattedFechaInicio = `${fechaInicio.getFullYear()}-${padZero(fechaInicio.getMonth() + 1)}-${padZero(fechaInicio.getDate())} ${padZero(fechaInicio.getHours())}:${padZero(fechaInicio.getMinutes())}:${padZero(fechaInicio.getSeconds())}`;
            const jsonDataVictima = {
                //numero: numeroVictima,
                bluetooth: bluetoothVictima,
                fechaInicio: formattedFechaInicio, 
                fechaFin: formattedFechaInicio, 
                usuario: {id:idVictimaSeleccionada},
                querella: {id:caso.id},
            };
    
            await createPhoneModel.handleCreateSQL(jsonDataVictima);
    
            const jsonDataAgresor = {
                //numero: numeroAgresor,
                bluetooth: bluetoothAgresor,
                fechaInicio: formattedFechaInicio, 
                fechaFin: formattedFechaInicio,
                usuario: {id:idAgresorSeleccionado},
                querella: {id:caso.id},
            };
    
            await createPhoneModel.handleCreateSQL(jsonDataAgresor);
    
            const queryParamsUser = new URLSearchParams({
                usuario: user,
                caso: caso.id,
            });
            
            alert('El caso se crea con exito');
            navigate("/modificar-caso"+`?${queryParamsUser.toString()}`);
        }
        else{
            alert('Error');
        }
        
    };

    // Función auxiliar para rellenar con ceros
    function padZero(num) {
        return num.toString().padStart(2, '0');
      }



    const handleInputChange = (event, set) => {
        set(event.target.value);
    };

    const handleLoad = (value, set) => {
        if(value!=='null'){
            set(value);
        } 
    };

    //Obtener agresores
    const handleGetAttackers = async () => {
        const jsonDataString = await createCaseModel.fetchDataAttackers();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            //console.log("========= ", jsonData);
            return(jsonData);
        }
    };

    //Obtener victimas
    const handleGetVictims = async () => {
        const jsonDataString = await createCaseModel.fetchDataVictims();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            //console.log("========= ", jsonData);
            return(jsonData);
        }
    };


    return {
        handleRowClickParticipantes,
        handleCreate,
        handleLoad,
        handleInputChange,
        handleGetAttackers,
        handleGetVictims,
    };
};

export default CreateCaseController;