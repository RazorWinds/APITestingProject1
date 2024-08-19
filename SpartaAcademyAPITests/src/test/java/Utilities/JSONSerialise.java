package Utilities;

import Pojos.Pojo;
import Pojos.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;

public class JSONSerialise {
    static final ObjectMapper mapper = new ObjectMapper();
    static final String pathName = "src/test/resources/JSONFiles/";

    public static <T> T deserialize(String fileName, Class<T> pojoClass){
        Path path;

        try {
            path = Paths.get(pathName+fileName+".json");
        }catch(InvalidPathException e){
            try {
                return mapper.readValue(fileName, pojoClass);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException(ex);
            }
        }


        try {
            byte[] file = Files.readAllBytes(path);
            return mapper.readValue(file, pojoClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static String serialise(Pojo object){
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRawJSON(String fileName){
        Path path = Paths.get(pathName+fileName+".json");
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isJSONValid(String jsonInString) {
        try {
            mapper.readTree(jsonInString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
