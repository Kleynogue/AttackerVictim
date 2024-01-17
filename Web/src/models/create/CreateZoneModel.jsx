import API_URL from '../../service/api';
import { useNavigate } from 'react-router-dom';
const CreateZoneModel = () => {

    const navigate = useNavigate();

    const handleCreateSQL = async (queryParams, data) => {
        console.log('Este metodo debe realizar la peticion SQL para crear una zona segura '+ JSON.stringify(data)); 
        const url = API_URL + 'cmcapp-backend-1.0/api/v1/zona-seguridad';
      
        try {
          const response = await fetch(url, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
          });
      
          if (response.ok) {
            alert('La zona se crea con exito');
            //window.location.reload();
            navigate("/zonas" + `?${queryParams.toString()}`);
          } else {
            throw new Error('Error al crear el punto de zona');
          }
        } catch (error) {
          console.log('Error en la solicitud: ', error);
        }
    };

    return {
        handleCreateSQL,
    };
};

export default CreateZoneModel;