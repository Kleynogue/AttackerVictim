import LoginFormModel from '../../models/control/LoginFormModel';

const LoginFormController = () => {

    const loginFormModel = LoginFormModel();

    const handleSubmit = (event) => {
        event.preventDefault();
        
        const user = event.target.elements.user.value;
        const password = event.target.elements.password.value;
    
        loginFormModel.handleValidarUser(user,password);
    };

    return {
        handleSubmit,
    };
};

export default LoginFormController;