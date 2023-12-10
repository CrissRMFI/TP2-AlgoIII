package modelo.jugadores;


import modelo.tablero.Casillero;
import modelo.tablero.Mapa;

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
            this.jugador.setEstado(new InHabilitado(this.jugador));
        }

        return casilleroAMover;
    }
}
