package vista;

import datos.InformacionMapaEnJSON;
import modelo.AlgoRoma;
import modelo.errores.CantidadMinimaDeJugadores;
import modelo.errores.DatoNoValido;
import modelo.jugadores.Jugador;
import modelo.tablero.Casillero;
import modelo.tablero.Mapa;
import controlador.BotonHandlers.BotonTirarDadoHandler;
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
    private Insets margenes = new Insets(10, 10, 10, 10);
    private AlgoRoma juego;
    private ArrayList<Jugador> jugadores;
    private LinkedList<Casillero> camino;
    private InformacionMapaEnJSON informacion;
    private GridPane mapaVisual;
    private Jugador jugadorActual;


    public ContenedorJuego(Stage stage, AlgoRoma juego, ArrayList<Jugador> jugadores, InformacionMapaEnJSON informacion) throws CantidadMinimaDeJugadores, DatoNoValido {
        this.stage = stage;
        this.juego = juego;
        this.informacion = informacion;
        this.jugadores = jugadores;
        this.camino = new LinkedList<>();
        this.ponerImagenDeFondo();

        generarInterfaz();
    }

    private void generarInterfaz() throws CantidadMinimaDeJugadores, DatoNoValido {
        mapaVisual = new GridPane();

        this.armarMapa();
        this.informacion.construirCamino(this.camino);
        this.agregarCamino();

        this.jugadorActual = this.juego.comenzarPartidaConElPrimerJugador();

        DescripcionGladiadorVista des = new DescripcionGladiadorVista();

        VBox descripcion = des.descripcion(this.jugadorActual);

        Button left = crearBoton("Left");

        Button tirarDado = crearBoton("Tirar dado");
        Button moverse = crearBoton("Moverse");
        Button finalizarTurno = crearBoton("Finalizar Turno");

        Mapa mapa = new Mapa(this.informacion);
        BotonTirarDadoHandler botonTirarDadoHandler = new BotonTirarDadoHandler(this.jugadorActual, this.juego, mapa);
        tirarDado.setOnAction(botonTirarDadoHandler);


        this.mapaVisual.setAlignment(Pos.CENTER);

        this.setLeft(left);
        this.setCenter(this.mapaVisual);
        this.setRight(descripcion);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(tirarDado, moverse, finalizarTurno);
        BorderPane.setMargin(hbox, margenes);
        this.setBottom(hbox);


    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);
        boton.setMaxWidth(Double.MAX_VALUE);
        boton.setMaxHeight(Double.MAX_VALUE);
        boton.setMinWidth(170);
        boton.setMinHeight(100);
        BorderPane.setMargin(boton, margenes);
        BorderPane.setAlignment(boton, Pos.CENTER);
        return boton;
    }


    private void armarMapa() {
        for (int i = 0; i < this.informacion.conseguirLargo(); i++) {
            for (int j = 0; j < this.informacion.conseguirAncho(); j++) {
                Rectangle casillero = new Rectangle(50, 50);
                casillero.setFill(Color.BURLYWOOD);
                casillero.setStroke(Color.BLACK);
                this.mapaVisual.add(new StackPane(casillero), i + 1, j + 1);
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

    private void ponerImagenDeFondo() {
        Image imagen = new Image("file:src/main/resources/imagenes/roma3.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }

    private void agregarCamino() {
        for (int i = 0; i < this.camino.size(); i++) {
            Rectangle casillero = new Rectangle(50, 50);
            casillero.setFill(Color.DARKRED);
            int x = this.camino.get(i).conseguirX();
            int y = this.camino.get(i).conseguirY();
            this.mapaVisual.add(new StackPane(casillero), x, y);
        }
    }
}
