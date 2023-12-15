import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';
import MapaParticipantes from '../../components/MapaParticipantes';

import ModifyCaseController from '../../controllers/modify/ModifyCaseController';
import CoordenadaController from '../../controllers/modify/CoordenadaController';

import '../../assets/css/modify/ModifyCase.css';

const ModifyCase = () => {

    const [caso, setCaso] = useState([]);
    const [zonas, setZonas] = useState([]);
    const [statusActual, setStatusActual] = useState();

    const [attacker, setAttacker] = useState([]);
    const [attackerCoordenada, setAttackerCoordenada] = useState([]);
    const [attackerMarkerPosition, setAttackerMarkerPosition] = useState([]);

    const [victim, setVictim] = useState([]);
    const [victimCoordenada, setVictimCoordenada] = useState([]);
    const [victimMarkerPosition, setVictimMarkerPosition] = useState([]);

    const params = useParams();
    const modifyCaseController = ModifyCaseController();
    const coordenadaController = CoordenadaController();

    const optionsStatus = [
        { key: '1', value: 'empty', label: '-Deseleccionar-' },
        { key: '2', value: 'activo', label: 'Activo' }, 
        { key: '3', value: 'inactivo', label: 'Inactivo' },
        
    ];


    useEffect(() => {
        window.scrollTo(0, 0);

        modifyCaseController.handleGetCase()
        .then((jsonData) => {
            setCaso(jsonData);
            setStatusActual("(Valor actual: " + jsonData.status+ ")");
        })
        .catch((error) => {console.error('Error al obtener los datos:', error);});

        modifyCaseController.handleGetParticipante(11)
        .then((jsonData) => {setAttacker(jsonData);})
        .catch((error) => {console.error('Error al obtener los datos:', error);});

        modifyCaseController.handleGetParticipante(12)
        .then((jsonData) => {setVictim(jsonData);})
        .catch((error) => {console.error('Error al obtener los datos:', error);});

        coordenadaController.handleGetZonas()
        .then((jsonData) => {setZonas(jsonData)
            console.log(jsonData);
        })
        .catch((error) => {console.error('Error al obtener los datos:', error);});

        const interval = setInterval(() => {
            coordenadaController.handleGetCoordenada(11)
            .then((jsonData) => {setAttackerCoordenada(jsonData);})
            .catch((error) => {console.error('Error al obtener los datos:', error);});

            coordenadaController.handleGetCoordenada(12)
            .then((jsonData) => {setVictimCoordenada(jsonData);})
            .catch((error) => {console.error('Error al obtener los datos:', error);});
        }, 10000);
        return () => {clearInterval(interval);};
        
    }, []);


    useEffect(() => {
        if (attackerCoordenada) {
            setAttackerMarkerPosition({ lat: parseFloat(attackerCoordenada.latitud), lng:  parseFloat(attackerCoordenada.longitud) });
        }
    }, [attackerCoordenada]);

    useEffect(() => {
        if (victimCoordenada) {
            setVictimMarkerPosition({ lat: parseFloat(victimCoordenada.latitud), lng:  parseFloat(victimCoordenada.longitud) });
        }
    }, [victimCoordenada]);


    return (
        <div className='modifyCase_contenedor'>
            <div>    
                <Header/>
            </div>


            <div  className='modifyCase_titulo'>
                <h1>CASOS</h1>
            </div>
            

            <div >
                <Form onSubmit={(e) => modifyCaseController.handleUpdate(e,params.id)} className="modifyCase_form">
                        
                        <p className='modifyCase_id'>id: {params.id}</p>

                        <InputField type='text'  label='Atacante' idcontrol='CaseAtacante'ph={caso.atacante}/>
                        <InputField type='text'  label='Victima' idcontrol='CaseVictima' ph={caso.victima}/>
                        <InputField type='text'  label='Distancia' idcontrol='CaseDistancia' ph={caso.distancia}/>
                        <InputField type='time'  label={'Tiempo (Valor actual: '+caso.tiempo+')'} idcontrol='CaseTiempo' />
                        <InputField type='date'  label={'Inicio (Valor actual: '+caso.inicio+')'} idcontrol='CaseInicio' />
                        <InputField type='date'  label={'Final (Valor actual: '+caso.final+')'} idcontrol='CaseFinal'/>

                        <Dropdown options={optionsStatus} label="Status" actual={statusActual} clave='CaseStatus'/>


                        <div className="modifyCase_contenedor-boton">
                            <Button type="submit" className="modifyCase_boton">Actualizar</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Cancelar" route="/casos" />
                        </div>

                        <div className="modifyCase_contenedor-boton">
                            <Button onClick={() => modifyCaseController.handleDelete(params.id)} className="modifyCase_boton">Eliminar</Button>
                        </div>

                </Form>
            </div>


            <div  className='modifyCase_titulo'>
                <h1>UBICACION</h1>
            </div>


            <div className="modifyCase_contenedor-mapa">
                <MapaParticipantes poligonos={zonas} marcadorAtacante={attackerMarkerPosition} marcadorVictima={victimMarkerPosition}/>
            </div>


            <div className='modifyCase_contenedor-participantes'>

                <div className='modifyCase_participante' >
                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Atacante: {attacker.nombre} {attacker.apellido}</p>
                    </div>

                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Hora:  {attackerCoordenada.fecha}</p>
                    </div>

                    <div>
                        <p className="modifyCase_coordenadas">({attackerCoordenada.latitud} , {attackerCoordenada.longitud})</p>
                    </div>

                    <div className="modifyCase_container-button-input-caso">
                        <ButtonCompo  buttonText="Historico" route={"/historico/puntos/"+params.id+"/"+caso.atacante} />
                    </div>
                </div>

                <div className='modifyCase_participante' >
                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Victima: {victim.nombre} {victim.apellido}</p>
                    </div>

                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Hora: {victimCoordenada.fecha}</p>
                    </div>

                    <div>
                        <p className="modifyCase_coordenadas">({victimCoordenada.latitud} , {victimCoordenada.longitud})</p>
                    </div>

                    <div >
                        <ButtonCompo  buttonText="Historico" route={"/historico/puntos/"+params.id+"/"+caso.victima} />
                    </div>
                </div>

            </div>

            <div className="modifyCase_footer">
                <Footer />
            </div>

        </div>
      );
};

export default ModifyCase;