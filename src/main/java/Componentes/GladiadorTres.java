package Componentes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GladiadorTres extends HBox implements Jugador {
    private Entidades.Jugadores.Jugador jugador;
    public GladiadorTres (Entidades.Jugadores.Jugador jugador) {
        this.jugador = jugador;
        Image imagen = new Image("file:src/main/java/Imagenes/gladiador3.png");

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
