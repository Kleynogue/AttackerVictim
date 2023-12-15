import CreateCaseModel from '../../models/create/CreateCaseModel';

const CreateCaseController = () => {

    const createCaseModel = CreateCaseModel();

    const handleCreate = (event) => {
        event.preventDefault();
        
        const atacante = event.target.elements.CaseAtacante.value;
        const victima = event.target.elements.CaseVictima.value;
        const distancia = event.target.elements.CaseDistancia.value;
        const tiempo = event.target.elements.CaseTiempo.value;
        const inicio = event.target.elements.CaseInicio.value;
        const final = event.target.elements.CaseFinal.value;
        const status = event.target.elements.CaseStatus.value;
        
        createCaseModel.handleCreateSQL();

        if(atacante){
            console.log('Atacante: '+ atacante);
        }
        if(victima){
            console.log('Victima: '+ victima);
        }
        if(distancia){
            console.log('Distancia: '+ distancia);
        }
        if(tiempo){
            console.log('Tiempo: '+ tiempo);
        }
        if(inicio){
            console.log('Inicio: '+inicio );
        }
        if(final){
            console.log('Final: '+ final);
        }
        if(status){
            console.log('Status: '+ status);
        }
        
    };

    return {
        handleCreate,
    };
};

export default CreateCaseController;