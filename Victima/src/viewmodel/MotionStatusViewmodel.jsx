import MotionStatusModel from '../model/MotionStatusModel';
import ArchiveViewmodel from '../viewmodel/ArchiveViewModel';
import NetInfo from '@react-native-community/netinfo';
const MotionStatusViewmodel = () => {
    const motionStatusModel = MotionStatusModel();
    const archiveViewmodel = ArchiveViewmodel();

    const handleMotionAlert = (hasPositionChanged) => {  

        //Fecha y hora actual
        var date = new Date(),
        formattedDate = [
          date.getMonth() + 1,
          date.getDate(),
          date.getFullYear()
        ].join('/') + ' ' +
        [
          date.getHours(),
          date.getMinutes(),
          date.getSeconds()
        ].join(':');

        //Armamos el json
        const data = {
            hasPositionChanged,
            formattedDate,
        };
        
        archiveViewmodel.saveDataToJsonFile(data, "/motion.txt");
        
    };

    const handleMotion = (setX, setY, setIsMoving, prevMoving, prevX, prevY, x, y, z) => {
        setX(x);
        setY(y);
      
        // Verificar si ha cambiado la posición basado en los valores de x, y
        const motionThreshold = 0.5; // Umbral de movimiento (ajusta según tus necesidades)
        const hasPositionChanged = Math.abs(prevX.current - x) > motionThreshold || Math.abs(prevY.current - y) > motionThreshold;
        
        //La alerta solo sera enviada en el primer momento que se encuentre sin movimiento, luego debera
        //retomar el movimiento nuevamente para poder mandar la alerta 
        if((!hasPositionChanged && prevMoving.current) || (hasPositionChanged && !prevMoving.current)){ 
            handleMotionAlert(hasPositionChanged) 
        }

        setIsMoving(hasPositionChanged);
        // Actualizar los valores previos
        prevX.current = x;
        prevY.current = y;
        prevMoving.current = hasPositionChanged;
    };

    const handleSendMotionAlert = async () => {  
        const isConnected = await checkWifiStatus();
        if(isConnected){
            motionStatusModel.handleMotionAlertSQL("/motion.txt");
        }   
    };

    const checkWifiStatus = async () => {
        const netInfoState = await NetInfo.fetch();
        return netInfoState.isConnected;
    };

    return {
        handleMotionAlert,
        handleMotion,
        handleSendMotionAlert
    };
};

export default MotionStatusViewmodel;