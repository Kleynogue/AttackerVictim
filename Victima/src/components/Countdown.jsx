import React, { useState, useEffect } from 'react';
import { StyleSheet, View, TouchableOpacity, Text } from 'react-native';
import ReactNativeHapticFeedback from 'react-native-haptic-feedback';
import Torch from 'react-native-torch';

const Countdown = () => {
  const [isTorchOn, setIsTorchOn] = useState(false);
  const [countdown, setCountdown] = useState(null);
  const [initialCountdown, setInitialCountdown] = useState(null);
  const [isCounting, setIsCounting] = useState(false);
  const [countdownFinished, setCountdownFinished] = useState(false);
  const [isAlertSent, setIsAlertSent] = useState(false);

  const options = {
    enableVibrateFallback: true,
    ignoreAndroidSystemSettings: false,
  };

  useEffect(() => {
    let intervalId;

    if (isCounting && countdown > 0) {
      intervalId = setInterval(() => {
        setCountdown((prevCountdown) => prevCountdown - 1);
      }, 1000);
    }

    if (countdown === 0 && !countdownFinished && !isAlertSent) {
      setIsAlertSent(true);
      setCountdownFinished(true);
      console.log('La cuenta regresiva ha terminado. Se ha enviado una alerta.');

      let flashlightInterval = setInterval(() => {
        Torch.switchState(!isTorchOn);
        setIsTorchOn((prevIsTorchOn) => !prevIsTorchOn);
      }, 1000);

      let hapticInterval = setInterval(() => {
        ReactNativeHapticFeedback.trigger('impactHeavy', options);
      }, 1000);

      setTimeout(() => {
        clearInterval(flashlightInterval);
        clearInterval(hapticInterval);
      }, 10000); // Detener el intervalo después de 10 segundos (ajústalo según tus necesidades)
    }

    return () => {
      Torch.switchState(false);
      clearInterval(intervalId);
    };
  }, [countdown, isCounting, countdownFinished, isAlertSent, isTorchOn]);

  const handleStart = () => {
    const initialCountdownValue = 5;
    setCountdown(initialCountdownValue);
    setInitialCountdown(initialCountdownValue);
    setIsCounting(true);
    setCountdownFinished(false);
    setIsAlertSent(false);
  };

  const handleCancel = () => {
    setIsCounting(false);
    setCountdown(null);
    setInitialCountdown(null);
    setCountdownFinished(false);
    setIsAlertSent(false);
    console.log('Contador cancelado');
  };

  const handleResume = () => {
    setCountdown(initialCountdown);
    setIsCounting(true);
    setCountdownFinished(false);
    setIsAlertSent(false);
  };

  return (
    <View>
      {countdown !== null && !isAlertSent && !countdownFinished && (
        <Text style={styles.countdownCuenta}>Cuenta regresiva: {countdown}</Text>
      )}
      {isAlertSent && (
        <Text style={styles.countdownCuenta}>Se ha enviado una alerta</Text>
      )}
      {!isCounting && !countdownFinished && (
        <TouchableOpacity onPress={handleStart} style={styles.countdownContenedorBoton}>
          <Text style={styles.countdownBoton}>Iniciar cuenta regresiva</Text>
        </TouchableOpacity>
      )}
      {isCounting && (
        <>
          {!countdownFinished && (
            <TouchableOpacity onPress={handleResume} style={styles.countdownContenedorBoton}>
              <Text style={styles.countdownBoton}>Mantener contador</Text>
            </TouchableOpacity>
          )}
          <TouchableOpacity onPress={handleCancel} style={styles.countdownContenedorBoton}>
            <Text style={styles.countdownBoton}>Cancelar contador</Text>
          </TouchableOpacity>
        </>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  countdownCuenta: {
    fontSize: 24,
    marginBottom: 16,
    color: '#424242',
  },
  countdownContenedorBoton: {
    elevation: 8,
    backgroundColor: '#424242',
    borderRadius: 10,
    paddingVertical: 10,
    paddingHorizontal: 12,
    marginBottom: 16,
  },
  countdownBoton: {
    fontSize: 18,
    color: '#FFFFFF',
    fontWeight: 'bold',
    alignSelf: 'center',
    textTransform: 'uppercase',
  },
});

export default Countdown;
