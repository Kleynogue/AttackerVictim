import SosModel from '../model/SosModel';

const SosViewmodel = () => {

    const sosModel = SosModel();

    const handleAlert = () => {
        alert('Alerta enviada a las autoridades');
        sosModel.handleAlertSQL();
    };
    
    return {
        handleAlert
    };
};

export default SosViewmodel;