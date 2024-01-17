
import './App.css';

import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import LoginForm from './views/control/LoginForm';
import Menu from './views/control/Menu';
import ModifyZone from './views/modify/ModifyZone';
import Zones from './views/show/Zones';
import ModifyUser from './views/modify/ModifyUser';
import CreateUser from './views/create/CreateUser';
import CreateZone from './views/create/CreateZone';
import ModifyCase from './views/modify/ModifyCase';
import Cases from './views/show/Cases';
import CreateCase from './views/create/CreateCase';
import Phones from './views/show/Phones';
import ModifyPhone from './views/modify/ModifyPhone';
import CreatePhone from './views/create/CreatePhone';
import Users from './views/show/Users';
import Reports from './views/show/Reports';
import ModifyReporte from './views/modify/ModifyReport';
import CreateReport from './views/create/CreateReport';
import CasePoints from './views/show/CasePoints';
import CaseMoves from './views/show/CaseMoves';
import CaseWifi from './views/show/CaseWifi';

function App() {
  return (
    <div>
      <Router>
          
          <div className="container">
            <Routes>
                <Route path='/' element={<LoginForm/>}></Route>
                <Route path='/menu' element={<Menu/>}></Route>
                <Route path='/usuarios' element={<Users/>}></Route>
                    <Route path='/crear-usuarios' element={<CreateUser/>}></Route>
                    <Route path="/modificar-usuario" element={<ModifyUser/>}></Route>
                <Route path='/zonas' element={<Zones/>}></Route>
                    <Route path='/modificar-zona' element={<ModifyZone/>}></Route>
                    <Route path='/crear-zona' element={<CreateZone/>}></Route>
                <Route path='/casos' element={<Cases/>}></Route>
                    <Route path='/modificar-caso' element={<ModifyCase/>}></Route>
                    <Route path='/crear-caso' element={<CreateCase />} />
                <Route path='/telefonos' element={<Phones/>}></Route>
                    <Route path='/modificar-telefono' element={<ModifyPhone/>}></Route>
                    <Route path='/crear-telefono/:id' element={<CreatePhone/>}></Route>

                <Route path='/historico/reportes' element={<Reports/>}></Route>
                    <Route path='/modificar-reporte/:id' element={<ModifyReporte/>}></Route>
                    <Route path='/crear-reporte' element={<CreateReport/>}></Route>

                <Route path='/historico/puntos' element={<CasePoints/>}></Route>
                <Route path='/historico/movimientos' element={<CaseMoves/>}></Route>
                <Route path='/historico/wifi' element={<CaseWifi/>}></Route>



            </Routes> 
          </div>
      </Router>
    </div>
  );
}

export default App;
