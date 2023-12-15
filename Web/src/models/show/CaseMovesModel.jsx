const CaseMovesModel = () => {

    const fetchData = async () => {
        try {
            // Obtener los datos de la API
            // const response = await fetch('URL_DE_LA_API');
            // const jsonData = await response.json();
        
            // Simulación de los datos de JSON
            const jsonData =   `[{ "id": 1, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 2, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 3, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 4, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 },
                                { "id": 5, "fecha": "00/00/0000 00:00", "X": 0, "Y": 0, "Z": 0 }]`;

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

export default CaseMovesModel;