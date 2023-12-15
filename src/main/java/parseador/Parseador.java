package parseador;

import entidades.errores.ArchivoNoEncontrado;

public interface Parseador<T> {
    void leerArchivo(String ruta) throws ArchivoNoEncontrado;

    T obtenerInformacion();

}
