package edu.fiuba.algo3.modelo;

import Componentes.Jugador;
import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

import java.util.LinkedList;
import java.util.Objects;

public class AppModelo {
    private LinkedList<Componentes.Jugador> jugadores;
    private Mapa mapa;
    private AlgoRoma algoRoma;

    private String ruta;

    public AppModelo () {
        this.jugadores = new LinkedList<>();
    }
    public void agregarJugador(Componentes.Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public void crearMapa (String ruta) throws DatoNoEncontrado, DatoNoValido, ArchivoNoEncontrado {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);
        this.ruta = ruta;
    }

    public void crearJuego () {
        this.algoRoma = new AlgoRoma(this.mapa);
        for (Jugador jugador : this.jugadores) {
            this.algoRoma.agregarJugador(jugador.getJugador());
        }

    }

    public LinkedList<Casillero> getCasilleros () {
        return algoRoma.getCasilleros();
    }

    public String getRutaArchivo () {
        return this.ruta;
    }

    public void ubicarJugadoresEnElMapa (Componentes.Mapa mapa) {
        for (Jugador jugador : this.jugadores) {
            mapa.agregarJugador(jugador);
        }
    }

    public void moverJugador (Componentes.Mapa mapa) throws CantidadMinimaDeJugadores, PartidaFinalizada {
        Entidades.Jugadores.Jugador jugador = this.algoRoma.jugarTurno();
        Jugador jugadorRemovido = null;
        for (Jugador jugadore : this.jugadores) { // TODO: cambiar nombre de variable
            if (Objects.equals(jugador.yoSoy(), jugadore.getJugador().yoSoy())) {
                mapa.moverJugador(jugadore);
                jugadorRemovido = jugadore;
                break;
            }
        }

        Casillero casillero = jugador.miPosicion();

        for (int i=0; i<mapa.getCamino().size();i++) {

            if (mapa.getCamino().get(i).comparar(casillero)) {
                jugadorRemovido.setCasillero(mapa.getCamino().get(i));
                break;
            }
        }
    }
}
