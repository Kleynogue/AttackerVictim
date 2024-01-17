import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import Footer from '../../components/Footer';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Button from '../../components/Button';

import UsersController from '../../controllers/show/UsersController';

import '../../assets/css/show/Users.css';


const Users = () => {

    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const usersController = UsersController();
    const [usuarios, setUsuarios] = useState([]);

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);     
        
        usersController.handleGet()
        .then((jsonData) => {setUsuarios(jsonData);
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });
    }, []);

    return (
    <div className='user_contenedor'>

        <div>
          <Header/>
          <Navbar/>
        </div>

        <div className='user_contenedor-titulo'>
          <h1>USUARIOS</h1>
        </div>

        <div className='user_contenedor-tabla'>
        
            <table className='user_tabla'>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>User</th>
                        {/*<th>Password</th>*/}
                        <th>Dirección</th>
                        <th>Tipo</th>
                    </tr>
                </thead>
                <tbody>
                    {usuarios.map((usuario) => (
                    <tr key={usuario.id} onClick={() => usersController.handleRowClick(usuario, searchParams.get('usuario'))}>
                    <td>{usuario.id}</td>
                    <td>{usuario.nombre}</td>
                    <td>{usuario.apellido}</td>
                    <td>{usuario.user}</td>
                    {/*<td>{usuario.password}</td>*/}
                    <td>{usuario.direccion}</td>
                    <td>{usuario.tipo}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>

        <div className='user_boton-agregar'>
            <Button buttonText="Crear" route="/crear-usuarios" id={`?${queryParams.toString()+"&tipo=mostrar"}`}/>
        </div>
             
        <div className='user_footer'>
            <Footer/>
        </div>
       
    </div>
  );

};

export default Users;