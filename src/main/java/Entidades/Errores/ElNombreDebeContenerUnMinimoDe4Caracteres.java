package Entidades.Errores;

public class ElNombreDebeContenerUnMinimoDe4Caracteres extends Exception{
    public ElNombreDebeContenerUnMinimoDe4Caracteres(String mensaje) {
        super(mensaje);
    }
}