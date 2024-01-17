import MainModel from '../model/MainModel';


const MainViewModel = () => {

    const mainModel = MainModel();


    const handleCreatePosition = async (data) => {
            const punto = await mainModel.handleCreateSQLPunto(data);
            return punto.id;
    };

    const handleCreateHistoricoPunto = async (idPunto, telefono) => {

        var date = new Date();
        var formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;

        const dataPosicion = {
            fechaInicio: formattedDate,
            fechaFin: formattedDate,
            telefono: {id: telefono},
            puntoGeografico: {id: idPunto}     
        };
        //console.log("++> "+JSON.stringify(dataPosicion));
        const pos = await mainModel.handleCreateSQLPosicion(dataPosicion);
        
    };

    const handleCreateReporte = async (idPunto, tipo, telefono) => {

        var date = new Date();
        var formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;


        const dataPosicion = {
            date: formattedDate,
            type: tipo,
            telefono: {id: telefono},
            puntoGeografico: {id: idPunto}     
        };
        //console.log("REPORTE++> "+JSON.stringify(dataPosicion));
        const pos = await mainModel.handleCreateSQLReporte(dataPosicion);
        
    };

    const handleCreateMove = async (data) => {

        const punto = await mainModel.handleCreateSQLMovimiento(data);

    };

    const handleCreateWifi = async (data) => {

        const punto = await mainModel.handleCreateSQLWifi(data);

    };

    const handleGetData = async (blueTooth) => {

        const data = await mainModel.handleValidarBluetooth(blueTooth);
        return data;
    };

    return {
        handleCreatePosition,
        handleCreateHistoricoPunto,
        handleCreateReporte,
        handleCreateMove,
        handleCreateWifi,
        handleGetData
    };
};

export default MainViewModel;