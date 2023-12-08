package Componentes;

import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroCamino extends Rectangle {
    public CasilleroCamino () {
        this.setWidth(60);
        this.setHeight(60);
        this.setFill(Color.BEIGE);

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
    }
}
