import { StyleSheet } from 'react-native';

const styles = StyleSheet.create({
    mainContenedor: {
        flex: 1,  
        height:'100%',
        backgroundColor: '#F2F2F2',
        alignItems: 'center',
    },
    mainSubContenedor: {
        backgroundColor: '#FFFFFF',
        width: '85%',
        height:'20%',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 16,
        borderWidth: 3, 
        borderColor: '#2C2C2C', 
        borderRadius: 4,
    },
    mainSubContenedorAlerta: {
        backgroundColor: '#FFFFFF',
        width: '85%',
        height:'25%',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 16,
        borderWidth: 3, 
        borderColor: '#2C2C2C', 
        borderRadius: 4,
    },
    mainSubContenedorMapa: {
        backgroundColor: '#FFFFFF',
        width: '85%',
        margin: 25,
        height: 350,
    },
    mainSubContenedorWifi: { 
        margin: 5
    },
    mainSubContenedorMotion: {
        margin: 5
    },
    mainSubContenedorSos: {
        flex: 1,
        justifyContent: 'flex-end',
        alignItems: 'flex-end',
    },
    mainSubContenedorCountdown: {
        width: '85%',
        justifyContent: 'center',
        alignItems: 'center',
    },
});

export default styles;