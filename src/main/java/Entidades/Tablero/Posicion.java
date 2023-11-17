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

    public void cambiarPosicion (Posicion posicion) {
        this.x = this.x + posicion.obtenerPosicionLineal();
        this.y = this.y + posicion.obtenerPosicionAltura();

    }

    public boolean comparar (Posicion posicion) {
        return this.x == posicion.x && this.y == posicion.y;
    }



}