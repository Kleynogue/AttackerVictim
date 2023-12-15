import React from 'react';
import '../assets/css/components/Dropdown.css';


const Dropdown = ({ label, options, actual, clave}) => {
    const handleChange = (event) => {
      // Aquí puedes manejar la lógica cuando se selecciona una opción del menú desplegable
      //console.log(event.target.value);
    };
  
    return (
        <div>
            <div>
                <label className='dropdown_label'>{label} {actual}</label>
            </div>

            <select className='dropdown_menu' name={clave} onChange={handleChange}>
            {options.map((option) => (
                <option key={option.key} value={option.value}>
                {option.label}
                </option>
            ))}
            </select>
   
        </div>
    );
  };
  export default Dropdown;