import { useNavigate } from 'react-router-dom';
import UsersModel from '../../models/show/UsersModel';

const UsersController = () => {
    const navigate = useNavigate();
    const usersModel = UsersModel();

    const handleRowClick = (participante, usuario) => {
        const queryParams = new URLSearchParams({
            usuario: usuario,
            participante: participante.id
        });
        navigate('/modificar-usuario/' + `?${queryParams.toString()}`);
    };

    const handleGet = async () => {
        const jsonDataString = await usersModel.fetchData();
        //console.log("La data", jsonDataString);
        if (jsonDataString) {
            const jsonData = JSON.parse(jsonDataString);
            return(jsonData);
            //console.log("========= ", jsonData.nombre);
        }
    };


    return {
        handleRowClick,
        handleGet,
    };
};

export default UsersController;