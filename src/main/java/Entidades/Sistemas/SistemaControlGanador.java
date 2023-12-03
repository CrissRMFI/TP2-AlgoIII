package Entidades.Sistemas;

import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;


public class SistemaControlGanador {
    private Mapa mapa;
    public SistemaControlGanador (Mapa mapa) {
        this.mapa = mapa;
    }
    public boolean gano (Jugador jugador) {

        boolean cumplePosicion = jugador.estoyEnLaMeta();

        boolean cumpleEquipo = jugador.esEquipoMaximo();

        if (cumplePosicion && !cumpleEquipo) mapa.ubicarEnMitadDelCamino(jugador);

        return cumpleEquipo && cumplePosicion;
    }
}
