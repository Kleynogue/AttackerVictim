import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Navbar from '../../components/Navbar';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import ModifyUserController from '../../controllers/modify/ModifyUserController';

import '../../assets/css/modify/ModifyUser.css';

const ModifyUser = () => {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const modifyUserController = ModifyUserController();
    const [data, setData] = useState([]);
    const [tipoActual, setTipoActual] = useState();
    const [participante, setParticipante] = useState();

    const optionsTipo = [
        { key: '1', value: 'empty', label: '-Deseleccionar-' },
        { key: '3', value: 'Agresor', label: 'Agresor' },
        { key: '4', value: 'Victima', label: 'Victima' }, 
    ];

    const queryParamsUser = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    const queryParams = new URLSearchParams({
        usuario: searchParams.get('usuario'),
        participante: searchParams.get('participante'),
    });

    useEffect(() => {
        window.scrollTo(0, 0);     
        
        setParticipante(searchParams.get('participante'));

        modifyUserController.handleGet(searchParams.get('participante'))
        .then((jsonData) => {
            setData(jsonData);
            setTipoActual("(Valor actual: " + jsonData.tipo+ ")");
        })
        .catch((error) => {
            console.error('Error al obtener los datos:', error);
        });

    }, []);

    return (
        <div className='modifyUser_contenedor'>
            <div>
                <Header/>
                <Navbar/>
            </div>

            <div className='modifyUser_titulo'>
                <h1>USUARIOS</h1>
            </div>

            <div >
                <Form onSubmit={(e) => modifyUserController.handleActualizar(e,participante,data)} className="modifyUser_form">
                        <p className='modifyUser_id'>id: {participante}</p>
                        <p className='modifyUser_id'>Tipo: {data.tipo}</p>
                        <InputField type='text'  label='Nombre' idcontrol='UserNombre' ph={data.nombre} maxLength={20}/>
                        <InputField type='text'  label='Apellido' idcontrol='UserApellido' ph={data.apellido} maxLength={20}/>
                        <InputField type='text'  label='Usuario' idcontrol='UserUsuario' ph={data.usuario} maxLength={20}/>
                        {/*<InputField type='text'  label='Password' idcontrol='UserPassword' ph={data.password}/>*/}
                        <InputField type='text'  label='Direccion' idcontrol='UserDireccion' ph={data.direccion} maxLength={20}/>
                        {/*<Dropdown options={optionsTipo} label="Tipo" actual={tipoActual} clave='UserTipo' />*/}

                        <div className="modifyUser_contenedor-boton">
                            <Button type="submit" className="modifyUser_boton">Actualizar</Button>
                        </div>

                        <div >
                            <ButtonCompo buttonText="Volver" route="/usuarios" id={`?${queryParamsUser.toString()}`}/>
                        </div>
                        
                        {/*<div className="modifyUser_contenedor-boton">
                            <Button onClick={() => modifyUserController.handleDelete(participante)} className="modifyUser_boton">Eliminar</Button>
                        </div>*/}
                </Form>
            
            </div>

            <div className='modifyUser_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default ModifyUser;