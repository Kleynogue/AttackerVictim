import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import InputField from '../../components/InputField';

import CreateZoneController from '../../controllers/create/CreateZoneController';

import '../../assets/css/create/CreateZone.css';

const CreateZone = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const createZoneController = CreateZoneController();

    const [caso, setCaso] = useState();

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);
        setCaso(searchParams.get('caso'));
    }, []);


    return (
        <div className='createZone_contenedor'>
            <div>    
                <Header/>
                <Navbar/>
            </div>

            <div  className='createZone_titulo'>
                <h1>ZONAS</h1>
            </div>
            
            <div>
                <Form onSubmit={(e) => createZoneController.handleCreate(e,queryParams)} className="createZone_form">
                        
                        <InputField type='text'  label='Nombre' idcontrol='ZoneNombre' maxLength={20}/>
                    
                        <div className="createZone_contenedor-boton">
                            <Button type="submit" className="createZone_boton">Crear</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Volver" route="/zonas" id={`?${queryParams.toString()}`}/>
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