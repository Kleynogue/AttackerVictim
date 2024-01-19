import React, { useEffect } from 'react';
//import BluetoothSerial from 'react-native-bluetooth-serial-next';

const BluetoothStatus = () => {
/*
  useEffect(() => {
    
    async function init(){
        const enable = await BluetoothSerial.requestEnable();

 
        console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        const devices = await BluetoothSerial.discoverUnpairedDevices();
        console.log("3---");
        console.log(devices);
        console.log("+++++++++++++++++++++++++++++++++++++++++++---");

        try{
            const device = await BluetoothSerial.pairDevice('BC:10:7B:63:04:F9');
            console.log("*******************************************");
            console.log(device);
        }catch(e){
            console.log(e)
          } 

          console.log("FIIIIIN");

    }

    init();


    return () => {
      async function remove(){
          await BluetoothSerial.stopScanning();
          console.log("Termino de escanear");
      }
      remove();
    };
  }, []);
*/
  return null;
};

export default BluetoothStatus;