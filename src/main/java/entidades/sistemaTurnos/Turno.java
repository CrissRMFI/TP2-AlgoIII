package entidades.sistemaTurnos;

public class Turno {
    protected int cantidad;

    public Turno() {
        this.cantidad = 0;
    }

    public Turno(int cantidad) {
        this.cantidad = cantidad;
    }

    protected int cantidadDeTurnos(){
        return this.cantidad;
    }

    public void finalizarTurno() {
        this.cantidad++;
    }

    public boolean esMayorQue(Turno turno) {
        return this.cantidad > turno.cantidadDeTurnos();
    }

    public void restarTurno() {
        this.cantidad--;
    }

    public boolean esMenorA(Turno turno){
        return this.cantidad < turno.cantidadDeTurnos();
    }
  
    public void sumarTurno() {
        this.cantidad++;
    }

    public boolean esIgualA(Turno turno){
        return this.cantidad == turno.cantidadDeTurnos();
    }
}
