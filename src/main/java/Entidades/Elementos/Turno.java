package Entidades.Elementos;

public class Turno {

    protected int cantidad;
    private int habilitado;

    public  Turno () {
        this.cantidad = 0;
        this.habilitado = 0;
    }

    public Turno (int cantidad) {
        this.cantidad = cantidad;
        this.habilitado = 0;
    }

    public void habilitar () {
        this.habilitado++;
    }

    public boolean estaHabilitado () {
        return this.habilitado >= 1;
    }

    public void finalizar() {
        this.cantidad++;
        if (this.estaHabilitado()) {
            this.habilitado--;
        }
    }

    public boolean esMayor (Turno turno) {
        return this.cantidad > turno.cantidad;
    }

    public void perderTurnos (Turno turnos) {
        int cantidad = -turnos.cantidad;
        this.habilitado = cantidad;
    }
}