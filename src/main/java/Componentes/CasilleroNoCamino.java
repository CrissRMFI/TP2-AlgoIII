package Componentes;

import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroNoCamino extends Rectangle {
    public CasilleroNoCamino() {
        this.setWidth(70);
        this.setHeight(70);
        this.setFill(Color.BROWN);

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
    }
}
