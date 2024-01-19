import React, { useState, useEffect } from 'react';
import MainViewModel from '../viewmodel/MainViewModel';

import MapView, { Marker, Polygon } from 'react-native-maps';
import { StyleSheet, View, Text } from 'react-native';
import Geolocation from 'react-native-geolocation-service';
import { PermissionsAndroid } from 'react-native';

const MapComponent = ({telefono,  polygons}) => {
  const [currentPosition, setCurrentPosition] = useState(null);
  const [lastUpdateTime, setLastUpdateTime] = useState(null);

  const mainViewModel = MainViewModel();
  useEffect(() => {

    const requestLocationPermission = async () => {
        try {
          const granted = await PermissionsAndroid.request(
            PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION,
            {
              title: 'Location Permission',
              message: 'This app requires access to your location.',
              buttonPositive: 'OK',
            },
          );
          if (granted === PermissionsAndroid.RESULTS.GRANTED) {
            console.log('Location permission granted.');
          } else {
            console.log('Location permission denied.');
          }
        } catch (error) {
          console.warn('Error requesting location permission:', error);
        }
    };
  
      // Llama a la función para solicitar el permiso de ubicación
      requestLocationPermission();


    const intervalId = setInterval(() => {
        Geolocation.getCurrentPosition(
                async (position) => {
                    setCurrentPosition(position.coords);
                   
                    setLastUpdateTime(new Date().toLocaleTimeString());

                   

                    let dataPuntoGeografico = {
                        latitude: position.coords.latitude,
                        longitude: position.coords.longitude,
                        status: "Activo"};
                    //console.log("--> "+JSON.stringify(dataPuntoGeografico));
                    const idPunto = await mainViewModel.handleCreatePosition(dataPuntoGeografico);
                    mainViewModel.handleCreateHistoricoPunto(idPunto, telefono);

                },
                (error) => {
                console.log(error);
                },
                { enableHighAccuracy: true, timeout: 15000, maximumAge: 10000 }
        );
    }, 10000);

    return () => clearInterval(intervalId);
  }, []);

  return (
    <View style={styles.container}>
      <MapView
        style={styles.map}
        region={{
          latitude: currentPosition ? currentPosition.latitude : 37.78825,
          longitude: currentPosition ? currentPosition.longitude : -122.4324,
          latitudeDelta: 0.015,
          longitudeDelta: 0.0121,
        }}
        provider={MapView.PROVIDER_GOOGLE}
        apiKey="AIzaSyAVCv2edVHkkor2XENUBSsamIXFgMFn8UM"
      >
        {currentPosition && (
          <Marker
            coordinate={{
              latitude: currentPosition.latitude,
              longitude: currentPosition.longitude,
            }}
            title="Mi posición"
            description={`Última actualización: ${lastUpdateTime}`}
          />
        )}
         {polygons && polygons.length > 0 && polygons.map((polygon, index) => (
            polygon && (
                <Polygon
                key={index}
                coordinates={polygon.coordinates}
                fillColor="rgba(255, 0, 0, 0.2)"
                strokeColor="red"
                />
            )
            ))}
        </MapView>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    ...StyleSheet.absoluteFillObject,
    height: 350,
    width: '100%',
    borderWidth: 3, 
    borderColor: '#2C2C2C', 
    borderRadius: 4,
  },
  map: {
    ...StyleSheet.absoluteFillObject,
    
  },
});

export default MapComponent;