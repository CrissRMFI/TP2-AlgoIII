package Componentes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Fiera extends HBox {
    public Fiera () {
        Image imagen = new Image("file:src/main/java/Imagenes/fiera.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setMinWidth(25);
        this.setMinHeight(25);
        this.setBackground(new Background(imagenDeFondo));
    }
}
