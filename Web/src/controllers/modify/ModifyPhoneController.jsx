import ModifyPhoneModel from '../../models/modify/ModifyPhoneModel';

const ModifyPhoneController = () => {

    const modifyPhoneModel = ModifyPhoneModel();

    const handleDelete = (id) => { 
        modifyPhoneModel.handleDeleteSQL(id);
    };

    const handleGet = async (id) => {
        const jsonDataString = await modifyPhoneModel.fetchData();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
          const jsonData = JSON.parse(jsonDataString);
          return(jsonData);
          //console.log("========= ", jsonData.nombre);
        }
    };

    const handleActualizar = (event,id) => {
        event.preventDefault();

        const numero = event.target.elements.PhoneNumer.value;
        const bluetooth = event.target.elements.PhoneBluetooth.value;
        const usuario = event.target.elements.PhoneUsuario.value;
        const caso = event.target.elements.PhoneCaso.value;

        modifyPhoneModel.handleUpdateSQL(id);

        if(numero){
            console.log('Se actualiza el numero: '+ numero);
        }
        if(bluetooth){
            console.log('Se actualiza el bluetooth: '+ bluetooth);
        }
        if(usuario){
            console.log('Se actualiza el ususario: '+ usuario);
        }
        if(caso){
            console.log('Se actualiza el caso: '+ caso);
        }
        
    };


    return {
        handleDelete,
        handleGet,
        handleActualizar
    };
};

export default ModifyPhoneController;