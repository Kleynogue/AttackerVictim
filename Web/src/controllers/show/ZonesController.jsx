import { useNavigate } from 'react-router-dom';
import ZonesModel from '../../models/show/ZonesModel';

const ZonesController = () => {
    const navigate = useNavigate();
    const zonesModel = ZonesModel();

    const handleRowClick = (zona,casoId,usuario) => {
        const queryParams = new URLSearchParams({
            usuario: usuario,
            caso: casoId,
            zona: zona.id,
        });
        navigate('/modificar-zona/' + `?${queryParams.toString()}`);
    };

    const handleGet = async (caso) => {
        const jsonDataString = await zonesModel.fetchData(caso);
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