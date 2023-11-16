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

    public Posicion cambiarPosicion (Posicion posicion) {
        int x = this.x + obtenerPosicionLineal();
        int y = this.y + obtenerPosicionAltura();
        return new Posicion(x,y);
    }

    public boolean comparar (Posicion posicion) {
        return this.x == posicion.x && this.y == posicion.y;
    }



}