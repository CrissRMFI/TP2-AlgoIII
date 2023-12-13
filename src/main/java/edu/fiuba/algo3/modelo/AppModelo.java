package edu.fiuba.algo3.modelo;

import Componentes.CasilleroCamino;
import Componentes.Jugador;
import Componentes.PanelEstadisticasJugadores;
import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.LinkedList;
public class AppModelo {
    private LinkedList<Componentes.Jugador> jugadores = new LinkedList<>();
    private Mapa mapa;
    private AlgoRoma algoRoma;
    private String ruta;


    public Componentes.Mapa crearMapaInterface(String ruta) throws ArchivoNoEncontrado {
        return new Componentes.Mapa(ruta,this);
    }
    public void crearJuego (String ruta) throws DatoNoEncontrado, DatoNoValido, ArchivoNoEncontrado,CantidadMinimaDeJugadores {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);
        this.ruta = ruta;
        this.algoRoma = new AlgoRoma(mapa);
        for (Jugador jugador : this.jugadores) {
            this.algoRoma.agregarJugador(jugador.getJugador());
        }
        this.algoRoma.comenzarPartida();
    }

    public void agregarJugador(Componentes.Jugador jugador) {
        this.jugadores.add(jugador);
        this.algoRoma.agregarJugador(jugador.getJugador());
    }

    public LinkedList<Casillero> getCasilleros () {
        return algoRoma.getCasilleros();
    }

    public void ubicarJugadoresEnElMapa (Componentes.Mapa mapa) {
        for (Jugador jugador : this.jugadores) {
            mapa.agregarJugador(jugador);
        }
    }

    public void moverJugador (Componentes.Mapa mapa) throws CantidadMinimaDeJugadores, PartidaFinalizada {
        Entidades.Jugadores.Jugador jugador = this.algoRoma.jugarTurno();
        Jugador jugadorRemovido = null;
        for (Jugador iJugador : this.jugadores) {
            if (jugador.equals(iJugador.getJugador())) {
                mapa.moverJugador(iJugador);
                jugadorRemovido = iJugador;
                break;
            }
        }

        Casillero casillero = jugador.miPosicion();

        for (CasilleroCamino casilleroCamino : mapa.getCamino()) {
            if (casilleroCamino.comparar(casillero)) {
                jugadorRemovido.setCasillero(casilleroCamino);
                break;
            }
        }
    }

    public void cargarEstadisticas (PanelEstadisticasJugadores panelEstadisticasJugadores) {
        VBox vBox = new VBox();

        Label estadisticas = new Label("ESTADISTICAS");
        estadisticas.setStyle("-fx-text-fill: white; -fx-font-size: 24;");
        vBox.getChildren().add(estadisticas);

        for (Jugador jugador : this.jugadores) {
            HBox hBox = new HBox();
            Label descripcion = new Label(jugador.getJugador().miDescripcion());
            descripcion.setStyle("-fx-text-fill: white; -fx-font-size: 20;");


            hBox.getChildren().add(descripcion);

            hBox.setPadding(new Insets(0,50,0,0));


            vBox.getChildren().add(hBox);
        }

        panelEstadisticasJugadores.getChildren().add(vBox);

    }
}
