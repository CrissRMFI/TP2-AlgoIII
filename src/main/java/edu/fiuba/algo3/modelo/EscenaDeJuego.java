package edu.fiuba.algo3.modelo;

import Entidades.AlgoRoma;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;
import edu.fiuba.algo3.botonHandler.BotonTirarDadoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EscenaDeJuego {
    private Stage stage;
    private BorderPane borderPane;
    private Scene escena;
    private Insets INSETS = new Insets(10, 10, 10, 10);
    private AlgoRoma juego;
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private GridPane tableroVisual;
    private Jugador jugadorActual;



    public EscenaDeJuego(Stage stage, AlgoRoma juego, ArrayList<Jugador> jugadores, Tablero tablero) throws CantidadMinimaDeJugadores {
        this.stage = stage;
        this.juego = juego;
        this.tablero = tablero;
        this.jugadores = jugadores;

        generarInterfaz();
    }

    private void generarInterfaz() throws CantidadMinimaDeJugadores {
        borderPane = new BorderPane();
        tableroVisual = new GridPane();

        this.armarTablero();
        this.jugadorActual = this.juego.comenzarPartidaConElPrimerJugador();

        //Button top = createButton("Top");
        Button left = createButton("Left");
        //Button center = createButton("Center");
        Button right = createButton("Right");
        //Button bottom = createButton("Bottom");

        Button tirarDado = createButton("Tirar dado");
        BotonTirarDadoHandler botonTirarDadoHandler = new BotonTirarDadoHandler(this.jugadorActual, this.juego, this.tablero);
        tirarDado.setOnAction(botonTirarDadoHandler);

        //tableroVisual.setMaxHeight(Double.MAX_VALUE);
        //tableroVisual.setMaxWidth(Double.MAX_VALUE);
        //BorderPane.setMargin(tableroVisual, INSETS);
        //BorderPane.setAlignment(tableroVisual, Pos.CENTER);
        this.tableroVisual.setAlignment(Pos.CENTER);

        this.ponerJugadores();

        //borderPane.setTop(top);
        borderPane.setLeft(left);
        borderPane.setCenter(this.tableroVisual);
        borderPane.setRight(right);
        borderPane.setBottom(tirarDado);



        escena = new Scene(borderPane);
        this.stage.setScene(escena);
        this.stage.show();
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(Double.MAX_VALUE);
        button.setMinWidth(170);
        button.setMinHeight(100);
        BorderPane.setMargin(button, INSETS);
        BorderPane.setAlignment(button, Pos.CENTER);
        return button;
    }

    public Scene devolverEscena(){
        return this.escena;
    }

    private void armarTablero(){
        for (int i = 0; i < this.tablero.conseguirLargo(); i++) {
            for (int j = 0; j < this.tablero.conseguirAncho(); j++) {
                Rectangle casillero = new Rectangle(50, 50);
                if (this.tablero.obtenerCasillero(new Posicion(i+1, j+1)) == null){
                    casillero.setFill(Color.RED);
                }
                else{
                    casillero.setFill(Color.BURLYWOOD);
                }
                casillero.setStroke(Color.BLACK);
                this.tableroVisual.add(new StackPane(casillero), i+1, j+1);
            }
        }
    }

    private void ponerJugadores(){
        for (int i = 0; i < this.jugadores.size(); i++){
            Posicion posicionDeJugador = this.jugadores.get(i).miPosicion();
            Rectangle jugador = new Rectangle(10, 10);
            jugador.setFill(Color.DARKGOLDENROD);
            System.out.print(posicionDeJugador.posicionLineal());
            this.tableroVisual.add(new StackPane(jugador), posicionDeJugador.posicionLineal(), posicionDeJugador.posicionVertical());
        }
    }
}