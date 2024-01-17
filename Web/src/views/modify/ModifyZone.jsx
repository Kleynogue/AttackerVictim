import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import Mapa from "../../components/Mapa";
import MapaZona from '../../components/MapaZona';
import InputField from '../../components/InputField';

import ModifyZoneController from '../../controllers/modify/ModifyZoneController';
import CoordenadaController from '../../controllers/modify/CoordenadaController';

import '../../assets/css/modify/ModifyZone.css';


const ModifyZone = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const modifyZoneController = ModifyZoneController();
    const coordenadaController = CoordenadaController();

    const [markerPosition, setMarkerPosition] = useState(null);
    const [lat, setLat] = useState(null);
    const [lng, setLng] = useState(null);
    const [puntos, setPuntos] = useState([]);
    const [puntoSeleccionado, setPuntoSeleccionado] = useState([]);
    const [zone, setZone] = useState([]);
    const [zonasSeguridad, setZonasSeguridad] = useState([]);
    const [zonaId, setZonaId] = useState();

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);
        setZonaId(searchParams.get('zona'));

        modifyZoneController.handleGetPoints(searchParams.get('zona'))
        .then((jsonData) => {setPuntos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

        modifyZoneController.handleGetZones(searchParams.get('zona'))
        .then((jsonData) => {setZone(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

        coordenadaController.handleGetZonaID(searchParams.get('zona'))
        .then((jsonData) => {setZonasSeguridad(jsonData)
            console.log(jsonData);
        })
        .catch((error) => {console.error('Error al obtener los datos:', error);});

    }, []);

    useEffect(() => {
        if (markerPosition) {
          setLat(markerPosition.lat);
          setLng(markerPosition.lng);
        }
    }, [markerPosition]);


    return (
        <div className='modifyZone_contenedor'>
            <div>    
                <Header/>
                <Navbar/>
            </div>

            <div  className='modifyZone_titulo'>
                <h1>ZONAS</h1>
            </div>
            
            
            <Form onSubmit={(e) => modifyZoneController.handleUpdate(e,zonaId, searchParams.get('caso'))} className="modifyZone_form">
                        
                    <p className='modifyZone_id'>id: {zonaId}</p>

                    <InputField type='text'  label='Nombre' idcontrol='ZoneNombre' ph={zone.nombre} maxLength={20}/>
                    
                    <div className="modifyZone_contenedor-boton">
                        <Button type="submit" className="modifyZone_boton">Actualizar</Button>
                    </div>

                    <div>
                        <ButtonCompo buttonText="Volver" route="/zonas" id={`?${queryParams.toString()}`}/>
                    </div>
                    
                    {/* 
                    <div className="modifyZone_contenedor-boton">
                        <Button onClick={() => modifyZoneController.handleDeleteZone(zonaId)} className="modifyZone_boton">Eliminar</Button>
                    </div>*/}

            </Form>
           

            <div  className='modifyZone_titulo'>
                <h1>PUNTOS</h1>
            </div>

            <Form className='modifyZone_form-coordenada' onSubmit={(e) => modifyZoneController.handleCreatePoint(e, lat, lng, zonaId)}>
                    
                <div>
                    <p className="modifyZone_coordenada">({lat} , {lng})</p>
                </div>

                <div className="modifyZone_contenedor-boton-coordenada">
                    <Button type="submit" className="modifyZone_boton">Crear</Button>
                </div>
  
            </Form>
            

            <div className="modifyZone_contenedor-datos">
            
                <div className="modifyZone_contenedor-tabla">
                    <table className="modifyZone_tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Latitud</th>
                                <th>Longitud</th>
                            </tr>
                        </thead>
                        <tbody>
                            {puntos.map((punto) => (
                                <tr key={punto.id} onClick={() => modifyZoneController.handleRowClick(punto,setPuntoSeleccionado)}>
                                    <td>{punto.id}</td>
                                    <td>{punto.latitud}</td>
                                    <td>{punto.longitud}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
              
                </div>
                
                <div className="modifyZone_contenedor-mapa">
                    <MapaZona zona={zonaId} eliminar={modifyZoneController.handleDeletePoint} poligonos={zonasSeguridad} pointPosition={puntoSeleccionado} markerPosition={markerPosition} onMapClick={(e) => modifyZoneController.handleMapClick(e, setMarkerPosition)}/>
                </div>
                
                
 
            </div>

            <div className="modifyZone_footer">
                <Footer />
            </div>
        </div>
      );
};

export default ModifyZone;