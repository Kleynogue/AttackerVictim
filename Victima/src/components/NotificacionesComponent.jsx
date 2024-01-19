import React, { useEffect } from 'react';
import { View, Text } from 'react-native';
import NotificationModel from '../model/NotificationModel';

const NotificacionesComponent = () => {
    const notificationModel = NotificationModel();

    useEffect(() => {
        notificationModel.handleNotification();
    }, []);

    return (
        <View>
            <Text>Componente de Notificaciones</Text>
        </View>
    );
};

export default NotificacionesComponent;

