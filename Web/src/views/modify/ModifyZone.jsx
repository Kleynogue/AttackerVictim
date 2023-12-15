import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Mapa from "../../components/Mapa";
import MapaZona from '../../components/MapaZona';
import InputField from '../../components/InputField';

import ModifyZoneController from '../../controllers/modify/ModifyZoneController';
import CoordenadaController from '../../controllers/modify/CoordenadaController';

import '../../assets/css/modify/ModifyZone.css';


const ModifyZone = () => {

    const [markerPosition, setMarkerPosition] = useState(null);
    const [lat, setLat] = useState(null);
    const [lng, setLng] = useState(null);
    const [puntos, setPuntos] = useState([]);
    const [puntoSeleccionado, setPuntoSeleccionado] = useState([]);
    const [zone, setZone] = useState([]);
    const [zonasSeguridad, setZonasSeguridad] = useState([]);
    const params = useParams();
    const modifyZoneController = ModifyZoneController();
    const coordenadaController = CoordenadaController();

    useEffect(() => {
        window.scrollTo(0, 0);

        modifyZoneController.handleGetPoints()
        .then((jsonData) => {setPuntos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

        modifyZoneController.handleGetZones(params.id)
        .then((jsonData) => {setZone(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

        coordenadaController.handleGetZonaID()
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
            </div>

            <div  className='modifyZone_titulo'>
                <h1>ZONAS</h1>
            </div>
            
            
            <Form onSubmit={(e) => modifyZoneController.handleUpdate(e,params.id)} className="modifyZone_form">
                        
                    <p className='modifyZone_id'>id: {params.id}</p>

                    <InputField type='text'  label='Nombre' idcontrol='ZoneNombre' ph={zone.nombre}/>
                    
                    <div className="modifyZone_contenedor-boton">
                        <Button type="submit" className="modifyZone_boton">Actualizar</Button>
                    </div>

                    <div>
                        <ButtonCompo buttonText="Cancelar" route="/zonas" />
                    </div>

                    <div className="modifyZone_contenedor-boton">
                        <Button onClick={() => modifyZoneController.handleDeleteZone(params.id)} className="modifyZone_boton">Eliminar</Button>
                    </div>

            </Form>
           

            <div  className='modifyZone_titulo'>
                <h1>PUNTOS</h1>
            </div>

            <Form className='modifyZone_form-coordenada' onSubmit={(e) => modifyZoneController.handleCreatePoint(e, lat, lng, params.id)}>
                    
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
                    <MapaZona zona={params.id} eliminar={modifyZoneController.handleDeletePoint} poligonos={zonasSeguridad} pointPosition={puntoSeleccionado} markerPosition={markerPosition} onMapClick={(e) => modifyZoneController.handleMapClick(e, setMarkerPosition)}/>
                </div>
                
                
 
            </div>

            <div className="modifyZone_footer">
                <Footer />
            </div>
        </div>
      );
};

export default ModifyZone;