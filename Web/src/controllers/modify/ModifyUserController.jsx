import e from 'cors';
import ModifyUserModel from '../../models/modify/ModifyUserModel';

const ModifyUserController = () => {

    const modifyUserModel = ModifyUserModel();

    const handleDelete = (id) => { 
        modifyUserModel.handleDeleteSQL(id);
    };

    const handleGet = async (id) => {
        const jsonDataString = await modifyUserModel.fetchData(id);
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
          const jsonData = JSON.parse(jsonDataString);
          return(jsonData);
          //console.log("========= ", jsonData.nombre);
        }
    };

    const handleActualizar = async (event,id,participante) => {
        event.preventDefault();
        
        const nombre = event.target.elements.UserNombre.value;
        const apellido = event.target.elements.UserApellido.value;
        const ususario = event.target.elements.UserUsuario.value;
        //const password = event.target.elements.UserPassword.value;
        const direccion = event.target.elements.UserDireccion.value;

        /*const formData = new FormData(event.target);
        const tipo = formData.get('UserTipo');  */

        // Se crea un objeto JSON vacío
        const data = {};

        if(nombre){
            console.log('Se actualiza el nombre: '+ nombre);
            data.name = nombre;
        }
        else{
            data.name = participante.nombre;
        }
        if(apellido){
            console.log('Se actualiza el apellido: '+ apellido);
            data.lastName = apellido;
        }
        else{
            data.lastName = participante.apellido;
        }
        if(direccion){
            console.log('Se actualiza la direccion: '+ direccion);
            data.address = direccion;
        }
        else{
            data.address = participante.direccion;
        }

        data.id = participante.id;

        const persona = await modifyUserModel.handleUpdateSQL(data);

        const dataUser = {};
        if(ususario){
            console.log('Se actualiza el ususario: '+ ususario);
            dataUser.username = ususario;
        }
        else{
            dataUser.username = participante.usuario;
        }
        /*if(tipo && tipo!=='empty'){
            console.log('Se actualiza el tipo: '+ tipo);
            dataUser.tipo = tipo;
        }
        else{
            console.log('Tipo: NO FUE SELECCIONADO');*/
            dataUser.tipo = participante.tipo;
        //}

        dataUser.persona = { id: persona.id };

        dataUser.id = id;

        modifyUserModel.handleUpdateSQLUser(dataUser);

        /*if(password){
            console.log('Se actualiza la password: '+ password);
        }*/

        
    };


    return {
        handleDelete,
        handleGet,
        handleActualizar
    };
};

export default ModifyUserController;