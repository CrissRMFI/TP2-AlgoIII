package edu.fiuba.algo3.modelo;

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
        Entidades.Jugadores.Jugador jugador = this.algoRoma.mover();
        Jugador jugadorRemovido = null;
        for (int i=0; i<this.jugadores.size();i++) {
            if (jugador.yoSoy() == this.jugadores.get(i).getJugador().yoSoy()) {
                mapa.moverJugador(this.jugadores.get(i));
                jugadorRemovido = this.jugadores.get(i);
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
