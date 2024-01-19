import LoginFormModel from '../../models/control/LoginFormModel';
const LoginFormController = () => {

    const loginFormModel = LoginFormModel();

    const handleSubmit = (event) => {
        event.preventDefault();
        
        const user = event.target.elements.user.value;
        const password = event.target.elements.password.value;

        /*
        const userData = {
            username: 'mariag',
            password: 'maria123'
          };*/
          if(user && password){
            const userData = {
                username: user,
                password: password
              };
            
            loginFormModel.handleValidarUser(userData);  
          }
          else{
            alert("Debe llenar todos los campos");
          }
          
    };

    return {
        handleSubmit,
    };
};

export default LoginFormController;