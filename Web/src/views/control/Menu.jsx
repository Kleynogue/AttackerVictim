import React, { useState, useEffect } from 'react';
import Footer from '../../components/Footer';
import Header from '../../components/Header';

import MenuController from '../../controllers/control/MenuController';

import '../../assets/css/control/Menu.css';

const Menu = () => {

    const { handleItemClick } = MenuController();

    useEffect(() => {
        window.scrollTo(0, 0);     
    }, []);

    return (
        <div className='menu_contenedor'>

            <div>
                <Header/>
            </div>

            <ul className="menu_lista">
                <li onClick={() => handleItemClick('/usuarios')}>Usuarios</li>
                <li onClick={() => handleItemClick('/zonas')}>Zonas</li>
                <li onClick={() => handleItemClick('/casos')}>Casos</li>
                <li onClick={() => handleItemClick('/telefonos')}>Telefonos</li>
                <li onClick={() => handleItemClick('/reportes')}>Reportes</li>
                <li onClick={() => handleItemClick('/configuracion')}>Configuración</li>
            </ul>
            
            <div className='menu_footer'>
                <Footer/>    
            </div>
        
        </div>
    );
};

export default Menu;