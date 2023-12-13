package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;


public class InHabilitado extends Estado {

    private int turnosRestantes;
    private Energia energiaExtraAlPasarTurno;

    public InHabilitado(Jugador jugador, int turnosRestantes) {
        super(jugador);
        this.turnosRestantes = turnosRestantes;
        this.energiaExtraAlPasarTurno = new Energia(0);
    }

    public InHabilitado(Jugador jugador) {
        this(jugador, 1);
        this.energiaExtraAlPasarTurno = new Energia(5);
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        turnosRestantes--;
        this.jugador.afectarEnergia(this.energiaExtraAlPasarTurno);
        if (turnosRestantes <= 0 && this.jugador.tengoEnergia()) {
            this.jugador.setEstado(new Habilitado(this.jugador));
        }
        return casillero;
    }
}
