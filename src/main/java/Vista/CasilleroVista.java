package Vista;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CasilleroVista extends HBox {
    public CasilleroVista crearCasillero() {

        Rectangle cuadradoContenedor = new Rectangle(40, 40);
        cuadradoContenedor.setFill(Color.BLANCHEDALMOND);

        this.getChildren().addAll(cuadradoContenedor);
        this.setStyle("-fx-margin: 50; -fx-border-color: #D2B48C; -fx-border-width: 10; -fx-border-radius: 50");

        return this;
    }

    public CasilleroVista crearCasilleroFinal () {
        Rectangle cuadradoContenedor = new Rectangle(40, 40);
        cuadradoContenedor.setFill(Color.BLUE);

        this.getChildren().addAll(cuadradoContenedor);
        this.setStyle("-fx-margin: 50; -fx-border-color: blue; -fx-border-radius: 0;-fx-border-width: 10;");

        return this;
    }

    public CasilleroVista crearCasilleroInicial () {
        Rectangle cuadradoContenedor = new Rectangle(40, 40);
        cuadradoContenedor.setFill(Color.DARKGREEN);

        this.getChildren().addAll(cuadradoContenedor);
        this.setStyle("-fx-margin: 50; -fx-border-color: green; -fx-border-radius: 0;-fx-border-width: 10;");

        return this;
    }
}
