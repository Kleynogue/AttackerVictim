import React, { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import CreateUserController from '../../controllers/create/CreateUserController';

import '../../assets/css/create/CreateUser.css';

const CreateUser = () => {

    const createUserController = CreateUserController();

    const optionsTipo = [
        { key: '1', value: 'administrador', label: 'Administrador' },
        { key: '2', value: 'agresor', label: 'Agresor' },
        { key: '3', value: 'victima', label: 'Victima' }, 
    ];

    useEffect(() => {
        window.scrollTo(0, 0);     
    }, []);


    return (
        <div className='createUser_contenedor'>
            <div>
                <Header/>
            </div>

            <div className='createUser_titulo'>
            <h1>USUARIOS</h1>
            </div>

            <div>
                <Form onSubmit={(e) => createUserController.handleCreate(e)} className="createUser_form">
                        
                    <InputField type='text'  label='Nombre' idcontrol='UserNombre'/>
                    <InputField type='text'  label='Apellido' idcontrol='UserApellido'/>
                    <InputField type='text'  label='Usuario' idcontrol='UserUsuario'/>
                    <InputField type='text'  label='Password' idcontrol='UserPassword'/>
                    <InputField type='text'  label='Direccion' idcontrol='UserDireccion'/>
                    <Dropdown options={optionsTipo} label="Tipo" clave='UserTipo'/>
                        
                    <div className="createUser_contenedor-boton">
                        <Button type="submit" className="createUser_boton">Crear</Button>
                    </div>

                    <div>
                        <ButtonCompo buttonText="Cancelar" route="/usuarios" />
                    </div>

                </Form>
            
            </div>

            <div className='createUser_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default CreateUser;