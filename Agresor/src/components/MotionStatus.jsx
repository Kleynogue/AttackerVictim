import React, { useState, useEffect, useRef } from 'react';
import { Text, View } from 'react-native';
import { setUpdateIntervalForType, SensorTypes, accelerometer } from 'react-native-sensors';

import MotionStatusViewmodel from '../viewmodel/MotionStatusViewmodel';
import MainViewModel from '../viewmodel/MainViewModel';

import styles from '../styles/MotionStatus';

const MotionStatus = ({telefono}) => {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);
    const [z, setZ] = useState(0);
    const [isMoving, setIsMoving] = useState(false);

    const prevX = useRef(0);
    const prevY = useRef(0);
    const prevZ = useRef(0);
    const prevMoving = useRef(false);

    const motionStatusViewmodel = MotionStatusViewmodel();
    const mainViewModel = MainViewModel();
    
    let aux= {x,y,z};

    useEffect(() => {
        setUpdateIntervalForType(SensorTypes.accelerometer, 1000);

        const subscription = accelerometer.subscribe(({ x, y, z, timestamp }) => {
            motionStatusViewmodel.handleMotion(aux, setX, setY, setZ, setIsMoving, prevMoving, prevX, prevY, prevZ, x, y, z);
        });

        
        const intervalId = setInterval(() => { 
            motionStatusViewmodel.handleSendMotionAlert();

            var date = new Date();
            var formattedDate = `${date.getFullYear()}-${(date.getMonth() + 1).toString().padStart(2, '0')}-${date.getDate().toString().padStart(2, '0')} ${date.getHours().toString().padStart(2, '0')}:${date.getMinutes().toString().padStart(2, '0')}:${date.getSeconds().toString().padStart(2, '0')}`;
        

            if(aux){
                let dataIsMoving = {
                    x: aux.x ? 1 : 0,
                    y: aux.y ? 1 : 0,
                    z: aux.z ? 1 : 0,
                    date: formattedDate,
                    telefono: {id: telefono}
                };
                                
                //console.log("--++> "+JSON.stringify(dataIsMoving));
                mainViewModel.handleCreateMove(dataIsMoving);
            }
            
            
        }, 10000);

        return () => { 
            clearInterval(intervalId);
            subscription.unsubscribe(); 
        };
    }, []);

    return (
        <View style={styles.container}>
            <Text style={styles.estado}>{isMoving ? 'Movimiento: Activo' : 'Movimiento: Inactivo'}</Text>
        </View>
    );
};

export default MotionStatus;