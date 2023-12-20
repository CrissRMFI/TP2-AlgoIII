package componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;

public class ContenedorIngresoNombres extends GridPane {

    private int cantidadMaximaDeJugadores;
    private LinkedList<TextField> textFields = new LinkedList<>();

    public ContenedorIngresoNombres() {

        this.cantidadMaximaDeJugadores = 6;

        this.setPadding(new Insets(10, 0, 0, 10));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        for (int i = 0; i < cantidadMaximaDeJugadores; i++) {
            TextField input = new InputNombre();
            textFields.add(input);
            this.addRow(i, input);
        }
    }

    public LinkedList<TextField> conseguirTextFields(){
        return this.textFields;
    }
}
