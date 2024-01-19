import React, { useEffect } from 'react';
/*import BleManager from 'react-native-ble-manager';
import { NativeModules, NativeEventEmitter } from 'react-native';*/

//const BleManagerModule = NativeModules.BleManager;
//const BleManagerEmitter = new NativeEventEmitter(BleManagerModule);

const Bluetooth = () => {
 /* useEffect(() => {
    BleManager.start({ showAlert: false }).then(() => {
      console.log('Module initialized');
    });

    BleManager.scan([], 5, true).then(() => {
      console.log('Scan started');
    });

    const handleDiscoverPeripheral = (peripheral) => {
      console.log('Discovered peripheral:', peripheral);
    };

    const subscription = BleManagerEmitter.addListener(
      'BleManagerDiscoverPeripheral',
      handleDiscoverPeripheral
    );

    return () => {
      BleManager.stopScan().then(() => {
        console.log('Scan stopped');
      });
      subscription.remove();
    };
  }, []);*/

  return null;
};

export default Bluetooth;