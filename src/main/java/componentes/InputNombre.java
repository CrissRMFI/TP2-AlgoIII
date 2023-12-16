package componentes;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;

public class InputNombre extends TextField {
    public InputNombre() {
        this.setPrefWidth(300);
        this.setPrefHeight(30);
        this.setStyle("-fx-background-color: lightgrey; -fx-text-fill: darkblue;");
        this.setPromptText("Ingrese nombre del jugador");
        this.setPadding(new Insets(10, 0, 10, 0));
    }
}
