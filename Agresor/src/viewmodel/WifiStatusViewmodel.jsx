import WifiStatusModel from '../model/WifiStatusModel';
import ArchiveViewmodel from '../viewmodel/ArchiveViewModel';
import NetInfo from '@react-native-community/netinfo';

const WifiStatusViewmodel = () => {
    const wifiStatusModel = WifiStatusModel();
    const archiveViewmodel = ArchiveViewmodel();

    const handleStatusAlert = (status) => {  

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
            status,
            formattedDate,
        };
        
        archiveViewmodel.saveDataToJsonFile(data, "/wifi.txt");
        
    };

    const checkWifiStatus = async (setIsConnected, prevStatus) => {
        const netInfoState = await NetInfo.fetch();

        if((netInfoState.isConnected && !prevStatus) || (!netInfoState.isConnected && prevStatus)){
            //console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            handleStatusAlert(netInfoState.isConnected);
        }

        setIsConnected(netInfoState.isConnected);

        if(netInfoState.isConnected){
            wifiStatusModel.handleStatusAlertSQL("/motion.txt");
        }

        prevStatus.current = netInfoState.isConnected;
    };


    return {
        checkWifiStatus,
    };
};

export default WifiStatusViewmodel;