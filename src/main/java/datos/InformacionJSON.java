package datos;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entidades.errores.ArchivoNoEncontrado;

import java.io.File;
import java.io.IOException;

public class InformacionJSON {
    private String rutaDelArchivo;

    public InformacionJSON(String rutaDelArchivo) {
        this.rutaDelArchivo = rutaDelArchivo;
    }

    public JsonNode devolverInformacionDelArchivo() throws ArchivoNoEncontrado {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode informacion = objectMapper.readTree(new File(this.rutaDelArchivo));
            return informacion;
        } catch (IOException a) {
            throw new ArchivoNoEncontrado();
        }
    }

}
