package edu.fiuba.algo3.modelo;

import componentes.*;
import datos.InformacionMapa;
import datos.InformacionMapaEnJSON;
import entidades.AlgoRoma;
import entidades.errores.*;
import entidades.jugadores.Jugador;
import entidades.tablero.Casillero;
import entidades.tablero.Mapa;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.LinkedList;

public class AppModelo {
    private LinkedList<JugadorVista> jugadores = new LinkedList<>();
    private Mapa mapa;
    private AlgoRoma algoRoma;
    private String ruta;

    private Media media;
    private MediaPlayer mediaPlayer;


    public MapaVista crearMapaInterface(String ruta) throws ArchivoNoEncontrado {
        return new MapaVista(ruta, this);
    }

    public void crearJuego(String ruta) throws DatoNoEncontrado, DatoNoValido, ArchivoNoEncontrado, CantidadMinimaDeJugadores {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);
        this.ruta = ruta;
        this.algoRoma = new AlgoRoma(mapa);

        // TODO: arreglar estooo
        for (JugadorVista jugadorVista : this.jugadores) {
            this.algoRoma.agregarJugador(jugadorVista.getJugador());
        }

        this.algoRoma.comenzarPartida();
    }


    public void agregarJugador(JugadorVista jugadorVista) {
        //if (this.algoRoma != null) {
        this.jugadores.add(jugadorVista);
        //this.algoRoma.agregarJugador(jugador.getJugador());
        // } else {
        //     this.jugadores.clear();
        //}
    }

    public LinkedList<Casillero> getCasilleros() {
        return algoRoma.getCasilleros();
    }

    public void ubicarJugadoresEnElMapa(MapaVista mapaVista) {
        for (JugadorVista jugadorVista : this.jugadores) {
            mapaVista.agregarJugador(jugadorVista);
        }
    }

    public void moverJugador(MapaVista mapaVista) throws PartidaFinalizada, PartidaNoFinalizada {
        try {
            String rutaSonido = "src/main/resources/sonidos/moverJugador.mp3";
            this.media = new Media(new File(rutaSonido).toURI().toString());
            this.mediaPlayer = new MediaPlayer(media);
            this.mediaPlayer.play();
            Jugador jugador = this.algoRoma.jugarTurno();
            JugadorVista jugadorVistaRemovido = null;
            for (JugadorVista iJugadorVista : this.jugadores) {
                if (jugador.equals(iJugadorVista.getJugador())) {
                    mapaVista.moverJugador(iJugadorVista);
                    jugadorVistaRemovido = iJugadorVista;
                    break;
                }
            }

            Casillero casillero = jugador.miPosicion();

            for (CasilleroCamino casilleroCamino : mapaVista.getCamino()) {
                if (casilleroCamino.comparar(casillero)) {
                    jugadorVistaRemovido.setCasillero(casilleroCamino);
                    break;
                }
            }
        } catch (PartidaFinalizada err) {
            this.mediaPlayer.stop();
            VentanaPartidaFinalizada v = new VentanaPartidaFinalizada(Alert.AlertType.INFORMATION);
            v.setContentText("PARTIDA FINALIZADA: " + this.algoRoma.elGanador().yoSoy());
            v.show();
            String rutaSonido = "src/main/resources/sonidos/ganador.mp3";
            this.media = new Media(new File(rutaSonido).toURI().toString());
            this.mediaPlayer = new MediaPlayer(media);
            this.mediaPlayer.play();
        }

    }

    public void cargarEstadisticas(PanelEstadisticasJugadores panelEstadisticasJugadores) {
        VBox vBox = new VBox();

        Label estadisticas = new Label("ESTADISTICAS");
        estadisticas.setStyle("-fx-text-fill: white; -fx-font-size: 24;");
        vBox.getChildren().add(estadisticas);

        for (JugadorVista jugadorVista : this.jugadores) {
            HBox hBox = new HBox();
            Label descripcion = new Label(jugadorVista.getJugador().miDescripcion());
            descripcion.setStyle("-fx-text-fill: white; -fx-font-size: 20;");


            hBox.getChildren().add(descripcion);

            hBox.setPadding(new Insets(0, 50, 0, 0));


            vBox.getChildren().add(hBox);
        }

        panelEstadisticasJugadores.getChildren().add(vBox);

    }

    public void clearJugadores() {
        this.jugadores.clear();
    }
}
