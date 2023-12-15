import { useNavigate } from 'react-router-dom';

const MenuController = () => {
    const navigate = useNavigate();

    const handleItemClick = (url) => {
        navigate(url);
    };
  
    return {
        handleItemClick,
    };
};

export default MenuController;