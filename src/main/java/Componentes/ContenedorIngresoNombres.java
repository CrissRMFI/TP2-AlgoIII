package Componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
import java.util.List;

public class ContenedorIngresoNombres extends GridPane {

    private int cantidadMaximaDeJugadores;

    public ContenedorIngresoNombres() {

        this.cantidadMaximaDeJugadores = 6;

        this.setPadding(new Insets(10, 0, 0, 10));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        for (int i = 0; i < cantidadMaximaDeJugadores; i++) {
            TextField input = new InputNombre();
            this.addRow(i, input);
        }
    }

    public List<String> conseguirNombres() {
        LinkedList<String> nombres = new LinkedList<>();
        for (int i = 0; i < this.cantidadMaximaDeJugadores; i++) {
            TextField input = (TextField) this.getChildren().get(i);
            if (!input.getText().isEmpty()) {
                nombres.add(input.getText());
            }
        }
        return nombres;
    }


}
