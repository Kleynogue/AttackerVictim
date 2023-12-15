import React, { useState, useEffect } from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Button from '../../components/Button';

import PhoneController from '../../controllers/show/PhonesController';

import '../../assets/css/show/Phones.css';


const Phones = () => {

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
        </div>

        <div className='phone_contenedor-titulo'>
          <h1> TELEFONOS</h1>
        </div>

        <div className='phone_contenedor-tabla'>
        
            <table className='phone_tabla'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Numero</th>
                        <th>Bluetooth</th>
                        <th>Usuario</th>
                        <th>Caso</th>
                    </tr>
                </thead>
                <tbody>
                    {telefonos.map((telefono) => (
                    <tr key={telefono.id} onClick={() => phoneController.handleRowClick(telefono)}>
                    <td>{telefono.id}</td>
                    <td>{telefono.numero}</td>
                    <td>{telefono.bluetooth}</td>
                    <td>{telefono.usuario}</td>
                    <td>{telefono.caso}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>

        <div className='phone_boton-agregar'>
            <Button buttonText="Crear" route="/crear-telefono" />
        </div>

        <div className='phone_boton-cancelar'>
            <Button buttonText="Cancelar" route="/menu" />
        </div>
             
        <div className='phone_footer'>
            <Footer/>
        </div>
       
    </div>
  );

};

export default Phones;