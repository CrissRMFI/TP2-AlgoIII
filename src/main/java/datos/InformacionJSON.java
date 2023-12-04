package datos;

import modelo.errores.ArchivoNoEncontrado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.File;
import java.io.IOException;

public class InformacionJSON {
    String rutaDelArchivoJSON;

    public InformacionJSON(String rutaDelArchivoJSON) {
        this.rutaDelArchivoJSON = rutaDelArchivoJSON;
    }

    public JsonNode devolverInformacionDelArchivo() throws ArchivoNoEncontrado {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode informacion = objectMapper.readTree(new File(this.rutaDelArchivoJSON));
            return informacion;
        }
        catch (IOException a){
            throw new ArchivoNoEncontrado();
        }
    }

}
