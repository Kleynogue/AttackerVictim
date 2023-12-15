import { useNavigate } from 'react-router-dom';
import UsersModel from '../../models/show/UsersModel';

const UsersController = () => {
    const navigate = useNavigate();
    const usersModel = UsersModel();

    const handleRowClick = (usuario) => {
        navigate('/modificar-usuario/' + usuario.id);
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