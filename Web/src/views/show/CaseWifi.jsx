import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import ButtonCompo from '../../components/Button';

import CaseWifiController from '../../controllers/show/CaseWifiController';

import '../../assets/css/show/CaseMoves.css';

const CaseWifi = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const caseWifiController = CaseWifiController();

    const [markerPosition, setMarkerPosition] = useState(null);
    const [datos, setDatos] = useState([]);
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

        caseWifiController.handleGetData(searchParams.get('participante'))
        .then((jsonData) => {setDatos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);


    return (
        <div className='caseMoves_contenedor'>
            <div>    
                <Header/>
                <Navbar/>
            </div>

            <div  className='caseMoves_titulo'>
                <h1 >
                    <a className='caseMoves_titulo-secundario' href={"/historico/puntos"+`?${queryParams.toString()}`}>PUNTOS</a>
                </h1>

                <h1 >/</h1>

                <h1 >
                    <a className='casePoints_titulo-secundario' href={"/historico/movimientos"+`?${queryParams.toString()}`}>MOVIMIENTOS</a>
                </h1>

                <h1 >/</h1>

                <h1 >
                    <a className='caseMoves_titulo-secundario' href={"/historico/reportes"+`?${queryParams.toString()}`}>REPORTES</a>
                </h1>

                <h1 >/CONEXION</h1>
            </div>

            <div className='caseMoves_contenedor-usuario'>
                <div>
                    <p className="caseMoves_usuario">Id del telefono del usuario: {participante} </p>
                </div>

                <div>
                    <ButtonCompo buttonText="Volver" route={"/modificar-caso"} id={`?${queryParamsBase.toString()}`}/>
                </div>
            </div>


            <div className="caseMoves_contenedor-datos">
            
                <div className="caseMoves_contenedor-tabla">
                    <table className="caseMoves_tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                            </tr>
                        </thead>
                        <tbody>
                            {datos.map((dato) => (
                                <tr key={dato.id} >
                                    <td>{dato.id}</td>
                                    <td>{dato.fecha}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
              
                </div>
                

 
            </div>

            <div className="caseMoves_footer">
                <Footer />
            </div>
        </div>
      );
};

export default CaseWifi;