import CreateUserModel from '../../models/create/CreateUserModel';

const CreateUserController = () => {

    const createUserModel = CreateUserModel();

    const handleCreate = (event) => {
        event.preventDefault();
        
        const nombre = event.target.elements.UserNombre.value;
        const apellido = event.target.elements.UserApellido.value;
        const ususario = event.target.elements.UserUsuario.value;
        const password = event.target.elements.UserPassword.value;
        const direccion = event.target.elements.UserDireccion.value;

        const formData = new FormData(event.target);
        const tipo = formData.get('UserTipo');
        
        createUserModel.handleCreateSQL();

        if(nombre){
            console.log('Nombre: '+ nombre);
        }
        if(apellido){
            console.log('Apellido: '+ apellido);
        }
        if(ususario){
            console.log('Ususario: '+ ususario);
        }
        if(password){
            console.log('Password: '+ password);
        }
        if(direccion){
            console.log('Direccion: '+ direccion);
        }
        if(tipo && tipo!=='empty'){
            console.log('Tipo: '+ tipo);
        }
        else{
            console.log('Tipo: NO FUE SELECCIONADO');
        }
       
    };
    

    return {
        handleCreate,
    };
};

export default CreateUserController;