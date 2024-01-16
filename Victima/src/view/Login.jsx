import React, { useState } from 'react';
import { View, TextInput, Button, TouchableOpacity, Text } from 'react-native';
import LoginViewModel from '../viewmodel/LoginViewmodel';
import styles from '../styles/Login';

const Login = ({navigation}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');


    const loginViewModel = LoginViewModel(navigation);


    const handleLogin = () => {
        // Forma un correo electrónico ficticio a partir del nombre de usuario
        let email = username + "@gmail.com";
        loginViewModel.handleLogin(email, password);
    };


    return (
        <View style={styles.loginContenedor}>
            <View style={styles.loginSubContenedor}>
                <TextInput
                    style={styles.loginInput}
                    placeholder="Nombre de usuario"
                    value={username}
                    onChangeText={setUsername}
                    placeholderTextColor="#FFF"
                />
                <TextInput
                    style={styles.loginInput}
                    placeholder="Contraseña"
                    secureTextEntry={true}
                    value={password}
                    onChangeText={setPassword}
                    placeholderTextColor="#FFF"
                />
                <TouchableOpacity onPress={handleLogin} style={styles.loginContenedorBoton}>
                    <Text style={styles.loginBoton}>Ingresar</Text>
                </TouchableOpacity>
            </View>
        </View>
    );
};


export default Login;


