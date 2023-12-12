package Componentes;


import Entidades.Jugadores.Jugador;
import Vista.DescripcionGladiadorVista;
import javafx.animation.FadeTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.util.Stack;

public class ContenedorJugadorGano extends BorderPane {
    Jugador jugador;
    DescripcionGladiadorVista descripcion;
    public ContenedorJugadorGano(Jugador jugador) {
        this.jugador = jugador;
        //this.ponerImagenDeFondo();
        this.descripcion =  new DescripcionGladiadorVista(jugador);

        /*
        this.vBox.setSpacing(20);
        this.vBox.setPadding(new Insets(10, 20, 10, 20));

        Label mensaje = new Label("JUEGO TERMINADO");
        Label mensaje2 = new Label("TENEMOS UN GANADOR");
        Label mensaje3 = new Label(jugador.miDescripcion());

        this.vBox.getChildren().addAll(mensaje, mensaje2, mensaje3);

         */

        this.setCenter(this.descripcion);
    }

    /*
    private void ponerImagenDeFondo(){
        Image imagen = new Image("file:src/main/java/Vista/Imagenes/fondoGanador.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }

     */

    public Scene obtenerScena(){
        this.setOpacity(0);
        FadeTransition fading = new FadeTransition(Duration.seconds(4), this);
        fading.setFromValue(0);
        fading.setToValue(1);
        fading.play();
        return new Scene(this);
    }
}
