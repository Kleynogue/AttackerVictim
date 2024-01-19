const UserViewModel = () => {
    const handleAlert = (user, tipo, dispositivo) => {
      const message = `Usuario: ${user}\nDispositivo: ${dispositivo}\nTipo: ${tipo}`;
      alert(message);
    };
  
    return {
      handleAlert
    };
  };
  
  export default UserViewModel;