import React, { useState, useEffect } from 'react';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import InputField from '../../components/InputField';

import CreateZoneController from '../../controllers/create/CreateZoneController';

import '../../assets/css/create/CreateZone.css';

const CreateZone = () => {

    const createZoneController = CreateZoneController();

    useEffect(() => {
        window.scrollTo(0, 0);
    }, []);


    return (
        <div className='createZone_contenedor'>
            <div>    
                <Header/>
            </div>

            <div  className='createZone_titulo'>
                <h1>ZONAS</h1>
            </div>
            
            <div>
                <Form onSubmit={(e) => createZoneController.handleCreate(e)} className="createZone_form">
                        
                        <InputField type='text'  label='Nombre' idcontrol='ZoneNombre'/>
                    
                        <div className="createZone_contenedor-boton">
                            <Button type="submit" className="createZone_boton">Crear</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Cancelar" route="/zonas" />
                        </div>

                </Form>
            </div>

            <div className='createZone_footer'>
                <Footer/>
            </div>
        </div>
      );
};

export default CreateZone;