import auth from '@react-native-firebase/auth';
import messaging from '@react-native-firebase/messaging';

const LoginModel = (navigation) => {
    const handleValidarUser = async (email, password) => {
        try {
            const userCredential = await auth().signInWithEmailAndPassword(email, password);
            const user = userCredential.user;
            console.log('este es el uid', user.uid); // Imprimir el UID del usuario
           
            navigation.navigate('Main');

            

            const fcmToken = await messaging().getToken();
      if (fcmToken) {
        console.log('este es el fcmToken',fcmToken);
      }

    

        } catch (error) {
            console.log('Error al validar el usuario y contraseña:', error);
        }
    };
    return {
        handleValidarUser,
    };
};
export default LoginModel;





