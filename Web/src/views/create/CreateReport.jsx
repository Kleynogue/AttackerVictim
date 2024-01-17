import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Mapa from '../../components/Mapa';

import CreateReportController from '../../controllers/create/CreateReportController';

import '../../assets/css/create/CreateReport.css';


const CreateReport = () => {

    const createReportController = CreateReportController();
    const params = useParams();
    const [data, setData] = useState([]);

    const [markerPosition, setMarkerPosition] = useState(null);
    const [lat, setLat] = useState(null);
    const [lng, setLng] = useState(null);

    useEffect(() => {
        window.scrollTo(0, 0); 

    }, []);

    useEffect(() => {
        if (markerPosition) {
          setLat(markerPosition.lat);
          setLng(markerPosition.lng);
        }
    }, [markerPosition]);

    return (
        <div className='createReport_contenedor'>
            <div>
                <Header/>
                <Navbar/>
            </div>

            <div className='createReport_titulo'>
                <h1>REPORTES</h1>
            </div>

            <div className="createReport_contenedor-form">
                <Form onSubmit={(e) => createReportController.handleCrear(e,lat, lng, params.id)} className="modifyReport_form">
                        <InputField type='text'  label='Telefono' idcontrol='ReportTelefono' ph={data.telefono}/>
                        <InputField type='date'  label='Fecha' idcontrol='ReportFecha' ph={data.fecha}/>
                        <InputField type='text'  label='Descripcion' idcontrol='ReportDescripcion' ph={data.descripcion}/>

                        <div className="createReport_contenedor-boton">
                            <Button type="submit" className="createReport_boton">Crear</Button>
                        </div>

                        <div className="createReport_contenedor-boton">
                            <ButtonCompo buttonText="Cancelar" route="/reportes" className="aaa" />
                        </div>

                </Form>
            
            </div>

            <div  className='createReport_titulo'>
                <h1>LOCALIZACION</h1>
            </div>

            <Form className='createReport_form-coordenada'  >
                    
                <div>
                    <p className="createReport_coordenada">({lat} , {lng})</p>
                </div>


            </Form>
            
            <div className="createReport_contenedor-mapa">
                <Mapa  markerPosition={markerPosition} onMapClick={(e) => createReportController.handleMapClick(e, setMarkerPosition)}/>
            </div>

     

            <div className='createReport_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default CreateReport;