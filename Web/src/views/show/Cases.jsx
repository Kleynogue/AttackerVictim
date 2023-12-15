import React, { useState, useEffect } from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Button from '../../components/Button';

import CasesController from '../../controllers/show/CasesController';

import '../../assets/css/show/Cases.css';

const Cases = () => {

    const casesController = CasesController();
    const [casos, setCasos] = useState([]);

    useEffect(() => {
        window.scrollTo(0, 0);     
        
        casesController.handleGet()
        .then((jsonData) => {setCasos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);

    return (
    <div className='case_contenedor'>

        <div>
          <Header/>
        </div>

        <div className='case_contenedor-titulo'>
          <h1>CASOS</h1>
        </div>

        <div className='case_contenedor-tabla'>
        
            <table className='case_tabla'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Atacante</th>
                        <th>Victima</th>
                        <th>Distancia</th>
                        <th>Tiempo</th>
                        <th>Inicio</th>
                        <th>Final</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {casos.map((caso) => (
                    <tr key={caso.id} onClick={() => casesController.handleRowClick(caso)}>
                    <td>{caso.id}</td>
                    <td>{caso.atacante}</td>
                    <td>{caso.victima}</td>
                    <td>{caso.distancia}</td>
                    <td>{caso.tiempo}</td>
                    <td>{caso.inicio}</td>
                    <td>{caso.final}</td>
                    <td>{caso.status}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>

        <div className='case_boton-agregar'>
            <Button buttonText="Crear" route="/crear-caso" />
        </div>

        <div className='case_boton-cancelar'>
            <Button buttonText="Cancelar" route="/menu" />
        </div>
             
        <div className='case_footer'>
            <Footer/>
        </div>
       
    </div>
  );

};

export default Cases;