import ModifyCaseModel from '../../models/modify/ModifyCaseModel';

const ModifyCaseController = () => {

    const modifyCaseModel = ModifyCaseModel();

    const handleDelete = (id) => { 
        modifyCaseModel.handleDeleteSQL(id);
    };

    const handleUpdate = (event,id) => {
        event.preventDefault();
        
        const atacante = event.target.elements.CaseAtacante.value;
        const victima = event.target.elements.CaseVictima.value;
        const distancia = event.target.elements.CaseDistancia.value;
        const tiempo = event.target.elements.CaseTiempo.value;
        const inicio = event.target.elements.CaseInicio.value;
        const final = event.target.elements.CaseFinal.value;
        const status = event.target.elements.CaseStatus.value;
        
        modifyCaseModel.handleUpdateSQL(id);

        if(atacante){
            console.log('Se actualiza el atacante: '+ atacante);
        }
        if(victima){
            console.log('Se actualiza el victima: '+ victima);
        }
        if(distancia){
            console.log('Se actualiza el distancia: '+ distancia);
        }
        if(tiempo){
            console.log('Se actualiza el tiempo: '+ tiempo);
        }
        if(inicio){
            console.log('Se actualiza el inicio: '+inicio );
        }
        if(final){
            console.log('Se actualiza el final: '+ final);
        }
        if(status && status!=='empty'){
            console.log('Se actualiza status: '+ status);
        }
        else{
            console.log('Tipo: NO FUE SELECCIONADO');
        }

    };


    const handleGetCase = async (id) => {
        const jsonDataString = await modifyCaseModel.fetchDataCase();
        //console.log("La data", jsonDataString);
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