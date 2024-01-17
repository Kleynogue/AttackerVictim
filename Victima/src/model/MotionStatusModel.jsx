import RNFS from 'react-native-fs';
const MotionStatusModel = () => {

    const handleMotionAlertSQL = async (path) => {
        //console.log('Este metodo debe enviar la alerta cuando se encuentre inmovil'); 

        try {
            //console.log("Se cargan estos datos----------------------------------------------");
            const response = await RNFS.readFile(RNFS.DocumentDirectoryPath+path);
            //console.log(response);
            //console.log("-------------------------------------------------------------------");

            RNFS.unlink(RNFS.DocumentDirectoryPath + "/motion.txt");

            RNFS.writeFile(RNFS.DocumentDirectoryPath + "/motion.txt", "[]", "utf8");
        }catch (error) { //if the function throws an error, log it out.
            //console.log(error);
        }

    };

    return {
        handleMotionAlertSQL,
    };
};

export default MotionStatusModel;