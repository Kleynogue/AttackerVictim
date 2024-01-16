import LoginModel from '../model/LoginModel';

const LoginViewmodel = (navigation) => {


    const loginModel = LoginModel(navigation);


    const handleLogin = (username,password) => {
        loginModel.handleValidarUser(username,password);
    };
   
    return {
        handleLogin
    };
};


export default LoginViewmodel;

