import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Button from '../../components/Button';

import PhoneController from '../../controllers/show/PhonesController';

import '../../assets/css/show/Phones.css';


const Phones = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const phoneController = PhoneController();
    const [telefonos, setTelefonos] = useState([]);

    useEffect(() => {
        window.scrollTo(0, 0);
        
        phoneController.handleGet()
        .then((jsonData) => {setTelefonos(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);

    return (
    <div className='phone_contenedor'>

        <div>
          <Header/>
          <Navbar />
        </div>

        <div className='phone_contenedor-titulo'>
          <h1> TELEFONOS</h1>
        </div>

        <div className='phone_contenedor-tabla'>
        
            <table className='phone_tabla'>
                <thead>
                    <tr>
                        <th>ID</th>
                        {/*<th>Numero</th>*/}
                        <th>Bluetooth</th>
                        <th>Fecha Inicial</th>
                        {/*<th>Fecha Final</th>*/}
                        <th>Usuario</th>
                        <th>Caso</th>
                    </tr>
                </thead>
                <tbody>
                    {telefonos.map((telefono) => (
                    <tr key={telefono.id} onClick={() => phoneController.handleRowClick(telefono, searchParams.get('usuario'))}>
                    <td>{telefono.id}</td>
                    {/*<td>{telefono.numero}</td>*/}
                    <td>{telefono.bluetooth}</td>
                    <td>{telefono.fecha_inicial}</td>
                    {/*<td>{telefono.fecha_final}</td>*/}
                    <td>{telefono.usuario}</td>
                    <td>{telefono.caso}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>
{/*
        <div className='phone_boton-agregar'>
            <Button buttonText="Crear" route="/crear-telefono" />
        </div>
*/ }     
        <div className='phone_footer'>
            <Footer/>
        </div>
       
    </div>
  );

};

export default Phones;