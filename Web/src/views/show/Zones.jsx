import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import ButtonCompo from '../../components/Button';

import ZonesController from '../../controllers/show/ZonesController';

import '../../assets/css/show/Zones.css';

const Zones = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const zonesController = ZonesController();
    const [zonas, setZonas] = useState([]);
    const [caso, setCaso] = useState();

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        caso: searchParams.get('caso'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);

        setCaso(searchParams.get('caso'));

        zonesController.handleGet(searchParams.get('caso'))
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
                <Navbar/>
            </div>
            
            <div className='zone_contenedor-titulo'>
                <h1>ZONAS (caso: {caso})</h1>
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
                        <tr key={zona.id} onClick={() => zonesController.handleRowClick(zona,caso,searchParams.get('usuario'))}>
                            <td>{zona.id}</td>
                            <td>{zona.nombre}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            <div className='zone_boton-agregar'>
                <ButtonCompo buttonText="Crear" route="/crear-zona" id={`?${queryParams.toString()}`}/>
            </div>

            <div className='zone_boton-cancelar'>
                <ButtonCompo buttonText="Volver" route="/modificar-caso" id={`?${queryParams.toString()}`}/>
            </div>
        
            <div className='zone_footer'>
                <Footer/>
            </div>

        </div>
    );

};

export default Zones;