import RNFS from 'react-native-fs';

const ArchiveViewmodel = () => {

    const makeFile = async (datos, path) => {
        try {
          //create a file at filePath. Write the content data to it
          await RNFS.writeFile(RNFS.DocumentDirectoryPath+path, datos, "utf8");
          //console.log("written to file");
        } catch (error) { //if the function throws an error, log it out.
          console.log(error);
        }
    };

    const appendToJsonArray = (existingJson, newJson) => {
        try {
          let jsonArray = [];
          if (existingJson) {
            jsonArray = JSON.parse(existingJson);
            if (!Array.isArray(jsonArray)) {
              throw new Error('El JSON existente no es un array válido.');
            }
          }
      
          const newObj = JSON.parse(newJson);
          jsonArray.push(newObj);
      
          const mergedJson = JSON.stringify(jsonArray);
          return mergedJson;
        } catch (error) {
          console.error('Error al agregar el nuevo valor JSON:', error);
          return existingJson;
        }
      };

      
    const saveDataToJsonFile = async (data, path) => {
        
        const response = await RNFS.readFile(RNFS.DocumentDirectoryPath+path);

        const jsonData = JSON.stringify(data);
        const mergedJson = appendToJsonArray(response, jsonData);
        makeFile(mergedJson, path);
        console.log("----"+mergedJson);
      };

      return {
        makeFile,
        appendToJsonArray,
        saveDataToJsonFile,
    };
};

export default ArchiveViewmodel;