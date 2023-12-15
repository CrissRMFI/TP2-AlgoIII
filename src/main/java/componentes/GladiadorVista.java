package componentes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GladiadorVista extends JugadorVista {
    public GladiadorVista(entidades.jugadores.Jugador jugador, int numeroJugador) {
        this.jugador = jugador;

        Image imagen = new Image("file:src/main/resources/imagenes/gladiadores/gladiador" + numeroJugador + ".png");

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
