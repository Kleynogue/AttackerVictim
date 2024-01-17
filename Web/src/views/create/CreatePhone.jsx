import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';

import CreatePhoneController from '../../controllers/create/CreatePhoneController';

import '../../assets/css/create/CreatePhone.css';

const CreatePhone = () => {

    const createPhoneController = CreatePhoneController();

    useEffect(() => {
        window.scrollTo(0, 0);     
    }, []);

    return (
        <div className='createPhone_contenedor'>
            <div>
                <Header/>
                <Navbar/>
            </div>

            <div className='createPhone_titulo'>
                <h1>TELEFONOS</h1>
            </div>

            <div className="createPhone_contenedor-form">
                <Form onSubmit={(e) => createPhoneController.handleCreate(e)} className="createPhone_form">
                        
                        <InputField type='text'  label='Numero' idcontrol='PhoneNumer'/>
                        <InputField type='text'  label='Bluetooth' idcontrol='PhoneBluetooth'/>
                        <InputField type='text'  label='Usuario' idcontrol='PhoneUsuario'/>
                        <InputField type='text'  label='Caso' idcontrol='PhoneCaso'/>
                        <InputField type='date'  label='Inicio' idcontrol='CaseInicio' />
                        <InputField type='date'  label='Final' idcontrol='CaseFinal' />
                        
                        <div className="createPhone_contenedor-boton-crear">
                            <Button type="submit" className="createPhone_form-boton">Crear</Button>
                        </div>

                        <div >
                            <ButtonCompo buttonText="Cancelar" route="/telefonos"  />
                        </div>

                </Form>
            
            </div>

            <div className='createPhone_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default CreatePhone;