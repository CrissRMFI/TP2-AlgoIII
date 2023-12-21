package entidades.obstaculos;


import entidades.Interactuable;
import entidades.jugadores.InhabilitadoTurnos;
import entidades.jugadores.Jugador;
import entidades.sistemaTurnos.Turno;

public class Lesion implements Interactuable {

    private final Turno turnosAPerder;

    public Lesion() {
        this.turnosAPerder = new Turno(1);
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.setEstado(new InhabilitadoTurnos(jugador, turnosAPerder));
    }
}