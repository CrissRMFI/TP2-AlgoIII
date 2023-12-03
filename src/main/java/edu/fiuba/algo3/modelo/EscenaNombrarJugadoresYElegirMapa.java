package edu.fiuba.algo3.modelo;

import Datos.MensajesUsuario;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Mapa;
import edu.fiuba.algo3.botonHandler.BotonIniciarJuegoEventHandler;
import edu.fiuba.algo3.botonHandler.ListenerDeBotonesDeMapa;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaNombrarJugadoresYElegirMapa {
    private MensajesUsuario mensajes = new MensajesUsuario();
    private Stage stage;
    private HBox hbox;
    private GridPane gridPaneNombres;
    private GridPane gridPaneMapas;
    private ToggleGroup grupoDeMapas;

    private Scene escena;

    public EscenaNombrarJugadoresYElegirMapa(Stage stage){
        this.stage = stage;
        this.gridPaneNombres = new GridPane();
        this.gridPaneMapas = new GridPane();
        this.grupoDeMapas = new ToggleGroup();

        this.agregarParaPonerNombres();

        this.agregarParaElegirMapa();

        this.agregarBotonIniciarJuego();

        this.hbox = new HBox(10, this.gridPaneNombres, this.gridPaneMapas);

        this.escena = new Scene(this.hbox, 600, 400);
    }

    private void agregarParaPonerNombres(){
        Label titulo = new Label(this.mensajes.IngresoDeJugadores());
        this.gridPaneNombres.add(titulo, 0, 1);
        for (int i = 0; i < 6; i++){
            this.gridPaneNombres.add(new Label("Jugador " + (i+1)), 0, i+2);
            this.gridPaneNombres.add(new TextField(), 1, i+2);
        }

        this.gridPaneNombres.setHgap(20);
        this.gridPaneNombres.setVgap(10);
        this.gridPaneNombres.setPadding(new Insets(10, 10, 10, 10));
    }

    private void agregarParaElegirMapa(){
        Label titulo = new Label(this.mensajes.eleccionDeMapas());
        this.gridPaneMapas.add(titulo, 0, 1);

        RadioButton mapa1 = new RadioButton("mapa");
        RadioButton mapa2 = new RadioButton("mapaEjemplo");

        mapa1.setToggleGroup(this.grupoDeMapas);
        mapa2.setToggleGroup(this.grupoDeMapas);

        /*
        ListenerDeBotonesDeMapa listener = new ListenerDeBotonesDeMapa(this.grupoDeMapas, this.mapaElegido);
        this.grupoDeMapas.selectedToggleProperty().addListener(listener);
         */

        this.gridPaneMapas.add(mapa1, 0, 2);
        this.gridPaneMapas.add(mapa2, 0, 3);

        this.gridPaneMapas.setHgap(20);
        this.gridPaneMapas.setVgap(10);
        this.gridPaneMapas.setPadding(new Insets(10, 10, 10, 10));
    }

    private void agregarBotonIniciarJuego(){
        Button boton = new Button(mensajes.IniciarJuego());
        BotonIniciarJuegoEventHandler botonEventHandler = new BotonIniciarJuegoEventHandler(this.stage, this.gridPaneNombres, this.grupoDeMapas);
        boton.setOnAction(botonEventHandler);

        this.gridPaneNombres.add(boton, 1, 10);
    }

    public Scene devolverEscena(){
        return this.escena;
    }
}
