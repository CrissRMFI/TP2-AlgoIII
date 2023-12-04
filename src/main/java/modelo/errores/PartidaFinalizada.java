package modelo.errores;

public class PartidaFinalizada extends Exception{
    public PartidaFinalizada (String mensaje) {
        super(mensaje);
    }
}
