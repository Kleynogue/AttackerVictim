import React from 'react';
import { useLocation } from 'react-router-dom';
import '../assets/css/components/Navbar.css'; 
const Navbar = (usuario) => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const queryParams = new URLSearchParams({  
        usuario: searchParams.get('usuario'), 
    });

    return (
        <div className="navbar_contenedor"> 
            <nav className="navbar">
            <ul>
                <li><a href={"/casos"+ `?${queryParams.toString()}`}>Casos</a></li>
                <li><a href={"/usuarios"+ `?${queryParams.toString()}`}>Usuarios</a></li>
                <li><a href={"/telefonos"+ `?${queryParams.toString()}`}>Telefonos</a></li>
            </ul>
            </nav>
        </div>
    );
};

export default Navbar;