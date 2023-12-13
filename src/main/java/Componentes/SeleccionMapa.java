package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SeleccionMapa extends HBox {
    private ToggleGroup toggleGroup = new ToggleGroup();
    private String rutaMapa;

    public SeleccionMapa()  {
        this.setSpacing(15);

        RadioButton radioButton1 = this.crearRadioButton("Mapa Catedra","src/main/java/Datos/mapaDeLaCatedra.json");
        RadioButton radioButton2 = this.crearRadioButton("Mapa Facil","src/main/java/Datos/mapaDeEjemplo.json");
        RadioButton radioButton3 = this.crearRadioButton("Mapa Medio","src/main/java/Datos/mapaDeEjemplo2.json");
        RadioButton radioButton4 = this.crearRadioButton("Mapa Dificil","src/main/java/Datos/mapaDeLaCatedra.json");

        this.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4);
    }

    private RadioButton crearRadioButton(String texto, String ruta) {
        RadioButton radioButton = new RadioButton(texto);
        establecerEstiloRadioButton(radioButton);
        radioButton.setToggleGroup(toggleGroup);

        radioButton.setOnAction(e -> this.rutaMapa = ruta);

        return radioButton;
    }

    private void establecerEstiloRadioButton(RadioButton radioButton) {
        radioButton.setStyle("-fx-alignment: center;" + "-fx-text-fill: white;" + "-fx-alignment: center;");
        radioButton.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    }

    public String obtenerRutaMapa () {
        return this.rutaMapa;
    }
}
