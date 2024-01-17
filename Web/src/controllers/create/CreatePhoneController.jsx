import CreatePhoneModel from '../../models/create/CreatePhoneModel';
const CreatePhoneController = () => {

    const createPhoneModel = CreatePhoneModel();

    const handleCreate = (event) => {
        event.preventDefault();
        
        const numero = event.target.elements.PhoneNumer.value;
        const bluetooth = event.target.elements.PhoneBluetooth.value;
        const usuario = event.target.elements.PhoneUsuario.value;
        const caso = event.target.elements.PhoneCaso.value;
        const inicio = event.target.elements.CaseInicio.value;
        const final = event.target.elements.CaseFinal.value;

        createPhoneModel.handleCreateSQL();

        if(numero){
            console.log('Numero: '+ numero);
        }
        if(bluetooth){
            console.log('Bluetooth: '+ bluetooth);
        }
        if(usuario){
            console.log('Ususario: '+ usuario);
        }
        if(caso){
            console.log('Caso: '+ caso);
        }
    };

    return {
        handleCreate,     
    };
};

export default CreatePhoneController;