package edu.fiuba.algo3.modelo;

import Entidades.AlgoRoma;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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



    public EscenaDeJuego(Stage stage, AlgoRoma juego, ArrayList<Jugador> jugadores, Tablero tablero) {
        this.stage = stage;
        this.juego = juego;
        this.tablero = tablero;

        generarInterfaz();
    }

    private void generarInterfaz() {
        borderPane = new BorderPane();
        tableroVisual = new GridPane();

        this.armarTablero();

        //Button top = createButton("Top");
        Button left = createButton("Left");
        //Button center = createButton("Center");
        Button right = createButton("Right");
        Button bottom = createButton("Bottom");

        //tableroVisual.setMaxHeight(Double.MAX_VALUE);
        //tableroVisual.setMaxWidth(Double.MAX_VALUE);
        //BorderPane.setMargin(tableroVisual, INSETS);
        //BorderPane.setAlignment(tableroVisual, Pos.CENTER);
        this.tableroVisual.setAlignment(Pos.CENTER);

        //borderPane.setTop(top);
        borderPane.setLeft(left);
        borderPane.setCenter(this.tableroVisual);
        borderPane.setRight(right);
        borderPane.setBottom(bottom);

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
}