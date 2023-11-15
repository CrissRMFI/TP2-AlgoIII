package Entidades.Tablero;

public class Posicion {

    private int x;
    private int y;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int obtenerPosicionLineal() {
        return x;
    }

    public int obtenerPosicionAltura() {
        return y;
    }

    public void agregarPosicion (Posicion posicion) {
        this.x += obtenerPosicionLineal();
        this.y += obtenerPosicionAltura();
    }
}