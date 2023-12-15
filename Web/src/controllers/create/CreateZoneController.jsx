import CreateZoneModel from '../../models/create/CreateZoneModel';

const CreateZoneController = () => {

    const createZoneModel = CreateZoneModel();

    const handleCreate = (event) => {
        event.preventDefault();
        
        const nombre = event.target.elements.ZoneNombre.value;

        createZoneModel.handleCreateSQL();
        
        if(nombre){
            console.log('Nombre: '+ nombre);
        }
    };

    return {
        handleCreate,
    };
};

export default CreateZoneController;