package Entidades.Jugadores;

public class Turno {
    protected int cantidad;


    public Turno () {}

    public Turno (int cantidad) {
        this.cantidad = cantidad;
    }

    public void finalizarTurno () {
        this.cantidad++;
    }

    public boolean puedeAscender (Turno turno) {
        return this.cantidad > turno.cantidad;
    }

}
