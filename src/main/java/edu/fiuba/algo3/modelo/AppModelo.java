package edu.fiuba.algo3.modelo;

import Componentes.ModeloJugador;
import Componentes.ModeloMapa;
import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

import java.util.LinkedList;
import java.util.Objects;

public class AppModelo {
    private LinkedList<ModeloJugador> jugadores;
    private Mapa mapa;
    private AlgoRoma algoRoma;
    private String ruta;

    public AppModelo () {
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador(ModeloJugador jugador) {
        this.jugadores.add(jugador);
    }

    public void crearMapa (String ruta) throws DatoNoEncontrado, DatoNoValido, ArchivoNoEncontrado {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);
        this.ruta = ruta;
    }

    public void crearJuego () throws CantidadMinimaDeJugadores {
        this.algoRoma = new AlgoRoma(this.mapa);
        for (ModeloJugador jugador : this.jugadores) {
            this.algoRoma.agregarJugador(jugador.getJugador());
        }
    }

    public LinkedList<Casillero> getCasilleros () {
        return algoRoma.getCasilleros();
    }

    public String getRutaArchivo () {
        return this.ruta;
    }

    public void ubicarJugadoresEnElMapa (ModeloMapa mapa) {
        for (ModeloJugador jugador : this.jugadores) {
            mapa.agregarJugador(jugador);
        }
    }

    public void moverJugador (ModeloMapa mapa) throws CantidadMinimaDeJugadores, PartidaFinalizada, JuegoTerminadoHayUnGanador {
        try{
            Jugador jugador = this.algoRoma.jugarTurno();
        } catch (JuegoTerminadoHayUnGanador a){
            throw new JuegoTerminadoHayUnGanador();
        } finally {
            ModeloJugador jugadorRemovido = null;
            for (ModeloJugador jugadore : this.jugadores) { // TODO: cambiar nombre de variable
                if (Objects.equals(algoRoma.getJugadorActual().yoSoy(), jugadore.getJugador().yoSoy())) {
                    mapa.moverJugador(jugadore);
                    jugadorRemovido = jugadore;
                    break;
                }
            }
            Casillero casillero = algoRoma.getJugadorActual().miPosicion();
            for (int i=0; i<mapa.getCamino().size();i++) {
                if (mapa.getCamino().get(i).comparar(casillero)) {
                    jugadorRemovido.setCasillero(mapa.getCamino().get(i));
                    break;
                }
            }
        }
    }

    public Jugador devolverJugadorActual(){
        return this.algoRoma.getJugadorActual();
    }


}
