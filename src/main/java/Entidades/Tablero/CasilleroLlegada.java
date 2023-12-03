package Entidades.Tablero;

import Entidades.ElementoMapa;
import Entidades.Jugadores.Jugador;

public class CasilleroLlegada extends Casillero{

    public CasilleroLlegada (int x,int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean soyMeta() {
        return true;
    }


    public boolean hayGanador() {

        for (int i=0;i<this.elementos.size();i++) {
            ElementoMapa elementoMapa = this.elementos.get(i);
            if (elementoMapa.soyJugador()) {
                Jugador jugador = (Jugador) elementoMapa;
                return jugador.esEquipoMaximo();
            }
        }

        return false;
    }

    public Jugador JugadorNoGano () {
        for (int i=0;i<this.elementos.size();i++) {
            ElementoMapa elementoMapa = this.elementos.get(i);
            if (elementoMapa.soyJugador()) {
                return  (Jugador) elementoMapa;

            }
        }
        return null;
    }
}
