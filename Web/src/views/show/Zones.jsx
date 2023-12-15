import React, { useState, useEffect } from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import ButtonCompo from '../../components/Button';

import ZonesController from '../../controllers/show/ZonesController';

import '../../assets/css/show/Zones.css';

const Zones = () => {

    const zonesController = ZonesController();
    const [zonas, setZonas] = useState([]);

    useEffect(() => {
        window.scrollTo(0, 0);
        
        zonesController.handleGet()
        .then((jsonData) => {setZonas(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);

    return (
        <div className='zone_contenedor'>
            
            <div>
                <Header/>
            </div>
            
            <div className='zone_contenedor-titulo'>
                <h1>ZONAS</h1>
            </div>

            <div className='zone_contenedor-tabla'>
                <table className='zone_tabla'>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                    </tr>
                    </thead>
                    <tbody>
                    {zonas.map((zona) => (
                        <tr key={zona.id} onClick={() => zonesController.handleRowClick(zona)}>
                            <td>{zona.id}</td>
                            <td>{zona.nombre}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className='zone_boton-agregar'>
                <ButtonCompo buttonText="Crear" route="/crear-zona" />
            </div>

            <div className='zone_boton-cancelar'>
                <ButtonCompo buttonText="Cancelar" route="/menu" />
            </div>
        
            <div className='zone_footer'>
                <Footer/>
            </div>

        </div>
    );

};

export default Zones;