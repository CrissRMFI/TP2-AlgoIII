package modelo.errores;

public class ElNombreDebeContenerUnMinimoDe4Caracteres extends Exception {
    public ElNombreDebeContenerUnMinimoDe4Caracteres(String mensaje) {
        super(mensaje);
    } // TODO: este error deberia ser lanzado por el constructor de Jugador
}
