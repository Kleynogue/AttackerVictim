import { useNavigate } from 'react-router-dom';
import CasesModel from '../../models/show/CasesModel';

const CasesController = () => {
    const navigate = useNavigate();
    const casesModel = CasesModel();

    const handleRowClick = (caso) => {
        navigate('/modificar-caso/' + caso.id);
    };

    const handleGet = async () => {
        const jsonDataString = await casesModel.fetchData();
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