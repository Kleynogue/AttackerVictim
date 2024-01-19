import React, { useState, useEffect } from 'react';
import SosModel from '../model/SosModel';
import Geolocation from 'react-native-geolocation-service';
import MainViewModel from './MainViewModel';
const SosViewmodel = () => {

    const sosModel = SosModel();
    const mainViewModel = MainViewModel();
    
    const handleAlert = (telefono) => {
        Geolocation.getCurrentPosition(
            async (position) => {

                let dataPuntoGeografico = {
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude,
                    status: "Activo"};
                console.log("Reporte "+JSON.stringify(dataPuntoGeografico));
                const idPunto = await mainViewModel.handleCreatePosition(dataPuntoGeografico);
                mainViewModel.handleCreateReporte(idPunto, "SOS", telefono);
                alert('Alerta enviada a las autoridades');
            },
            (error) => {
            console.log(error);
            }
            
        );
        
        
        //sosModel.handleAlertSQL();
    };
    
    return {
        handleAlert
    };
};

export default SosViewmodel;