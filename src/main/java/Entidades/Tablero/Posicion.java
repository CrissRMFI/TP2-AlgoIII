package Entidades.Tablero;

public interface Posicion {
    public abstract Posicion cambiarPosicion (Posicion posicion);
    public abstract Coordenada obtenerCoordenada();
    public abstract boolean esIgual(Posicion posicion);
    public abstract boolean esMayorIgual(Posicion posicion);
}
