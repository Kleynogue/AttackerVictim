import React from "react";
import {NavigationContainer} from '@react-navigation/native';
import {createNativeStackNavigator} from '@react-navigation/native-stack';

import Login from "./src/view/Login";
import Main from "./src/view/Main";

const Stack = createNativeStackNavigator();

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