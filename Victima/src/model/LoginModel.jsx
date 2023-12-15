const LoginModel = (navigation) => {

    const handleValidarUser = (user, password) => {

        console.log('Este metodo debe validar el usuario y contrasena'); 
        navigation.navigate('Main');
        /*
        // Ejemplo de validación
        if (user === 'admin' && password === '1234') {
            // Redirigir a otra ventana
            navigation.navigate('Main');
        } else {
            // Mostrar alerta en caso de credenciales incorrectas
            alert('Credenciales incorrectas');
        }*/
    };
    return {
        handleValidarUser,
    };
};
export default LoginModel;