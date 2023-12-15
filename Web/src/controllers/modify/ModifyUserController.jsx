import ModifyUserModel from '../../models/modify/ModifyUserModel';

const ModifyUserController = () => {

    const modifyUserModel = ModifyUserModel();

    const handleDelete = (id) => { 
        modifyUserModel.handleDeleteSQL(id);
    };

    const handleGet = async (id) => {
        const jsonDataString = await modifyUserModel.fetchData();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
          const jsonData = JSON.parse(jsonDataString);
          return(jsonData);
          //console.log("========= ", jsonData.nombre);
        }
    };

    const handleActualizar = (event,id) => {
        event.preventDefault();
        
        const nombre = event.target.elements.UserNombre.value;
        const apellido = event.target.elements.UserApellido.value;
        const ususario = event.target.elements.UserUsuario.value;
        const password = event.target.elements.UserPassword.value;
        const direccion = event.target.elements.UserDireccion.value;

        const formData = new FormData(event.target);
        const tipo = formData.get('UserTipo');  
        
        modifyUserModel.handleUpdateSQL(id);

        if(nombre){
            console.log('Se actualiza el nombre: '+ nombre);
        }
        if(apellido){
            console.log('Se actualiza el apellido: '+ apellido);
        }
        if(ususario){
            console.log('Se actualiza el ususario: '+ ususario);
        }
        if(password){
            console.log('Se actualiza la password: '+ password);
        }
        if(direccion){
            console.log('Se actualiza la direccion: '+ direccion);
        }
        if(tipo && tipo!=='empty'){
            console.log('Se actualiza el tipo: '+ tipo);
        }
        else{
            console.log('Tipo: NO FUE SELECCIONADO');
        }
    };


    return {
        handleDelete,
        handleGet,
        handleActualizar
    };
};

export default ModifyUserController;