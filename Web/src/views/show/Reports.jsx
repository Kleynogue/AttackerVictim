import React, { useState, useEffect } from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Button from '../../components/Button';

import ReportsController from '../../controllers/show/ReportsController';

import '../../assets/css/show/Reports.css';


const Reports = () => {

    const reportsController = ReportsController();
    const [reportes, setReportes] = useState([]);

    useEffect(() => {
        window.scrollTo(0, 0);
        
        reportsController.handleGet()
        .then((jsonData) => {setReportes(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);

    return (
    <div className='report_contenedor'>

        <div>
          <Header/>
        </div>

        <div className='report_contenedor-titulo'>
          <h1> REPORTES</h1>
        </div>

        <div className='report_contenedor-tabla'>
        
            <table className='report_tabla'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Telefono</th>
                        <th>Fecha</th>
                        <th>Localizacion</th>
                    </tr>
                </thead>
                <tbody>
                    {reportes.map((reporte) => (
                    <tr key={reporte.id} onClick={() => reportsController.handleRowClick(reporte)}>
                    <td>{reporte.id}</td>
                    <td>{reporte.telefono}</td>
                    <td>{reporte.fecha}</td>
                    <td>{reporte.localizacion}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>

        <div className='report_boton-agregar'>
            <Button buttonText="Crear" route="/crear-reporte" />
        </div>

        <div className='report_boton-cancelar'>
            <Button buttonText="Cancelar" route="/menu" />
        </div>
             
        <div className='report_footer'>
            <Footer/>
        </div>
       
    </div>
  );

};

export default Reports;