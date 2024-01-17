import React, { useState, useEffect, useRef } from 'react';
import {View, Text } from 'react-native';

import WifiStatusViewmodel from '../viewmodel/WifiStatusViewmodel';
import MainViewModel from '../viewmodel/MainViewModel';

import styles from '../styles/WifiStatus';

const WifiStatus = ({dispositivo}) => {
    const [isConnected, setIsConnected] = useState(true);
    const wifiStatusViewmodel = WifiStatusViewmodel();
    const mainViewModel = MainViewModel();
    const prevStatus = useRef(false);
    console.log('-------Valor de telefono:', dispositivo);

    useEffect(() => {
        const intervalId = setInterval(() => { 
            //wifiStatusViewmodel.checkWifiStatus(setIsConnected,prevStatus);

            var date = new Date();
            var formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;
    

            let dataWifi = {
                date: formattedDate,
                telefono: {id: dispositivo}
            };

            console.log("--++> "+JSON.stringify(dataWifi));

            mainViewModel.handleCreateWifi(dataWifi);

        }, 10000);
  
        return () => clearInterval(intervalId);
    }, []);

    return (
        <View style={styles.wifiContainer}>
            <Text style={styles.wifiEstado}>Wi-Fi Status: {isConnected ? 'Connected' : 'Disconnected'}</Text>
        </View>
    );
};

export default WifiStatus;