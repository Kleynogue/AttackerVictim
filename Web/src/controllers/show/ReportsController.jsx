import { useNavigate } from 'react-router-dom';
import ReportsModel from '../../models/show/ReportsModel';

const ReportsController = () => {
    const navigate = useNavigate();
    const reportsModel = ReportsModel();

    const handleRowClick = (reporte) => {
        navigate('/modificar-reporte/' + reporte.id);
    };

    const handleGet = async () => {
        const jsonDataString = await reportsModel.fetchData();
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

export default ReportsController;