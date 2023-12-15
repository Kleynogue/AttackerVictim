import { useNavigate } from 'react-router-dom';

const LoginFormModel = () => {
    
    const navigate = useNavigate();

    const handleValidarUser = (user, password) => {
        console.log('Este metodo debe validar el usuario y contrasena'); 

        // Ejemplo de validación
        if (user === 'admin' && password === '1234') {
            // Redirigir a otra ventana
            navigate('/menu');
        } else {
            // Mostrar alerta en caso de credenciales incorrectas
            alert('Credenciales incorrectas');
        }
    };

    return {
        handleValidarUser,
    };
};

export default LoginFormModel;