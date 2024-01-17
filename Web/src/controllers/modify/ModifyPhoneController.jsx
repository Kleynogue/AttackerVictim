import ModifyPhoneModel from '../../models/modify/ModifyPhoneModel';
import ModifyUserModel from '../../models/modify/ModifyUserModel';

const ModifyPhoneController = () => {

    const modifyPhoneModel = ModifyPhoneModel();
    const modifyUserModel = ModifyUserModel();

    const handleDelete = (id) => { 
        modifyPhoneModel.handleDeleteSQL(id);
    };

    const handleGet = async (id) => {
        const jsonDataString = await modifyPhoneModel.fetchData(id);
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
          const jsonData = JSON.parse(jsonDataString);
          return(jsonData);
          //console.log("========= ", jsonData.nombre);
        }
    };

    const handleActualizar = async (event,id,phone) => {
        event.preventDefault();

        //const numero = event.target.elements.PhoneNumer.value;
        const bluetooth = event.target.elements.PhoneBluetooth.value;
        //const usuario = event.target.elements.PhoneUsuario.value;
        //const caso = event.target.elements.PhoneCaso.value;
        //const inicio = event.target.elements.CaseInicio.value;
        //const final = event.target.elements.CaseFinal.value;

        // Se crea un objeto JSON vacío
        const data = {};

        data.fechaInicio = phone.inicio;
        data.fechaFin = phone.final;
        data.usuario = {persona: {id: phone.caso},id: phone.idUsuario};
        data.querella = {id: phone.caso};
        data.id = id;

        if(bluetooth){
            console.log('Se actualiza el bluetooth: '+ bluetooth);
            const bluetoothValido = await modifyPhoneModel.getTelefonoByBluetooth(bluetooth);
            if(bluetoothValido){
                console.log("El valor SI es valido");
                data.bluetooth = bluetooth;
                modifyPhoneModel.handleUpdateSQL(data);
            }
            else{
                alert("El valor no es valido");
            }
            
        }

        /*if(numero){
            console.log('Se actualiza el numero: '+ numero);
        }
        if(usuario){
            console.log('Se actualiza el ususario: '+ usuario);
        }
        if(caso){
            console.log('Se actualiza el caso: '+ caso);
        }*/
    };


    return {
        handleDelete,
        handleGet,
        handleActualizar
    };
};

export default ModifyPhoneController;