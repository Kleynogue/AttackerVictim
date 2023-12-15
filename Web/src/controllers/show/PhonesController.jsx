import { useNavigate } from 'react-router-dom';
import PhonesModel from '../../models/show/PhonesModel';

const PhoneController = () => {
    const navigate = useNavigate();
    const phonesModel = PhonesModel();

    const handleRowClick = (telefono) => {
        navigate('/modificar-telefono/' + telefono.id);
    };

    const handleGet = async () => {
        const jsonDataString = await phonesModel.fetchData();
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

export default PhoneController;