package Componentes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Comida extends HBox  {

    public Comida() {

        Image imagen = new Image("file:src/main/java/Imagenes/comida.png");


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
