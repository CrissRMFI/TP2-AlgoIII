package Componentes;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class BotonIniciarJuego extends Button {
    public BotonIniciarJuego(String texto) {
        super(texto);

        this.setId("Iniciar");

        DropShadow shadow = new DropShadow();
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> this.setEffect(shadow));
        this.addEventHandler(MouseEvent.MOUSE_EXITED, e -> this.setEffect(null));


        this.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> this.setTranslateZ(2));
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> this.setTranslateZ(0));


        this.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        this.setPrefWidth(300);
        this.setPrefHeight(30);
    }

}
