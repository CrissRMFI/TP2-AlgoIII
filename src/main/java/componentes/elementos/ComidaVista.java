package componentes.elementos;

import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class ComidaVista extends HBox {

    public ComidaVista() {

        Image imagen = new Image("file:src/main/resources/imagenes/elementos/comida.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100.0, 100.0, true, true, true, true));

        this.setMinWidth(30);
        this.setMinHeight(30);
        this.setBackground(new Background(imagenDeFondo));
    }
}
