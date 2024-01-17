import { useNavigate } from 'react-router-dom';
import CasesModel from '../../models/show/CasesModel';

const CasesController = () => {
    const navigate = useNavigate();
    const casesModel = CasesModel();

    const handleRowClick = (caso,user) => {

        const queryParams = new URLSearchParams({
            usuario: user,
            caso: caso.id,
        });

        navigate('/modificar-caso' + `?${queryParams.toString()}`);
    };

    const handleGet = async (token) => {
        const jsonDataString = await casesModel.fetchData(token);
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

export default CasesController;