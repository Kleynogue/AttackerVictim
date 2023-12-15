import {TouchableOpacity, Text } from 'react-native';

import SosViewmodel from '../viewmodel/SosViewmodel';

import styles from '../styles/Sos';

const Sos = () => {

    const sosViewmodel = SosViewmodel();

    return (
        <TouchableOpacity style={styles.loginContenedorBoton} onPress={sosViewmodel.handleAlert}>
            <Text style={styles.loginBoton}>SOS</Text>
        </TouchableOpacity>  
    );
};

export default Sos;