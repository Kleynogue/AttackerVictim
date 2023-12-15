import React from 'react';
import ButtonController from '../controllers/components/ButtonController';

import '../assets/css/components/Button.css';

const Button = ({ buttonText, route }) => {
  const buttonController = ButtonController();

  const handleClick = () => {
    buttonController.handleClick(route);
  };

  return (
    <div className='container-button'>
      <button onClick={handleClick} className='button'>
        {buttonText}
      </button>
      
    </div>
  );
};

export default Button;