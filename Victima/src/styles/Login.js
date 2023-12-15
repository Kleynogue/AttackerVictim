import { StyleSheet } from 'react-native';

const styles = StyleSheet.create({
    loginContenedor: {
        height:'100%',
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F2F2F2',
    },
    loginSubContenedor: {
        backgroundColor: '#FFFFFF',
        width: '85%',
        height:'40%',
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 16,
        borderWidth: 3, 
        borderColor: '#2C2C2C', 
        borderRadius: 4,
    },
    loginInput: {
        width: '75%',
        color: '#FFFFFF',
        marginBottom: 10,
        paddingHorizontal: 10,
        backgroundColor: '#424242',
        borderWidth: 3, 
        borderColor: '#6E6E6E', 
        borderRadius: 4,
    },
    loginContenedorBoton: {
        width: '75%',
        elevation: 8,
        backgroundColor: '#424242',
        borderRadius: 10,
        paddingVertical: 10,
        paddingHorizontal: 12,
        marginBottom: 16,
    },
    loginBoton: {
        fontSize: 18,
        color: '#FFFFFF',
        fontWeight: 'bold',
        alignSelf: 'center',
        textTransform: 'uppercase',
    },
});

export default styles;