package vista;

import modelo.AlgoRoma;
import modelo.errores.CantidadMinimaDeJugadores;
import modelo.jugadores.Jugador;
import modelo.tablero.Mapa;
import controlador.botonHandlers.BotonTirarDadoHandler;
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
public class ContenedorJuego extends BorderPane {
    private Stage stage;
    private Scene escena;
    private Insets INSETS = new Insets(10, 10, 10, 10);
    private AlgoRoma juego;
    private ArrayList<Jugador> jugadores;
    private Mapa mapa;
    private GridPane mapaVisual;
    private Jugador jugadorActual;



    public ContenedorJuego(Stage stage, AlgoRoma juego, ArrayList<Jugador> jugadores, Mapa mapa) throws CantidadMinimaDeJugadores {
        this.stage = stage;
        this.juego = juego;
        this.mapa = mapa;
        this.jugadores = jugadores;

        generarInterfaz();
    }

    private void generarInterfaz() throws CantidadMinimaDeJugadores {
        mapaVisual = new GridPane();

        this.armarMapa();
        this.jugadorActual = this.juego.comenzarPartidaConElPrimerJugador();

        //Button top = createButton("Top");
        Button left = createButton("Left");
        //Button center = createButton("Center");
        Button right = createButton("Right");
        //Button bottom = createButton("Bottom");

        Button tirarDado = createButton("Tirar dado");
        BotonTirarDadoHandler botonTirarDadoHandler = new BotonTirarDadoHandler(this.jugadorActual, this.juego, this.mapa);
        tirarDado.setOnAction(botonTirarDadoHandler);

        //tableroVisual.setMaxHeight(Double.MAX_VALUE);
        //tableroVisual.setMaxWidth(Double.MAX_VALUE);
        //BorderPane.setMargin(tableroVisual, INSETS);
        //BorderPane.setAlignment(tableroVisual, Pos.CENTER);
        this.mapaVisual.setAlignment(Pos.CENTER);

        //this.ponerJugadores();

        //borderPane.setTop(top);
        this.setLeft(left);
        this.setCenter(this.mapaVisual);
        this.setRight(right);
        this.setBottom(tirarDado);

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


    private void armarMapa(){
        for (int i = 0; i < this.mapa.conseguirLargo(); i++) {
            for (int j = 0; j < this.mapa.conseguirAncho(); j++) {
                Rectangle casillero = new Rectangle(50, 50);
                casillero.setFill(Color.BURLYWOOD);
                casillero.setStroke(Color.BLACK);
                this.mapaVisual.add(new StackPane(casillero), i+1, j+1);
            }
        }
    }

    /*
    private void ponerJugadores(){
        for (int i = 0; i < this.jugadores.size(); i++){
            this.jugadores.get(i).
            Posicion posicionDeJugador = this.jugadores.get(i).miPosicion();
            Rectangle jugador = new Rectangle(10, 10);
            jugador.setFill(Color.DARKGOLDENROD);
            System.out.print(posicionDeJugador.posicionLineal());
            this.mapaVisual.add(new StackPane(jugador), posicionDeJugador.posicionLineal(), posicionDeJugador.posicionVertical());
        }
    }

     */
}
