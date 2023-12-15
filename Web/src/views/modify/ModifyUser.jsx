import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import ButtonCompo from '../../components/Button';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import ModifyUserController from '../../controllers/modify/ModifyUserController';

import '../../assets/css/modify/ModifyUser.css';

const ModifyUser = () => {

    const modifyUserController = ModifyUserController();
    const params = useParams();
    const [data, setData] = useState([]);
    const [tipoActual, setTipoActual] = useState();
    
    const optionsTipo = [
        { key: '1', value: 'empty', label: '-Deseleccionar-' },
        { key: '2', value: 'administrador', label: 'Administrador' }, 
        { key: '3', value: 'agresor', label: 'Agresor' },
        { key: '4', value: 'victima', label: 'Victima' }, 
    ];

    useEffect(() => {
        window.scrollTo(0, 0);     
        
        modifyUserController.handleGet(params.id)
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
            </div>

            <div className='modifyUser_titulo'>
                <h1>USUARIOS</h1>
            </div>

            <div >
                <Form onSubmit={(e) => modifyUserController.handleActualizar(e,params.id)} className="modifyUser_form">
                        <p className='modifyUser_id'>id: {params.id}</p>
                        <InputField type='text'  label='Nombre' idcontrol='UserNombre' ph={data.nombre}/>
                        <InputField type='text'  label='Apellido' idcontrol='UserApellido' ph={data.apellido}/>
                        <InputField type='text'  label='Usuario' idcontrol='UserUsuario' ph={data.usuario}/>
                        <InputField type='text'  label='Password' idcontrol='UserPassword' ph={data.password}/>
                        <InputField type='text'  label='Direccion' idcontrol='UserDireccion' ph={data.direccion}/>
                        <Dropdown options={optionsTipo} label="Tipo" actual={tipoActual} clave='UserTipo' />

                        <div className="modifyUser_contenedor-boton">
                            <Button type="submit" className="modifyUser_boton">Actualizar</Button>
                        </div>

                        <div >
                            <ButtonCompo buttonText="Cancelar" route="/usuarios"/>
                        </div>

                        <div className="modifyUser_contenedor-boton">
                            <Button onClick={() => modifyUserController.handleDelete(params.id)} className="modifyUser_boton">Eliminar</Button>
                        </div>
                </Form>
            
            </div>

            <div className='modifyUser_footer'>
                <Footer/>
            </div>
            
        </div>
    );
};

export default ModifyUser;