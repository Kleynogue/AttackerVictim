import CreateUserModel from '../../models/create/CreateUserModel';
import { useNavigate } from 'react-router-dom';

const CreateUserController = () => {

    const createUserModel = CreateUserModel();
    const navigate = useNavigate();

    const handleCreate = async (event,url) => {
        event.preventDefault();

        const nombre = event.target.elements.UserNombre.value;
        const apellido = event.target.elements.UserApellido.value;
        const usuario = event.target.elements.UserUsuario.value;
        //const password = event.target.elements.UserPassword.value;
        const direccion = event.target.elements.UserDireccion.value;

        const formData = new FormData(event.target);
        const tipo = formData.get('UserTipo');
        
        if(nombre && apellido && usuario && direccion){
            const dataPersona = {
                name: nombre,
                lastName: apellido,
                address: direccion
            };
    
            const persona = await createUserModel.handleCreateSQLPersona(dataPersona);
    
            const dataUsuario = {
                username: usuario,
                //password: password,
                tipo: tipo,
                persona: { id: persona.id}
                
            };
    
            const user = await createUserModel.handleCreateSQLUsuario(dataUsuario);
    
        ///////////////////////////////////////////  
            //Manejo de valores entre pantallas
            let queryParams;
            //Se actualiza el valor del agresor
            if(url.get('tipo')==="caso"){
    
                if(url.get('participante')==="agresor"){
                    queryParams = new URLSearchParams({
                        usuario: url.get('usuario'),
                        tipo: url.get('tipo'),
                        participante: url.get('participante'),
                        agresorSeleccionado: "("+user.id+") " +nombre+" "+apellido,
                        victimaSeleccionada: url.get('victimaSeleccionada'),
                        idAgresorSeleccionado: user.id,
                        idVictimaSeleccionada: url.get('idVictimaSeleccionada'),
                        numeroAgresor: url.get('numeroAgresor'),
                        numeroVictima: url.get('numeroVictima'),
                        bluetoothAgresor: url.get('bluetoothAgresor'),
                        bluetoothVictima: url.get('bluetoothVictima'),
                    });
                }
                //Se actualiza el valor de la victima
                else if(url.get('participante')==="victima"){
                    queryParams = new URLSearchParams({
                        usuario: url.get('usuario'),
                        tipo: url.get('tipo'),
                        participante: url.get('participante'),
                        agresorSeleccionado: url.get('agresorSeleccionado'),
                        victimaSeleccionada: "("+user.id+") " +nombre+" "+apellido,
                        idAgresorSeleccionado: url.get('idAgresorSeleccionado'),
                        idVictimaSeleccionada: user.id,
                        numeroAgresor: url.get('numeroAgresor'),
                        numeroVictima: url.get('numeroVictima'),
                        bluetoothAgresor: url.get('bluetoothAgresor'),
                        bluetoothVictima: url.get('bluetoothVictima'),
                    });
                }
                alert('El usuario se crea con exito');
                navigate("/crear-caso" + `?${queryParams.toString()}`);
            }
            else{
                queryParams = new URLSearchParams({
                    usuario: url.get('usuario'),
                });
                alert('El usuario se crea con exito');
                navigate("/usuarios" + `?${queryParams.toString()}`);
            }   
            ///////////////////////////////////////////  
        }
        else{
            alert('Error');
        }
        
    };
    

    return {
        handleCreate,
    };
};

export default CreateUserController;