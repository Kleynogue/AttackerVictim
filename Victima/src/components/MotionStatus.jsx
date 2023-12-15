import React, { useState, useEffect, useRef } from 'react';
import { Text, View } from 'react-native';
import { setUpdateIntervalForType, SensorTypes, accelerometer } from 'react-native-sensors';

import MotionStatusViewmodel from '../viewmodel/MotionStatusViewmodel';

import styles from '../styles/MotionStatus';

const MotionStatus = () => {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);
    const [isMoving, setIsMoving] = useState(false);

    const prevX = useRef(0);
    const prevY = useRef(0);
    const prevMoving = useRef(false);

    const motionStatusViewmodel = MotionStatusViewmodel();

    useEffect(() => {
        setUpdateIntervalForType(SensorTypes.accelerometer, 1000);

        const subscription = accelerometer.subscribe(({ x, y, z, timestamp }) => {
            motionStatusViewmodel.handleMotion(setX, setY, setIsMoving, prevMoving, prevX, prevY, x, y, z);
        });

        
        const intervalId = setInterval(() => { 
            motionStatusViewmodel.handleSendMotionAlert();
        }, 5000);

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