import React, { useState, useEffect } from 'react';
import { View, TextInput, TouchableOpacity, Text,} from 'react-native';

import LoginViewModel from '../viewmodel/LoginViewmodel';
import styles from '../styles/Login';

const Login = ({navigation}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [blueTooth, setBlueTooth] = useState('');

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

                <TextInput
                    style={styles.loginInput}
                    placeholder="BlueTooth"
                    value={blueTooth}
                    onChangeText={setBlueTooth}
                    placeholderTextColor="#FFF"
                />

                <TouchableOpacity onPress={() => loginViewModel.handleLogin(username,password, blueTooth)} style={styles.loginContenedorBoton}>
                    <Text style={styles.loginBoton}>Ingresar</Text>
                </TouchableOpacity>

            </View>

        </View>
  );
};

export default Login;