const NotificationModel = () => {
    const handleNotification = async () => {
        
        messaging().onMessage(async remoteMessage => {
            console.log('Mensaje recibido:', remoteMessage);
            // Muestra una notificación
            PushNotification.localNotification({
                title: remoteMessage.data.title,
                message: remoteMessage.data.body
            });
        });
    };

    return {
        handleNotification,
    };
};

export default NotificationModel;

