import React, { useState, useEffect } from 'react';
import {View} from 'react-native';

import MainViewModel from '../viewmodel/MainViewModel';

import Countdown from '../components/Countdown';
import MapComponent from '../components/MapComponent';
import MotionStatus from '../components/MotionStatus';
import Sos from '../components/Sos';
import WifiStatus from '../components/WifiStatus';

import styles from '../styles/Main';
import User from '../components/User';

const Main = ({ route }) => {



    const {bluetoothId, usuario, telefono, tiempo, tipo,caso} = route.params;
    const [zonas, setZonas] = useState([]);
    const mainViewModel = MainViewModel();

    useEffect(() => {
        
        mainViewModel.handleGetZonas(caso)
        .then(async (jsonData) => {
            setZonas(jsonData);
            console.log(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);

    return(

        <View style={styles.mainContenedor}>

            <View style={styles.mainSubContenedor}>
                <View style={styles.mainSubContenedorWifi}>
                    <WifiStatus dispositivo={telefono}/>
                </View>

                <View style={styles.mainSubContenedorMotion}>
                    <MotionStatus telefono={telefono}/>
                </View>
            </View>

            <View style={styles.mainSubContenedorMapa}>
                <View>
                   <MapComponent telefono={telefono} polygons={zonas}/> 
                </View>

                <View>
                   <User user={usuario} tipo={tipo} dispositivo={telefono} />
                </View>
                {/* 
                <View style={styles.mainSubContenedorSos}>
                   <Sos telefono={telefono}/>
                </View>*/}
            </View>
            
            {/*<View style={styles.mainSubContenedorAlerta}>
                <View style={styles.mainSubContenedorCountdown}>
                    <Countdown tiempo={tiempo} telefono={telefono}/>
                </View>     
            </View>*/}

        </View>
    );
}

export default Main