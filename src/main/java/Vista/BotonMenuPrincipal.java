package Vista;

import javafx.scene.Cursor;
import javafx.scene.control.Button;

public class BotonMenuPrincipal extends Button {

    public BotonMenuPrincipal(String texto) {
        super(texto);
        this.setMinSize(150, 50);
        this.setMaxSize(250, 50);
        this.setStyle("-fx-background-color: #66A7C5; -fx-font-size: 2em; -fx-text-fill: #FFFFFF");
        this.setCursor(Cursor.HAND);
    }
}
