package Entidades.Elementos;

public class Turno {
    boolean disponible;
    int cantidad;

    public  Turno () {
        this.disponible = false;
        this.cantidad = 0;
    }

    public void habilitar () {
        this.disponible = true;
    }

    public boolean estaHabilitado () {
        return this.disponible;
    }

    public void sumarTurno () {
        this.cantidad += 1;
    }

    public void deshabilitar () {
        this.disponible = false;
    }

    public int turnosJugados () {
        return this.cantidad;
    }
}
