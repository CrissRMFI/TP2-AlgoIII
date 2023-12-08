package Parseador;

import Entidades.Errores.ArchivoNoEncontrado;

public interface Parseador<T> {
    void leerArchivo(String ruta) throws ArchivoNoEncontrado;
    T obtenerInformacion ();

}
