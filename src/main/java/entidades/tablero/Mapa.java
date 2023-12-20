package entidades.tablero;

import datos.InformacionMapa;
import entidades.errores.DatoNoValido;
import entidades.jugadores.Jugador;

import java.util.LinkedList;

public class Mapa {
    private LinkedList<Casillero> camino = new LinkedList<>();

    public Mapa(InformacionMapa informacionMapa) throws DatoNoValido {
        informacionMapa.construirCamino(this.camino);
    }

    private Casillero obtenerCasillero(int posicion) {
        if (posicion >= this.camino.size()) {
            return this.camino.getLast();
        }
        return this.camino.get(posicion);
    }

    public Casillero obtenerProximoDestino(Casillero casillero, int posicionesAMover) {
        int posicion = 0;
        for (Casillero c : this.camino) {
            if (c.esIgualQue(casillero)) {
                break;
            }
            posicion++;
        }

        posicion += posicionesAMover;

        return this.obtenerCasillero(posicion);
    }


    public void ubicarEnInicio(Jugador jugador) {
        jugador.posicionar(this.camino.get(0));
    }

    public void ubicarEnMitadDelCamino(Jugador jugador) {
        int medio = this.camino.size() / 2;
        jugador.posicionar(this.camino.get(medio));
    }

    public boolean jugadorGano(Jugador jugador) {
        Casillero casilleroLlegada = this.camino.getLast();


        if (jugador.compararPosicion(casilleroLlegada)) {
            if (!jugador.esEquipoMaximo()) this.ubicarEnMitadDelCamino(jugador);
            else return true;
        }
        return false;
    }


    public LinkedList<Casillero> getCasilleros() {
        return this.camino;
    }
}