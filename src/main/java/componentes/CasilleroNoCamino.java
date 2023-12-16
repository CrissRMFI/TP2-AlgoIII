package componentes;

import javafx.scene.effect.Lighting;
import javafx.scene.layout.GridPane;


public class CasilleroNoCamino extends GridPane {
    public CasilleroNoCamino(int tamanio) {
        this.setMinSize(tamanio, tamanio);
        this.setPrefSize(tamanio, tamanio);
        this.setMaxSize(tamanio, tamanio);

        this.setStyle("-fx-background-color: brown;-fx-border-color: black; -fx-border-width: 2;");

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
    }
}
