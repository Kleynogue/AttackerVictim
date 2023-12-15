import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Mapa from '../../components/Mapa';

import ModifyReportController from '../../controllers/modify/ModifyReportController';

import '../../assets/css/modify/ModifyReport.css';


const ModifyReport = () => {

    const modifyReportController = ModifyReportController();
    const params = useParams();
    const [data, setData] = useState([]);

    const [markerPosition, setMarkerPosition] = useState(null);
    const [lat, setLat] = useState(null);
    const [lng, setLng] = useState(null);
    const [latActual, setLatActual] = useState(null);
    const [lngActual, setLngActual] = useState(null);

    useEffect(() => {
        window.scrollTo(0, 0); 
        
        modifyReportController.handleGet(params.id)
        .then((jsonData) => {
            setData(jsonData)
            setLat(jsonData.latitud);
            setLng(jsonData.longitud);
            setLatActual(jsonData.latitud);
            setLngActual(jsonData.longitud);
            setMarkerPosition({ lat: parseFloat(jsonData.latitud), lng: parseFloat(jsonData.longitud) });
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);

    useEffect(() => {
        if (markerPosition) {
          setLat(markerPosition.lat);
          setLng(markerPosition.lng);
        }
    }, [markerPosition]);

    return (
        <div className='modifyReport_contenedor'>
            <div>
                <Header/>
            </div>

            <div className='modifyReport_titulo'>
                <h1>REPORTES</h1>
            </div>

            <div className="modifyReport_contenedor-form">
                <Form onSubmit={(e) => modifyReportController.handleActualizar(e,params.id)} className="modifyReport_form">
                        <p className='modifyReport_id'>id: {params.id}</p>
                        <InputField type='text'  label='Telefono' idcontrol='ReportTelefono' ph={data.telefono}/>
                        <InputField type='date'  label='Fecha' idcontrol='ReportFecha' ph={data.fecha}/>
                        <InputField type='text'  label='Descripcion' idcontrol='ReportDescripcion' ph={data.descripcion}/>

                        <div className="modifyReport_contenedor-boton">
                            <Button type="submit" className="modifyReport_boton">Actualizar</Button>
                        </div>

                        <div className="modifyReport_contenedor-boton">
                            <ButtonCompo buttonText="Cancelar" route="/reportes" className="aaa" />
                        </div>

                        <div className="modifyReport_contenedor-boton">
                            <Button onClick={() => modifyReportController.handleDelete(params.id)} className="modifyReport_boton">Eliminar</Button>
                        </div>
                </Form>
            
            </div>

            <div  className='modifyReport_titulo'>
                <h1>LOCALIZACION</h1>
            </div>

            <Form className='modifyReport_form-coordenada'  onSubmit={(e) => modifyReportController.handleUpdatePoint(e, lat, lng, setLatActual, setLngActual, params.id)}>
                    
                <div>
                    <p className="modifyReport_coordenada">({lat} , {lng})</p>
                </div>

                <div className="modifyReport_contenedor-boton-coordenada">
                    <Button type="submit" className="modifyReport_boton">Actualizar</Button>
                </div>

                <div className="modifyReport_contenedor-boton-coordenada">
                    <Button type="button" className="modifyReport_boton" onClick={() => modifyReportController.handleRestartPoint( latActual, lngActual, setMarkerPosition)}>Reiniciar</Button>
                </div>
  
            </Form>
            
            <div className="modifyReport_contenedor-mapa">
                <Mapa   markerPosition={markerPosition} onMapClick={(e) => modifyReportController.handleMapClick(e, setMarkerPosition)}/>
            </div>

     

            <div className='modifyReport_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default ModifyReport;