import React, { useState, useEffect } from 'react';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import CreateCaseController from '../../controllers/create/CreateCaseController';

import '../../assets/css/create/CreateCase.css';

const CreateCase = () => {

    const createCaseController = CreateCaseController();

    const optionsStatus = [
        { key: '1', value: 'activo', label: 'Activo' }, 
        { key: '2', value: 'inactivo', label: 'Inactivo' },
        
    ];

    useEffect(() => {
        window.scrollTo(0, 0);     
    }, []);

    return (
        <div className='createCase_contenedor'>
            <div>    
                <Header/>
            </div>

            <div  className='createCase_titulo'>
                <h1>CASOS</h1>
            </div>
            
            <div className="createCase_contenedor-form">
                <Form onSubmit={(e) => createCaseController.handleCreate(e)} className="createCase_form">       

                        <InputField type='text'  label='Atacante' idcontrol='CaseAtacante'/>
                        <InputField type='text'  label='Victima' idcontrol='CaseVictima' />
                        <InputField type='text'  label='Distancia' idcontrol='CaseDistancia' />
                        <InputField type='time'  label='Tiempo' idcontrol='CaseTiempo' />
                        <InputField type='date'  label='Inicio' idcontrol='CaseInicio' />
                        <InputField type='date'  label='Final' idcontrol='CaseFinal' />

                        <Dropdown options={optionsStatus} label="Status" clave='CaseStatus'/>

                        <div className="createCase_contenedor-boton">
                            <Button type="submit" className="createCase_boton">Crear</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Cancelar" route="/casos" />
                        </div>

                </Form>
            </div>

            <div className='createCase_footer'>
                <Footer/>
            </div>
        </div>
      );
};

export default CreateCase;