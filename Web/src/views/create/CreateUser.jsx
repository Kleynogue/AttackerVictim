import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import CreateUserController from '../../controllers/create/CreateUserController';

import '../../assets/css/create/CreateUser.css';

const CreateUser = () => {

    const createUserController = CreateUserController();

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const tipo = searchParams.get('tipo');

    //Se cargan los valores de la url
    var queryParams = new URLSearchParams({
            usuario: searchParams.get('usuario'),
            tipo: searchParams.get('tipo'),
            participante: searchParams.get('participante'),
            agresorSeleccionado: searchParams.get('agresorSeleccionado'),
            victimaSeleccionada: searchParams.get('victimaSeleccionada'),
            idAgresorSeleccionado: searchParams.get('idAgresorSeleccionado'),
            idVictimaSeleccionada: searchParams.get('idVictimaSeleccionada'),
            numeroAgresor: searchParams.get('numeroAgresor'),
            numeroVictima: searchParams.get('numeroVictima'),
            bluetoothAgresor: searchParams.get('bluetoothAgresor'),
            bluetoothVictima: searchParams.get('bluetoothVictima'),
    });

    const queryParamsUser = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    

    let optionsTipo;
    if (searchParams.get('tipo') === 'caso') {
        if(searchParams.get('participante') === "agresor"){
            optionsTipo = [
                { key: '2', value: 'Agresor', label: 'Agresor' },
            ]; 
        }
        else if(searchParams.get('participante') === "victima"){
            optionsTipo = [
                { key: '3', value: 'Victima', label: 'Victima' }, 
            ]; 
        }
    }
    else{
        optionsTipo = [
            { key: '2', value: 'Agresor', label: 'Agresor' },
            { key: '3', value: 'Victima', label: 'Victima' }, 
        ]; 
    }

    useEffect(() => {
        window.scrollTo(0, 0); 
    }, []);


    return (
        <div className='createUser_contenedor'>
            <div>
                <Header/>
                <Navbar/>
            </div>

            <div className='createUser_titulo'>
            <h1>USUARIOS</h1>
            </div>

            <div>
                <Form onSubmit={(e) => createUserController.handleCreate(e,queryParams)} className="createUser_form">
                        
                    <InputField type='text'  label='Nombre' idcontrol='UserNombre' maxLength={20}/>
                    <InputField type='text'  label='Apellido' idcontrol='UserApellido' maxLength={20}/>
                    <InputField type='text'  label='Usuario' idcontrol='UserUsuario' maxLength={20}/>
                    {/*<InputField type='text'  label='Password' idcontrol='UserPassword'/> */}
                    <InputField type='text'  label='Direccion' idcontrol='UserDireccion' maxLength={20}/>

                    
                    <Dropdown options={optionsTipo} label="Tipo" clave='UserTipo'/>
                   

                    <div className="createUser_contenedor-boton">
                        <Button type="submit" className="createUser_boton">Crear</Button>
                    </div>

                    <div>
                    {/*El boton de cancelar te lleva a una pantalla distinta dependiendo de donde la llamaron*/}
                        {tipo === 'caso' && (
                            <ButtonCompo buttonText="Volver" route="/crear-caso" id={`?${queryParams.toString()}`}/>
                        )}
                        {tipo === 'mostrar' && (
                            <ButtonCompo buttonText="Volver" route="/usuarios" id={`?${queryParamsUser.toString()}`}/>
                        )}
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