import { useNavigate } from 'react-router-dom';
import API_URL from '../../service/api';
const LoginFormModel = () => {

    const navigate = useNavigate();
/*
    const handleValidarUser = async (userData, setUsuario) => {
        console.log('Este metodo debe validar el usuario y contrasena'); 

        try {
            console.log("00000000");
            const response = await fetch('http://localhost:8080/cmcapp-backend-1.0/api/v1/login', {
              method: 'POST',
              headers: {
                'Content-Type': 'application/json'
              },
              body: JSON.stringify(userData)
            });
       
            if (response.ok) {

              const id = 88;
              const queryParams = new URLSearchParams({
                usuario: id,
                });
                navigate('/casos'+`?${queryParams.toString()}`);

              /////////
            } else {
              console.error('1) Error al validar el usuario:', response.status);
            }
          } catch (error) {
            console.error('2)Error al validar el usuario:', error);
          }



        /*
        const id = 88;

        // Ejemplo de validación
        if (user === 'admin' && password === '1234') {
            // Redirigir a otra ventana
            const queryParams = new URLSearchParams({
                usuario: id,
            });
            navigate('/casos'+`?${queryParams.toString()}`);
        } else {
            // Mostrar alerta en caso de credenciales incorrectas
            alert('Credenciales incorrectas');
        }
     };*/







     const handleValidarUser = async (userData, setUsuario) => {
        console.log('Este método debe validar el usuario y contraseña');
      
        try {
          const response = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/login', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
          });
      
          if (response.ok) {
            const token = response.headers.get('Authorization'); // Obtener el token de acceso del encabezado
            const responseAux = await fetch(API_URL+'cmcapp-backend-1.0/api/v1/query/usuario/1?username=' + userData.username);
            const jsonDataAux = await responseAux.json();

            if(jsonDataAux.tipo==="Administrador"){
                const queryParams = new URLSearchParams({
                    usuario: token,
                });
                navigate('/casos'+`?${queryParams.toString()}`);
            }
            else{
                alert("No cuenta con los privilegios");
            }
      /*
            // Realizar otras solicitudes a la API incluyendo el token en el encabezado de autorización
            const otraRespuesta = await fetch('http://localhost:8080/cmcapp-backend-1.0/api/v1/otra-ruta', {
              headers: {
                'Authorization': token
              }
            });
      
            if (otraRespuesta.ok) {
              // Manejar la respuesta de la solicitud
              navigate('/casos');
            } else {
              console.error('Error al realizar la otra solicitud:', otraRespuesta.status);
            }*/
            

          } else {
            alert("Credenciales invalidas");
          }
        } catch (error) {
          console.error('Error al validar el usuario:', error);
        }
      };



    return {
        handleValidarUser,
    };
};

export default LoginFormModel;