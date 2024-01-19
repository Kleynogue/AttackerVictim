import {TouchableOpacity, Text } from 'react-native';

import UserViewmodel from '../viewmodel/UserViewModel';

import styles from '../styles/User';

const User = ({user, tipo, dispositivo}) => {

    const userViewmodel = UserViewmodel();
    
    return (
        <TouchableOpacity style={styles.loginContenedorBoton} onPress={() => userViewmodel.handleAlert(user, tipo, dispositivo)}>
            <Text style={styles.loginBoton}>?</Text>
        </TouchableOpacity>  
    );
};

export default User;