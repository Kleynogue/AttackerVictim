import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import MapaHistorico from '../../components/MapaHistorico';
import ButtonCompo from '../../components/Button';

import CasePointsController from '../../controllers/show/CasePointsController';

import '../../assets/css/show/CasePoints.css';

const CasePoints = () => {

    const [markerPosition, setMarkerPosition] = useState(null);
    const [puntos, setPuntos] = useState([]);

    const params = useParams();
    const casePointsController = CasePointsController();

    useEffect(() => {
        window.scrollTo(0, 0);

        casePointsController.handleGetPoints()
        .then((jsonData) => {setPuntos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);


    return (
        <div className='casePoints_contenedor'>
            <div>    
                <Header/>
            </div>

            <div  className='casePoints_titulo'>
                <h1 >PUNTOS/</h1>

                <h1 >
                    <a className='casePoints_titulo-secundario' href={"/historico/movimientos/"+params.caso+"/"+params.id}>MOVIMIENTOS</a>
                </h1>
            </div>

            <div className='casePoints_contenedor-usuario'>
                <div>
                    <p className="casePoints_usuario">Id del telefono del usuario: {params.id} </p>
                </div>

                <div>
                    <ButtonCompo buttonText="Volver" route={"/modificar-caso/"+params.caso} />
                </div>
            </div>

            <div className="casePoints_contenedor-datos">
            
                <div className="casePoints_contenedor-tabla">
                    <table className="casePoints_tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>Latitud</th>
                                <th>Longitud</th>
                            </tr>
                        </thead>
                        <tbody>
                            {puntos.map((punto) => (
                                <tr key={punto.id} onClick={() => casePointsController.handleRowClick(punto,setMarkerPosition)}>
                                    <td>{punto.id}</td>
                                    <td>{punto.fecha}</td>
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

export default CasePoints;