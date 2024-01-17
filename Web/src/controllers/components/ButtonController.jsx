import { useNavigate } from 'react-router-dom';

const ButtonController = () => {
    const navigate = useNavigate();

    const handleClick = (route, id) => {
        if(id!==undefined){
            navigate(route + '' + id);
        }
        else{
            navigate(route);
        }

       /* const queryParams = new URLSearchParams({
            victima: '1',
            idvictima: '1',
            agresor: '1',
            idagresor: '1',
        });
    
        navigate(`/crear-usuarios?${queryParams.toString()}`);*/

        
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