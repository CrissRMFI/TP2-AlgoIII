package modelo.errores;

public class PartidaNoFinalizada extends Exception {
    public PartidaNoFinalizada(String mensaje) {
        super(mensaje);
    }
}
