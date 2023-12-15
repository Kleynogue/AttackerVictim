import { useNavigate } from 'react-router-dom';
import ZonesModel from '../../models/show/ZonesModel';

const ZonesController = () => {
    const navigate = useNavigate();
    const zonesModel = ZonesModel();

    const handleRowClick = (zona) => {
        navigate('/modificar-zona/' + zona.id);
    };

    const handleGet = async () => {
        const jsonDataString = await zonesModel.fetchData();
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

export default ZonesController;