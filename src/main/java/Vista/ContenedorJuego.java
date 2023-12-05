package Vista;

import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Errores.DatoNoValido;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;
import Vista.BotonHandlers.BotonTirarDadoHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.LinkedList;

public class ContenedorJuego extends BorderPane {
    private Stage stage;
    private Scene escena;
    private Insets INSETS = new Insets(10, 10, 10, 10);
    private AlgoRoma juego;
    private ArrayList<Jugador> jugadores;
    private LinkedList<Casillero> camino;
    private InformacionMapaEnJSON informacion;
    private Mapa mapa;
    private GridPane mapaVisual;
    private Jugador jugadorActual;



    public ContenedorJuego(Stage stage, AlgoRoma juego, ArrayList<Jugador> jugadores, InformacionMapaEnJSON informacion) throws CantidadMinimaDeJugadores, DatoNoValido {
        this.stage = stage;
        this.juego = juego;
        this.informacion = informacion;
        this.jugadores = jugadores;
        this.camino = new LinkedList<>();

        //
        //this.camino.get(0).

        this.ponerImagenDeFondo();

        generarInterfaz();
    }

    private void generarInterfaz() throws CantidadMinimaDeJugadores, DatoNoValido {
        mapaVisual = new GridPane();

        this.armarMapa();
        this.informacion.construirCamino(this.camino);
        this.agregarCamino();

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
        for (int i = 0; i < this.informacion.conseguirLargo(); i++) {
            for (int j = 0; j < this.informacion.conseguirAncho(); j++) {
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

    private void ponerImagenDeFondo(){
        Image imagen = new Image("file:src/main/java/Vista/Imagenes/roma3.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }

    private void agregarCamino(){
        for (int i = 0; i < this.camino.size(); i++){
            Rectangle casillero = new Rectangle(50, 50);
            casillero.setFill(Color.DARKRED);
            int x = this.camino.get(i).getX();
            int y = this.camino.get(i).getY();
            this.mapaVisual.add(new StackPane(casillero), x, y);
        }
    }
}