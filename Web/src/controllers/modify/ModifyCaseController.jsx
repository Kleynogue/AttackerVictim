import ModifyCaseModel from '../../models/modify/ModifyCaseModel';

const ModifyCaseController = () => {

    const modifyCaseModel = ModifyCaseModel();

    const handleDelete = (id) => { 
        modifyCaseModel.handleDeleteSQL(id);
    };

    const handleUpdate = (event,id,caso) => {
        event.preventDefault();
        
        //const atacante = event.target.elements.CaseAtacante.value;
        //const victima = event.target.elements.CaseVictima.value;
        const distancia = event.target.elements.CaseDistancia.value;
        const tiempo = event.target.elements.CaseTiempo.value;
        const status = event.target.elements.CaseStatus.value;
        
        // Se crea un objeto JSON vacío
        const data = {};

        // Se agregan los atributos al objeto JSON según las condiciones
        if (distancia) {
            data.distanciaMin = distancia;
        } else {
            data.distanciaMin = caso.distancia;
        }

        if (tiempo) {
            data.tiempoControl = tiempo;
        } else {
            data.tiempoControl = caso.tiempo;
        }

        if (status && status !== 'empty') {
            console.log('Se actualiza status: ' + status);
            data.status = status;
        } else {
            console.log('Tipo: NO FUE SELECCIONADO');
            data.status = caso.status;
        }

        data.id = id;

        modifyCaseModel.handleUpdateSQL(data);
        

    };


    const handleGetCase = async (id) => {
        const jsonDataString = await modifyCaseModel.fetchDataCase(id);
        console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
            
        }
    };

    const handleGetParticipante = async (id) => {
        const jsonDataString = await modifyCaseModel.fetchDataParticipante(id);
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            console.log("========= ", jsonData);
            return(jsonData);
            
        }
    };


    return {
        handleGetParticipante,
        handleGetCase,
        handleDelete,
        handleUpdate,
    };
};

export default ModifyCaseController;