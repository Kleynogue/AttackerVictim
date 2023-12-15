const UsersModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData = `[ {"id": 1,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Victima"},
                                {"id": 2,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Victima"},
                                {"id": 3,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Victima"},
                                {"id": 4,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Agresor"},
                                {"id": 5,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Agresor"},
                                {"id": 6,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Agresor"},
                                {"id": 7,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Agresor"},
                                {"id": 8,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Administrador"},
                                {"id": 9,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Administrador"},
                                {"id": 10,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Administrador"},
                                {"id": 11,"nombre": "John","apellido": "Doe","user": "johndoe","password": "123456","direccion": "Calle 123", "tipo": "Administrador"},
                                {"id": 12,"nombre": "Jane","apellido": "Smith","user": "janesmith","password": "abcdef","direccion": "Calle 456", "tipo": "Administrador"}]`;
        
            return jsonData;
        } catch (error) {
            console.error('Error al obtener los datos:', error);
            return null;
        }
    };

    return {
        fetchData,
    };
};

export default UsersModel;