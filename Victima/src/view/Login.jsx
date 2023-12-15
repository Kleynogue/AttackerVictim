import React, { useState } from 'react';
import { View, TextInput, Button, TouchableOpacity, Text } from 'react-native';
import LoginViewModel from '../viewmodel/LoginViewmodel';
import styles from '../styles/Login';

const Login = ({navigation}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const loginViewModel = LoginViewModel(navigation);

    return (
        <View style={styles.loginContenedor}>
            
            <View style={styles.loginSubContenedor}>

                <TextInput
                    style={styles.loginInput}
                    placeholder="Usuario"
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

                <TouchableOpacity onPress={() => loginViewModel.handleLogin(username,password)} style={styles.loginContenedorBoton}>
                    <Text style={styles.loginBoton}>Ingresar</Text>
                </TouchableOpacity>

            </View>

        </View>
  );
};

export default Login;