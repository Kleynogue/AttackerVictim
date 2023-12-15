import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';

import ModifyPhoneController from '../../controllers/modify/ModifyPhoneController';

import '../../assets/css//modify/ModifyPhone.css';

const ModifyPhone = () => {

    const modifyPhoneController = ModifyPhoneController();
    const params = useParams();
    const [data, setData] = useState([]);

    useEffect(() => {
        window.scrollTo(0, 0); 
        
        modifyPhoneController.handleGet(params.id)
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
            </div>

            <div className='modifyPhone_titulo'>
                <h1>TELEFONOS</h1>
            </div>

            <div className="modifyPhone_contenedor-form">
                <Form onSubmit={(e) => modifyPhoneController.handleActualizar(e,params.id)} className="modifyPhone_form">
                        <p className='modifyPhone_id'>id: {params.id}</p>
                        <InputField type='text'  label='Numero' idcontrol='PhoneNumer' ph={data.numero}/>
                        <InputField type='text'  label='Bluetooth' idcontrol='PhoneBluetooth' ph={data.bluetooth}/>
                        <InputField type='text'  label='Usuario' idcontrol='PhoneUsuario' ph={data.usuario}/>
                        <InputField type='text'  label='Caso' idcontrol='PhoneCaso' ph={data.caso}/>

                        <div className="modifyPhone_contenedor-boton">
                            <Button type="submit" className="modifyPhone_boton">Actualizar</Button>
                        </div>

                        <div className="modifyPhone_contenedor-boton">
                            <ButtonCompo buttonText="Cancelar" route="/telefonos" className="aaa" />
                        </div>

                        <div className="modifyPhone_contenedor-boton">
                            <Button onClick={() => modifyPhoneController.handleDelete(params.id)} className="modifyPhone_boton">Eliminar</Button>
                        </div>
                </Form>
            
            </div>

            <div className='modifyPhone_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default ModifyPhone;