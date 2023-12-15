import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import ButtonCompo from '../../components/Button';

import CaseMovesController from '../../controllers/show/CaseMovesController';

import '../../assets/css/show/CaseMoves.css';

const CaseMoves = () => {

    const [markerPosition, setMarkerPosition] = useState(null);
    const [datos, setDatos] = useState([]);

    const params = useParams();
    const caseMovesController = CaseMovesController();

    useEffect(() => {
        window.scrollTo(0, 0);

        caseMovesController.handleGetData()
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
            </div>

            <div  className='caseMoves_titulo'>
                <h1 >
                    <a className='caseMoves_titulo-secundario' href={"/historico/puntos/"+params.caso+"/"+params.id}>PUNTOS</a>
                </h1>

                <h1 >/MOVIMIENTOS</h1>
            </div>

            <div className='caseMoves_contenedor-usuario'>
                <div>
                    <p className="caseMoves_usuario">Id del telefono del usuario: {params.id} </p>
                </div>

                <div>
                    <ButtonCompo buttonText="Volver" route={"/modificar-caso/"+params.caso} />
                </div>
            </div>


            <div className="caseMoves_contenedor-datos">
            
                <div className="caseMoves_contenedor-tabla">
                    <table className="caseMoves_tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Fecha</th>
                                <th>X</th>
                                <th>Y</th>
                                <th>Z</th>
                            </tr>
                        </thead>
                        <tbody>
                            {datos.map((dato) => (
                                <tr key={dato.id} >
                                    <td>{dato.id}</td>
                                    <td>{dato.fecha}</td>
                                    <td>{dato.X}</td>
                                    <td>{dato.Y}</td>
                                    <td>{dato.Z}</td>
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

export default CaseMoves;