package entidades.sistemaTurnos;

public class Turno {
    protected int cantidad;


    public Turno() {
        this.cantidad = 0;
    }

    public Turno(int cantidad) {
        this.cantidad = cantidad;
    }

    public void finalizarTurno() {
        this.cantidad++;
    }

    public boolean puedeAscender(Turno turno) {
        return this.cantidad > turno.cantidad;
    }

    public void restarTurno() {
        this.cantidad--;
    }

    public void sumarTurno() {
        this.cantidad++;
    }

    public boolean igualACero() {
        return this.cantidad == 0;
    }
}
