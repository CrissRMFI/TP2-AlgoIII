package Entidades.Tablero;

public interface Posicion {
    public boolean comparar (Posicion posicion);
    public Posicion cambiarPosicion (Posicion posicion);
    public Coordenada obtenerCoordenada ();
}
