package Componentes;

import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroNoCamino extends GridPane {
    public CasilleroNoCamino() {
        this.setMinWidth(70);
        this.setMinHeight(70);
        this.setStyle("-fx-background-color: brown;-fx-border-color: black; -fx-border-width: 2;");


        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
    }
}
