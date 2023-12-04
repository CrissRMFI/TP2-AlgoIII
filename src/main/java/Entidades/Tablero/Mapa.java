package Entidades.Tablero;

import Datos.InformacionMapa;
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;
import Entidades.Errores.DatoNoValido;

import java.util.LinkedList;

public class Mapa {
    private LinkedList<Casillero> camino = new LinkedList<>();
    private int ancho;
    private int largo;

    public Mapa (InformacionMapa informacionMapa) throws DatoNoValido {
        informacionMapa.construirCamino(this.camino);
        this.ancho = informacionMapa.conseguirAncho();
        this.largo = informacionMapa.conseguirLargo();

    }
    public void moverJugador(Casillero casillero,Jugador jugador) {

        int posicion = 0;
        ValorAzar valorAzar = jugador.lanzar();

        for (int i = 0; i<this.camino.size(); i++) {
            Casillero c = this.camino.get(i);
            if (c.equals(casillero)) break;
            posicion++;
        }

        for (int i = 0; i<valorAzar.obtenerValor(); i++) {
            posicion++;
        }

        jugador.posicionar(this.obtenerCasillero(posicion));
    }

    private Casillero obtenerCasillero (int posicion) {
        if (posicion>= this.camino.size()) {
            int fin = this.camino.size()-1;
            return this.camino.get(fin);

        }
        return this.camino.get(posicion);
    }

    public void ubicarEnInicio (Jugador jugador) {
        this.camino.get(0).recibirElemento(jugador);
        jugador.posicionar(this.camino.get(0));
    }

    public void ubicarEnMitadDelCamino (Jugador jugador) {
        int medio = this.camino.size() /2;
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

    public int conseguirLargo(){
        return this.largo;
    }

    public int conseguirAncho() {
        return this.ancho;
    }
}