package Entidades.Elementos;

public class Turno {
    int cantidad;
    int cantidadParaSerHabilitado;

    public Turno() {
        this.cantidad = 0;
        this.cantidadParaSerHabilitado = 0;
    }

    public void agregarTurnoJugado() {
        this.cantidad++;
        if (this.cantidadParaSerHabilitado > 0){
            cantidadParaSerHabilitado--;
        }
    }

    public boolean estaHabilitado() {
        return this.cantidadParaSerHabilitado == 0;
    }

    public int turnosJugados() {
        return this.cantidad;
    }
    /*
    public void perderUnTurno () {
        this.habilitado = -1;
    }
     */
    public void perderTurnos(int cantidadAPerder){
        this.cantidadParaSerHabilitado = cantidadAPerder;
    }
}