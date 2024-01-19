import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import MapaHistorico from '../../components/MapaHistorico';
import ButtonCompo from '../../components/Button';

import ReportController from '../../controllers/show/ReportsController';

import '../../assets/css/show/CasePoints.css';

const Reports = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const reportController = ReportController();

    const [markerPosition, setMarkerPosition] = useState(null);
    const [puntos, setPuntos] = useState([]);
    const [caso, setCaso] = useState();
    const [participante, setParticipante] = useState();

    const queryParamsBase = new URLSearchParams({   
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
    });

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
        participante: searchParams.get('participante'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);
      
        setCaso(searchParams.get('caso'));
        setParticipante(searchParams.get('participante'));
      
        const fetchData = () => {
          reportController
            .handleGetPoints(searchParams.get('participante'))
            .then((jsonData) => {
              setPuntos(jsonData);
            })
            .catch((error) => {
              console.error('Error al obtener los datos:', error);
            });
        };
      
        // Ejecutar fetchData inmediatamente
        fetchData();
      
        // Establecer intervalo para ejecutar fetchData cada 10 segundos
        const interval = setInterval(fetchData, 10000);
      
        // Limpiar intervalo al desmontar el componente
        return () => clearInterval(interval);
      }, []);


    return (
        <div className='casePoints_contenedor'>
            <div>    
                <Header/>
                <Navbar/>
            </div>

            <div  className='casePoints_titulo'>
                <h1 >
                    <a className='caseMoves_titulo-secundario' href={"/historico/puntos"+`?${queryParams.toString()}`}>PUNTOS</a>
                </h1>

                <h1 >/</h1>

                <h1 >
                    <a className='casePoints_titulo-secundario' href={"/historico/movimientos"+`?${queryParams.toString()}`}>MOVIMIENTOS</a>
                </h1>
                
                <h1 >/REPORTES/</h1>

                <h1 >
                    <a className='caseMoves_titulo-secundario' href={"/historico/wifi"+`?${queryParams.toString()}`}>CONEXION</a>
                </h1>
            </div>

            <div className='casePoints_contenedor-usuario'>
                <div>
                    <p className="casePoints_usuario">Id del telefono del usuario: {participante} </p>
                </div>

                <div>
                    <ButtonCompo buttonText="Volver" route={"/modificar-caso"} id={`?${queryParamsBase.toString()}`} />
                </div>
            </div>

            <div className="casePoints_contenedor-datos">
            
                <div className="casePoints_contenedor-tabla">
                    <table className="casePoints_tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Tipo</th>
                                <th>Latitud</th>
                                <th>Longitud</th>
                            </tr>
                        </thead>
                        <tbody>
                            {puntos.map((punto) => (
                                <tr key={punto.id} onClick={() => reportController.handleRowClick(punto,setMarkerPosition)}>
                                    <td>{punto.id}</td>
                                    <td>{punto.fecha}</td>
                                    <td>{punto.type}</td>
                                    <td>{punto.latitud}</td>
                                    <td>{punto.longitud}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
              
                </div>
                
                <div className="casePoints_contenedor-mapa">
                    <MapaHistorico  marker={markerPosition}/>
                </div>
 
            </div>

            <div className="casePoints_footer">
                <Footer />
            </div>
        </div>
      );
};

export default Reports;