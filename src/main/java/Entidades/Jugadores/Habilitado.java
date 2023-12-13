package Entidades.Jugadores;


import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

public class Habilitado extends Estado {

    public Habilitado(Jugador jugador) {
        super(jugador);
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        int posicionesAMover = jugador.lanzar();
        Casillero casilleroAMover = mapa.obtenerProximoDestino(casillero, posicionesAMover);
        casilleroAMover.entregarElementos(this.jugador);

        if (!this.jugador.tengoEnergia()) {
            this.jugador.setEstado(new InHabilitadoEnergia(this.jugador));
        }

        return casilleroAMover;
    }


}
