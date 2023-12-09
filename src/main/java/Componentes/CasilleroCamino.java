package Componentes;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroCamino extends GridPane {

    public CasilleroCamino() {

        this.setMinWidth(68);
        this.setMinHeight(68);
        this.setStyle("-fx-background-color: beige;-fx-border-color: black; -fx-border-width: 2;");

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
    }


}
