package Entidades.Elementos;

public class Turno {

    int cantidad;
    int habilitado;

    public  Turno () {
        this.cantidad = 0;
        this.habilitado = 0;
    }

    public void habilitar () {
        this.habilitado++;
    }

    public boolean estaHabilitado () {
        return this.habilitado >= 1;
    }

    public int turnosJugados () {
        return this.cantidad;
    }

    public void finalizar() {
        this.cantidad++;
        if (this.estaHabilitado()) {
            this.habilitado--;
        }

    }
    public void perderUnTurno () {
        this.habilitado = -1;
    }
}