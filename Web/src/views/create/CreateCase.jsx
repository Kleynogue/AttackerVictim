import React, { useState, useEffect, useRef } from 'react';
import { Form, Row} from 'react-bootstrap';
import { useLocation } from 'react-router-dom';

import Button from 'react-bootstrap/Button';
import ButtonCompo from '../../components/Button';
import Footer from "../../components/Footer";
import Header from "../../components/Header";
import Navbar from '../../components/Navbar';
import InputField from '../../components/InputField';
import Dropdown from '../../components/Dropdown';

import CreateCaseController from '../../controllers/create/CreateCaseController';

import '../../assets/css/create/CreateCase.css';

const CreateCase = () => {
    
    const createCaseController = CreateCaseController();
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);

    const [url, setUrl] = useState([]);
    const [agresores, setAgresores] = useState([]);
    const [victimas, setVictimas] = useState([]);

    const [agresorSeleccionado, setAgresorSeleccionado] = useState(null);
    const [victimaSeleccionada, setVictimaSeleccionada] = useState(null);
    const [idAgresorSeleccionado, setIdAgresorSeleccionado] = useState(null);
    const [idVictimaSeleccionada, setIdVictimaSeleccionada] = useState(null);
    const [numeroVictima, setNumeroVictima] = useState("");
    const [bluetoothVictima, setBluetoothVictima] = useState("");
    const [numeroAgresor, setNumeroAgresor] = useState("");
    const [bluetoothAgresor, setBluetoothAgresor] = useState("");

    const queryParamsUser = new URLSearchParams({
        usuario: searchParams.get('usuario'),
    });

    const optionsStatus = [
        { key: '1', value: 'Activo', label: 'Activo' }, 
        { key: '2', value: 'Concluido', label: 'Concluido' }, 
    ];

    useEffect(() => {
        //Se actualizan los valores de la url
        const queryParams = new URLSearchParams({
            usuario: searchParams.get('usuario'),
            tipo: "caso",
            agresorSeleccionado: agresorSeleccionado,
            victimaSeleccionada: victimaSeleccionada,
            idAgresorSeleccionado: idAgresorSeleccionado,
            idVictimaSeleccionada: idVictimaSeleccionada,
            numeroAgresor: numeroAgresor,
            numeroVictima: numeroVictima, 
            bluetoothAgresor: bluetoothAgresor,
            bluetoothVictima: bluetoothVictima,
        });
    
        setUrl(`?${queryParams.toString()}`);
    }, [numeroVictima,bluetoothVictima,numeroAgresor,bluetoothAgresor, agresorSeleccionado, victimaSeleccionada, idAgresorSeleccionado, idVictimaSeleccionada]);


    useEffect(() => {
        window.scrollTo(0, 0);  
        
        createCaseController.handleGetAttackers()
        .then((jsonData) => {setAgresores(jsonData);})
        .catch((error) => { console.error('Error al obtener los datos:', error);});

        createCaseController.handleGetVictims()
        .then((jsonData) => {setVictimas(jsonData);})
        .catch((error) => {console.error('Error al obtener los datos:', error);});

        //Se cargan los valores de la URL
        const searchParams = new URLSearchParams(location.search);
        createCaseController.handleLoad(searchParams.get('agresorSeleccionado'), setAgresorSeleccionado);
        createCaseController.handleLoad(searchParams.get('victimaSeleccionada'), setVictimaSeleccionada);
        createCaseController.handleLoad(searchParams.get('idAgresorSeleccionado'), setIdAgresorSeleccionado);
        createCaseController.handleLoad(searchParams.get('idVictimaSeleccionada'), setIdVictimaSeleccionada);
        createCaseController.handleLoad(searchParams.get('numeroAgresor'), setNumeroAgresor);
        createCaseController.handleLoad(searchParams.get('numeroVictima'), setNumeroVictima);
        createCaseController.handleLoad(searchParams.get('bluetoothAgresor'), setBluetoothAgresor);
        createCaseController.handleLoad(searchParams.get('bluetoothVictima'), setBluetoothVictima);
    }, []);
   

    return (
        <div className='createCase_contenedor'>
            <div>    
                <Header/>
                <Navbar/>
            </div>

            <div  className='createCase_titulo'>
                <h1>CASOS</h1>
            </div>


            <div className='createCase_contenedor-participantes'>

                <div className='createCase_participante' >
                    <div  className="createCase_contenedor-participante-info">
                        <p>AGRESOR </p>
                    </div>
                    
                    {/* 
                    <p className='createCase_input-label'>Numero</p>
                    <div className='createCase_input-container'>
                        <input className='createCase_input' type="text" onChange={(e) => createCaseController.handleInputChange(e,setNumeroAgresor)} value={numeroAgresor} placeholder="Numero"/>
                    </div>*/}

                    <p className='createCase_input-label'>Bluetooth</p>
                    <div  className='createCase_input-container'>
                        <input className='createCase_input' type="text" onChange={(e) => createCaseController.handleInputChange(e,setBluetoothAgresor)} value={bluetoothAgresor} placeholder="Bluetooth" maxLength={20}/>
                    </div>

                    <div className="createCase_contenedor-tabla">
                        <table className="createCase_tabla">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDO</th>
                                </tr>
                            </thead>
                            <tbody>
                                {agresores.map((agresor) => (
                                    <tr key={agresor.id}  onClick={() => createCaseController.handleRowClickParticipantes(agresor, setAgresorSeleccionado, setIdAgresorSeleccionado)} >
                                        <td>{agresor.id}</td>
                                        <td>{agresor.nombre}</td>
                                        <td>{agresor.apellido}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>

                    <div className="createCase_contenedor-boton-participantes">
                        <ButtonCompo  buttonText="Crear" route="/crear-usuarios" id={url+"&participante=agresor"}/>
                    </div>

                    <div  className="createCase_contenedor-participante-info">
                        <p>AGRESOR: {agresorSeleccionado}</p>
                    </div>
                </div>

                <div className='createCase_participante' >
                    <div  className="createCase_contenedor-participante-info">
                        <p>VICTIMA </p>
                    </div>

                    {/* 
                    <p className='createCase_input-label'>Numero</p>
                    <div  className='createCase_input-container'>
                        <input className='createCase_input' type="text" onChange={(e) => createCaseController.handleInputChange(e,setNumeroVictima)} value={numeroVictima} placeholder="Numero"/>
                    </div>*/}

                    <p  className='createCase_input-label'>Bluetooth</p>
                    <div  className='createCase_input-container'>
                        <input className='createCase_input' type="text" onChange={(e) => createCaseController.handleInputChange(e,setBluetoothVictima)} value={bluetoothVictima} placeholder="Bluetooth" maxLength={20}/>
                    </div>

                    <div className="createCase_contenedor-tabla">
                        <table className="createCase_tabla">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>APELLIDO</th>
                                </tr>
                            </thead>
                            <tbody >
                                {victimas.map((victima) => (
                                    <tr key={victima.id} onClick={() => createCaseController.handleRowClickParticipantes(victima, setVictimaSeleccionada, setIdVictimaSeleccionada)}>
                                        <td>{victima.id}</td>
                                        <td>{victima.nombre}</td>
                                        <td>{victima.apellido}</td>
                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>

                    <div className="createCase_contenedor-boton-participantes">
                        <ButtonCompo  buttonText="Crear" route="/crear-usuarios" id={url+"&participante=victima"}/>
                    </div>

                    <div  className="createCase_contenedor-participante-info">
                        <p>VICTIMA: {victimaSeleccionada}</p>
                    </div>
                </div>

            </div>

            <div className="createCase_contenedor-form">
                <Form onSubmit={(e) => createCaseController.handleCreate(e,searchParams.get('usuario'), idAgresorSeleccionado, idVictimaSeleccionada,bluetoothAgresor,bluetoothVictima)} className="createCase_form">       

                        <InputField type='number'  label='Distancia' idcontrol='CaseDistancia' maxLength={5}/>
                        <InputField type='number'  label='Tiempo' idcontrol='CaseTiempo' maxLength={5}/>
                        

                        <Dropdown options={optionsStatus} label="Status" clave='CaseStatus'/>

                        <div className="createCase_contenedor-boton">
                            <Button type="submit" className="createCase_boton">Crear</Button>
                        </div>

                        <div>
                            <ButtonCompo buttonText="Volver" route="/casos" id={`?${queryParamsUser.toString()}`}/>
                        </div>

                </Form>
            </div>

            <div className='createCase_footer'>
                <Footer/>
            </div>
        </div>
      );
};

export default CreateCase;