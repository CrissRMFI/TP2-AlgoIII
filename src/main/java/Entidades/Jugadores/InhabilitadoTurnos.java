package Entidades.Jugadores;

import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

public class InhabilitadoTurnos extends Estado{

    private final Turno turnosRestantes;

    public InhabilitadoTurnos(Jugador jugador, Turno turnosRestantes) {
        super(jugador);
        this.turnosRestantes = turnosRestantes;
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        turnosRestantes.restarTurno();
        if (turnosRestantes.esMenorAUno()) {
            this.jugador.setEstado(new Habilitado(this.jugador));
        }
        return casillero;
    }
}
