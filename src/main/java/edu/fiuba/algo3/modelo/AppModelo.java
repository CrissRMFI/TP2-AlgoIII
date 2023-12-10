package edu.fiuba.algo3.modelo;

import Componentes.Jugador;
import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Tablero.Mapa;

import java.util.LinkedList;

public class AppModelo {
    private LinkedList<Componentes.Jugador> jugadores;
    private Mapa mapa;

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

    public String getRutaArchivo () {
        return this.ruta;
    }

    public void ubicarJugadoresEnElMapa (Componentes.Mapa mapa) {
        for (Jugador jugador : this.jugadores) {
            mapa.agregarJugador(jugador);
        }
    }

    public void moverJugador () {
        
    }
}
