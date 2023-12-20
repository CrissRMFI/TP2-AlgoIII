package entidades.jugadores;

import entidades.sistemaTurnos.Turno;
import entidades.tablero.Casillero;
import entidades.tablero.Mapa;

public class InhabilitadoTurnos extends Estado {

    private final Turno turnosRestantes;

    public InhabilitadoTurnos(Jugador jugador, Turno turnosRestantes) {
        super(jugador);
        this.turnosRestantes = turnosRestantes;
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        turnosRestantes.restarTurno();
        if (turnosRestantes.igualACero()) {
            this.jugador.setEstado(new Habilitado(this.jugador));
        }
        return casillero;
    }
}
