import React from "react";
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import Login from "./src/view/Login";
import Main from "./src/view/Main";
import firebase from 'firebase/compat/app';
import PushNotification from 'react-native-push-notification';

const Stack = createNativeStackNavigator();

// Configuración de Firebase
const firebaseConfig = {
    apiKey: "AIzaSyCoK3FpHZ4gq-_HpYITL42aBZ5UmxbLsy0",
    authDomain: "attackervictim-f.firebaseapp.com",
    databaseURL: "https://attackervictim-f-default-rtdb.firebaseio.com/", 
    projectId: "attackervictim-f",
    storageBucket: "attackervictim-f.appspot.com",
    messagingSenderId: "797823566844",
    appId: "1:797823566844:android:6cba0f1eada76d3b89a879"
};
 
// Inicialización de Firebase
if (!firebase.apps.length) {
  firebase.initializeApp(firebaseConfig);
}


PushNotification.configure({
  onRegister: function (token) {
    console.log("TOKEN:", token);
  },
  onNotification: function (notification) {
    console.log("NOTIFICATION:", notification);
  },
  senderID: "797823566844",
});


const App = () => {
    return (
        <NavigationContainer>
            <Stack.Navigator
                screenOptions={{
                    headerShown: false
                }}>

                <Stack.Screen name="Login" component={Login}/>
                <Stack.Screen name="Main" component={Main}/>
                
            </Stack.Navigator>
        </NavigationContainer>
    );
};
  
export default App;