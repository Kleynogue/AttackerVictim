import React from 'react'
import {View} from 'react-native'

import Countdown from '../components/Countdown';
import MapComponent from '../components/MapComponent';
import MotionStatus from '../components/MotionStatus';
import Sos from '../components/Sos';
import WifiStatus from '../components/WifiStatus';

import styles from '../styles/Main';

const Main = () => {
    return(

        <View style={styles.mainContenedor}>

            <View style={styles.mainSubContenedor}>
                <View style={styles.mainSubContenedorWifi}>
                    <WifiStatus/>
                </View>

                <View style={styles.mainSubContenedorMotion}>
                    <MotionStatus/>
                </View>
            </View>

            <View style={styles.mainSubContenedorMapa}>
                <View>
                   <MapComponent/> 
                </View>

                <View style={styles.mainSubContenedorSos}>
                   <Sos/>
                </View>
            </View>
            
            <View style={styles.mainSubContenedorAlerta}>
                <View style={styles.mainSubContenedorCountdown}>
                    <Countdown/>
                </View>     
            </View>

        </View>
    );
}

export default Main