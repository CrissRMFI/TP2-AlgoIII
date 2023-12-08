package Componentes;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
public class BotonIngresar extends Button {

    public BotonIngresar(String texto) {
        super(texto);

        this.setId("Ingresar");

        DropShadow shadow = new DropShadow();
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> this.setEffect(shadow));
        this.addEventHandler(MouseEvent.MOUSE_EXITED, e -> this.setEffect(null));


        this.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> this.setTranslateZ(2));
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> this.setTranslateZ(0));


        this.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
    }
}
