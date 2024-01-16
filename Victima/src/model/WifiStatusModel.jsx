import RNFS from 'react-native-fs';
const WifiStatusModel = () => {

    const handleStatusAlertSQL = async (path) => {
        //console.log('Este metodo debe enviar la alerta cuando se encuentre sin conexion'); 

        try {
            console.log("Se cargan estos datos----------------------------------------------");
            const response = await RNFS.readFile(RNFS.DocumentDirectoryPath+path);
            //alert(response);
            console.log(response);
            console.log("-------------------------------------------------------------------");

            RNFS.unlink(RNFS.DocumentDirectoryPath + path);

            RNFS.writeFile(RNFS.DocumentDirectoryPath + path, "[]", "utf8");
        }catch (error) { //if the function throws an error, log it out.
            console.log(error);
        }

    };

    return {
        handleStatusAlertSQL,
    };
};

export default WifiStatusModel;