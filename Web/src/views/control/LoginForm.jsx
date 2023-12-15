import React from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import InputField from '../../components/InputField';

import LoginFormController from '../../controllers/control/LoginFormController';

import '../../assets/css/control/LoginForm.css';


const LoginForm = () => {
  const { handleSubmit } = LoginFormController();

  return (
    <div className='loginForm_contenedor'>
        <div>
            <Header/>
        </div>

        <div>
            <Form onSubmit={handleSubmit} className="loginForm_form">
                <InputField type='text'  label='User' idcontrol='user'/>
                <InputField type='password'  label='Password' idcontrol='password'/>
                    
                <div className="loginForm_contenedor-boton">
                    <Button type="submit" className="loginForm_boton">Sign in</Button>
                </div>
            </Form>
        </div>
        
        <div className='loginForm_footer'>
            <Footer/>
        </div>
        
    </div>
  );
};

export default LoginForm;


