package Entidades.Errores;

public class PartidaFinalizada extends Exception{
    public PartidaFinalizada (String mensaje) {
        super(mensaje);
    }
}
