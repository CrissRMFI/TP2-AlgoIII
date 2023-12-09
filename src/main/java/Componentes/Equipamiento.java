package Componentes;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class Equipamiento extends HBox {
    public Equipamiento () {
        Image imagen = new Image("file:src/main/java/Imagenes/equipamiento.png");

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
