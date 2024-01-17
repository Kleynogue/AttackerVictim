import LoginModel from '../model/LoginModel';

const LoginViewmodel = (navigation) => {

    const loginModel = LoginModel(navigation);

    const handleLogin = async (username,password, blueTooth) => {

        const userData = {
            username: 'mariag',
            password: 'maria123'
        };

        const userPassword = await loginModel.handleValidarUser(userData);
        
        if(userPassword){
            console.log("User valido");
            const blueToothValido = await loginModel.handleValidarBluetooth("00:23:45:67:89:01");
            console.log(blueToothValido);
            if(blueToothValido.id && blueToothValido.usuario.username === "mariag"){
                console.log("Si es valido");
                navigation.navigate('Main', {bluetoothId: "00:23:45:67:89:01", 
                                            usuario: blueToothValido.usuario.persona.name,
                                            telefono: blueToothValido.id,
                                            tiempo: blueToothValido.querella.tiempoControl,
                                            tipo: blueToothValido.usuario.tipo});
            }
            else{
               alert("BlueTooth no valido") 
            }
        }
        else{
            alert("User no valido");
        }
    };
    
    return {
        handleLogin
    };
};

export default LoginViewmodel;