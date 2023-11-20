package Entidades.Tablero;

public interface Posicion {
    public boolean igual(Posicion posicion);
    public boolean mayorIgual (Posicion posicion);
    public Posicion cambiarPosicion (Posicion posicion);
    public Coordenada obtenerCoordenada ();
}
