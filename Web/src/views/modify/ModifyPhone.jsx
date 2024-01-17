import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';

import ModifyPhoneController from '../../controllers/modify/ModifyPhoneController';

import '../../assets/css//modify/ModifyPhone.css';

const ModifyPhone = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const modifyPhoneController = ModifyPhoneController();
    const [data, setData] = useState([]);

    const queryParamsUser = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    useEffect(() => {
        window.scrollTo(0, 0); 
        
        modifyPhoneController.handleGet(searchParams.get('dispositivo'))
        .then((jsonData) => {
            setData(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);

    return (
        <div className='modifyPhone_contenedor'>
            <div>
                <Header/>
                <Navbar/>
            </div>

            <div className='modifyPhone_titulo'>
                <h1>TELEFONOS</h1>
            </div>

            <div className="modifyPhone_contenedor-form">
                <Form onSubmit={(e) => modifyPhoneController.handleActualizar(e,searchParams.get('dispositivo'),data)} className="modifyPhone_form">
                        <p className='modifyPhone_id'>id: {searchParams.get('dispositivo')}</p>
                        <p className='modifyPhone_id'>Caso: {data.caso}</p>
                        <p className='modifyPhone_id'>Usuario: {data.usuario}</p>
                        <p className='modifyPhone_id'>Fecha Inicial: {data.inicio}</p>
                        {/*<p className='modifyPhone_id'>Fecha Final:   {data.final}</p>*/}
                        
                        {/*<InputField type='text'  label='Numero' idcontrol='PhoneNumer' ph={data.numero}/> */}
                        <InputField type='text'  label='Bluetooth' idcontrol='PhoneBluetooth' ph={data.bluetooth} maxLength={20}/>
                        {/*<InputField type='text'  label='Usuario' idcontrol='PhoneUsuario' ph={data.usuario}/>
                        <InputField type='text'  label='Caso' idcontrol='PhoneCaso' ph={data.caso}/>
                        <InputField type='date'  label={'Inicio (Valor actual: '+data.inicio+')'} idcontrol='CaseInicio' />
                        <InputField type='date'  label={'Final (Valor actual: '+data.final+')'} idcontrol='CaseFinal'/>*/}

                        <div className="modifyPhone_contenedor-boton">
                            <Button type="submit" className="modifyPhone_boton">Actualizar</Button>
                        </div>

                        <div className="modifyPhone_contenedor-boton">
                            <ButtonCompo buttonText="Volver" route="/telefonos" id={`?${queryParamsUser.toString()}`} />
                        </div>

                        {/* <div className="modifyPhone_contenedor-boton">
                            <Button onClick={() => modifyPhoneController.handleDelete(searchParams.get('dispositivo'))} className="modifyPhone_boton">Eliminar</Button>
                        </div>*/}
                </Form>
            
            </div>

            <div className='modifyPhone_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default ModifyPhone;