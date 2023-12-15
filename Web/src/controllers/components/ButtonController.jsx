import { useNavigate } from 'react-router-dom';

const ButtonController = () => {
    const navigate = useNavigate();

    const handleClick = (route) => {
        navigate(route);
    };

    const handleConsoleLog = () => {
        console.log('Se presionó el botón');
    };

    return {
        handleClick,
        handleConsoleLog,
    };
};

export default ButtonController;