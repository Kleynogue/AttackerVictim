import CreateZoneModel from '../../models/create/CreateZoneModel';
import { useNavigate } from 'react-router-dom';

const CreateZoneController = () => {

    const createZoneModel = CreateZoneModel();
    const navigate = useNavigate();

    const handleCreate = (event,queryParams) => {
        event.preventDefault();

        const nombre = event.target.elements.ZoneNombre.value;

        const data = {
            nombre: nombre,
            caso: queryParams.get("caso")
        };

        // Se crea un objeto JSON vacío
        const dataZone = {};
        if (nombre) {
            dataZone.name = nombre;
            dataZone.querella = { id:queryParams.get("caso")};
            createZoneModel.handleCreateSQL(queryParams, dataZone);
        } 
        else{
            alert('Error');
        }
        /*alert('La zona se crea con exito');
        navigate("/zonas" + `?${queryParams.toString()}`);*/
    };

    return {
        handleCreate,
    };
};

export default CreateZoneController;