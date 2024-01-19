import LoginModel from '../model/LoginModel';

const LoginViewmodel = (navigation) => {

    const loginModel = LoginModel(navigation);

    const handleLogin = async (username,password, blueTooth) => {

       /* const userData = {
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
                                            tipo: blueToothValido.usuario.tipo,
                                            caso: blueToothValido.querella.id});
            }
            else{
               alert("BlueTooth no valido") 
            }
        }
        else{
            alert("User no valido");
        }*/


        const userData = {
            username: username,
            password: password
        };

        const userPassword = await loginModel.handleValidarUser(userData);
        
        if(userPassword){
            console.log("User valido");
            const blueToothValido = await loginModel.handleValidarBluetooth(blueTooth);
            console.log(blueToothValido);
            if(blueToothValido.id && blueToothValido.usuario.username === username && blueToothValido.usuario.tipo === "Agresor"){
                console.log("Si es valido");
                navigation.navigate('Main', {bluetoothId: blueTooth, 
                                            usuario: blueToothValido.usuario.persona.name +" " +blueToothValido.usuario.persona.lastName,
                                            telefono: blueToothValido.id,
                                            tiempo: blueToothValido.querella.tiempoControl,
                                            tipo: blueToothValido.usuario.tipo,
                                            caso: blueToothValido.querella.id});
            }
            else{
               alert("Bluetooth o rol invalido");
            }
        }
        else{
            alert("User o password invalida");
        }
    };
    
    return {
        handleLogin
    };
};

export default LoginViewmodel;