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



    const {bluetoothId, usuario, telefono, tiempo, tipo} = route.params;
    /*const [user, setUser] = useState(null);
    const [tiempo, setTiempo] = useState(null);
    const [telefono, setTelefono] = useState(null);
    const [tipo, setTipo] = useState(null);*/
    const mainViewModel = MainViewModel();

    /*useEffect(() => {
        
        mainViewModel.handleGetData(bluetoothId)
        .then((jsonData) => {
            setTipo(jsonData.usuario.tipo);
            setUser(jsonData.usuario.persona.name +" "+ jsonData.usuario.persona.lastName);
            setTelefono(jsonData.id);
            setTiempo(jsonData.querella.tiempoControl);
            console.log("1) "+jsonData.usuario.tipo);
            console.log("2) "+jsonData.usuario.persona.name +" "+ jsonData.usuario.persona.lastName);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);*/

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
                   <MapComponent telefono={telefono}/> 
                </View>

                <View>
                   <User user={usuario} tipo={tipo} dispositivo={telefono} />
                </View>

                <View style={styles.mainSubContenedorSos}>
                   <Sos telefono={telefono}/>
                </View>
            </View>
            
            <View style={styles.mainSubContenedorAlerta}>
                <View style={styles.mainSubContenedorCountdown}>
                    <Countdown tiempo={tiempo} telefono={telefono}/>
                </View>     
            </View>

        </View>
    );
}

export default Main