package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;


public class InHabilitadoEnergia extends Estado {

    private Energia energiaExtraAlPasarTurno;

    public InHabilitadoEnergia(Jugador jugador) {
        super(jugador);
        this.energiaExtraAlPasarTurno = new Energia(5);
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        this.jugador.afectarEnergia(this.energiaExtraAlPasarTurno);
        if (this.jugador.tengoEnergia()) {
            this.jugador.setEstado(new Habilitado(this.jugador));
        }
        return casillero;
    }
}
