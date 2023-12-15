package componentes.elementos;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class BacanalVista extends HBox {
    public BacanalVista() {
        Image imagen = new Image("file:src/main/resources/imagenes/elementos/bacanal.png");

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
