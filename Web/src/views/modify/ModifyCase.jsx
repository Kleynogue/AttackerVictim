import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { Form, Row} from 'react-bootstrap';
import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';
import MapaParticipantes from '../../components/MapaParticipantes';

import ModifyCaseController from '../../controllers/modify/ModifyCaseController';
import CoordenadaController from '../../controllers/modify/CoordenadaController';

import '../../assets/css/modify/ModifyCase.css';

const ModifyCase = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const [caso, setCaso] = useState([]);
    const [zonas, setZonas] = useState([]);
    const [statusActual, setStatusActual] = useState();

    const [attacker, setAttacker] = useState([]);
    const [attackerCoordenada, setAttackerCoordenada] = useState([]);
    const [attackerMarkerPosition, setAttackerMarkerPosition] = useState([]);

    const [victim, setVictim] = useState([]);
    const [victimCoordenada, setVictimCoordenada] = useState([]);
    const [victimMarkerPosition, setVictimMarkerPosition] = useState([]);

    const [casoId, setCasoId] = useState();

    const modifyCaseController = ModifyCaseController();
    const coordenadaController = CoordenadaController();

    const queryParamsUser = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
    });

    const [urlHistoricoAgresor, setUrlHistoricoAgresor] = useState();
    const [urlHistoricoVictima, setUrlHistoricoVictima] = useState();

    const optionsStatus = [
        { key: '1', value: 'empty', label: '-Deseleccionar-' },
        { key: '2', value: 'Activo', label: 'Activo' }, 
        { key: '3', value: 'Concluido', label: 'Concluido' },
        
    ];

    const [intervalId, setIntervalId] = useState(null);

useEffect(() => {
  window.scrollTo(0, 0);

  setCasoId(searchParams.get('caso'));

  return () => {
    clearInterval(intervalId);
  };
}, [casoId]);

useEffect(() => {
  if (casoId) {
    modifyCaseController.handleGetCase(casoId)
      .then((jsonData) => {
        setCaso(jsonData);
        setStatusActual("(Valor actual: " + jsonData.status + ")");

        coordenadaController.handleGetZonas(casoId)
          .then(async (jsonData) => {
            setZonas(jsonData);
            console.log(jsonData);
          })
          .catch((error) => {
            console.error('Error al obtener los datos:', error);
          });

        const queryParamsVictima = new URLSearchParams({
          usuario: searchParams.get('usuario'),
          caso: casoId,
          participante: jsonData.victima,
        });
        setUrlHistoricoVictima(queryParamsVictima.toString());

        const queryParamsAgresor = new URLSearchParams({
          usuario: searchParams.get('usuario'),
          caso: casoId,
          participante: jsonData.atacante,
        });
        setUrlHistoricoAgresor(queryParamsAgresor.toString());

        coordenadaController.handleGetCoordenada(jsonData.idAtacante)
          .then((jsonData) => {
            setAttackerCoordenada(jsonData);
          })
          .catch((error) => {
            console.error('Error al obtener los datos:', error);
          });

        coordenadaController.handleGetCoordenada(jsonData.idVictima)
          .then((jsonData) => {
            setVictimCoordenada(jsonData);
          })
          .catch((error) => {
            console.error('Error al obtener los datos:', error);
          });

        const interval = setInterval(() => {
          coordenadaController.handleGetCoordenada(jsonData.idAtacante)
            .then((jsonData) => {
              setAttackerCoordenada(jsonData);
            })
            .catch((error) => {
              console.error('Error al obtener los datos:', error);
            });

          coordenadaController.handleGetCoordenada(jsonData.idVictima)
            .then((jsonData) => {
              setVictimCoordenada(jsonData);
            })
            .catch((error) => {
              console.error('Error al obtener los datos:', error);
            });
        }, 10000);

        setIntervalId(interval);
      })
      .catch((error) => {
        console.error('Error al obtener los datos:', error);
      });
  }
}, [casoId]);


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
                <Navbar/>
            </div>


            <div  className='modifyCase_titulo'>
                <h1>CASOS</h1>
            </div>
            

            <div >
                <Form onSubmit={(e) => modifyCaseController.handleUpdate(e,casoId,caso)} className="modifyCase_form">
                        
                        <p className='modifyCase_id'>id: {casoId}</p>

                        {/*<InputField type='text'  label='Atacante' idcontrol='CaseAtacante'ph={caso.atacante}/>
                        <InputField type='text'  label='Victima' idcontrol='CaseVictima' ph={caso.victima}/>*/}
                        <InputField type='number'  label='Distancia' idcontrol='CaseDistancia' ph={caso.distancia} maxLength={5}/>
                        <InputField type='number'  label='Tiempo' ph={caso.tiempo} idcontrol='CaseTiempo' maxLength={5}/>
                        

                        <Dropdown options={optionsStatus} label="Status" actual={statusActual} clave='CaseStatus'/>


                        <div className="modifyCase_contenedor-boton">
                            <Button type="submit" className="modifyCase_boton">Actualizar</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Zonas" route="/zonas" id={`?${queryParams.toString()}`}/>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Volver" route="/casos" id={`?${queryParamsUser.toString()}`} />
                        </div>

                        {/* 
                        <div className="modifyCase_contenedor-boton">
                            <Button onClick={() => modifyCaseController.handleDelete(casoId)} className="modifyCase_boton">Eliminar</Button>
                        </div>*/}

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
                        <p>Atacante: {caso.atacante}</p>
                    </div>

                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Hora: {attackerCoordenada && attackerCoordenada.fecha !== null ? attackerCoordenada.fecha : 'N/A'}</p>
                    </div>

                    <div>
                        <p className="modifyCase_coordenadas">
                        {attackerCoordenada && attackerCoordenada.latitud !== null && attackerCoordenada.longitud !== null
                        ? `(${attackerCoordenada.latitud}, ${attackerCoordenada.longitud})`
                        : 'N/A'}
                        </p>
                    </div>

                    <div className="modifyCase_container-button-input-caso">
                        <ButtonCompo  buttonText="Historico" route={"/historico/puntos"} id={`?${urlHistoricoAgresor}`} />
                    </div>
                </div>

                <div className='modifyCase_participante' >
                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Victima: {caso.victima}</p>
                    </div>

                    <div  className="modifyCase_contenedor-participante-info">
                        <p>Hora: {victimCoordenada && victimCoordenada.fecha !== null ? victimCoordenada.fecha : 'N/A'}</p>
                    </div>

                    <div>
                        <p className="modifyCase_coordenadas">
                            {victimCoordenada && victimCoordenada.latitud !== null && victimCoordenada.longitud !== null
                            ? `(${victimCoordenada.latitud}, ${victimCoordenada.longitud})`
                            : 'N/A'}
                        </p>
                    </div>

                    <div >
                        <ButtonCompo  buttonText="Historico" route={"/historico/puntos"} id={`?${urlHistoricoVictima}`}/>
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