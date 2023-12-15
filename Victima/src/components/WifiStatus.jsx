import React, { useState, useEffect, useRef } from 'react';
import {View, Text } from 'react-native';

import WifiStatusViewmodel from '../viewmodel/WifiStatusViewmodel';

import styles from '../styles/WifiStatus';

const WifiStatus = () => {
    const [isConnected, setIsConnected] = useState(true);
    const wifiStatusViewmodel = WifiStatusViewmodel();
    const prevStatus = useRef(false);

    useEffect(() => {
        const intervalId = setInterval(() => { 
            wifiStatusViewmodel.checkWifiStatus(setIsConnected,prevStatus);
        }, 5000);
  
        return () => clearInterval(intervalId);
    }, []);

    return (
        <View style={styles.wifiContainer}>
            <Text style={styles.wifiEstado}>Wi-Fi Status: {isConnected ? 'Connected' : 'Disconnected'}</Text>
        </View>
    );
};

export default WifiStatus;