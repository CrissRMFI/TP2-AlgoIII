package Componentes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GladiadorVista extends Jugador{
    public GladiadorVista (Entidades.Jugadores.Jugador jugador, int numeroJugador) {
        this.jugador = jugador;

        Image imagen = new Image("file:src/main/java/Imagenes/gladiador" + numeroJugador + ".png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setMinWidth(30);
        this.setMinHeight(30);
        this.setBackground(new Background(imagenDeFondo));
    }
}
