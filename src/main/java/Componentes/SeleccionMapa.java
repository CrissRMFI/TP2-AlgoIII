package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SeleccionMapa extends HBox {

    public SeleccionMapa(AppModelo modelo)  {
        this.setSpacing(15);
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton radioButton1 = new RadioButton("Mapa Catedra");
        RadioButton radioButton2 = new RadioButton("Mapa Facil");
        RadioButton radioButton3 = new RadioButton("Mapa 2");
        RadioButton radioButton4 = new RadioButton("Mapa 3");

        establecerEstiloRadioButton(radioButton1);
        establecerEstiloRadioButton(radioButton2);
        establecerEstiloRadioButton(radioButton3);
        establecerEstiloRadioButton(radioButton4);

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        radioButton4.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue)  -> {
            if (newValue == radioButton1) {
                try {
                    modelo.crearMapa("src/main/java/Datos/mapaDeLaCatedra.json");
                } catch (DatoNoEncontrado e) {
                    throw new RuntimeException(e);
                } catch (DatoNoValido e) {
                    throw new RuntimeException(e);
                } catch (ArchivoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            } else if (newValue == radioButton2) {
                try {
                    modelo.crearMapa("src/main/java/Datos/mapaDeEjemplo.json");
                } catch (DatoNoEncontrado e) {
                    throw new RuntimeException(e);
                } catch (DatoNoValido e) {
                    throw new RuntimeException(e);
                } catch (ArchivoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            } else if (newValue == radioButton3) {
                try {
                    modelo.crearMapa("src/main/java/Datos/mapaDeEjemplo2.json");
                } catch (DatoNoEncontrado e) {
                    throw new RuntimeException(e);
                } catch (DatoNoValido e) {
                    throw new RuntimeException(e);
                } catch (ArchivoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            } else if (newValue == radioButton4) {
                try {
                    modelo.crearMapa("src/main/java/Datos/mapaDeEjemplo3.json");
                } catch (DatoNoEncontrado e) {
                    throw new RuntimeException(e);
                } catch (DatoNoValido e) {
                    throw new RuntimeException(e);
                } catch (ArchivoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    modelo.crearMapa("src/main/java/Datos/mapaDeLaCatedra.json");
                } catch (DatoNoEncontrado e) {
                    throw new RuntimeException(e);
                } catch (DatoNoValido e) {
                    throw new RuntimeException(e);
                } catch (ArchivoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            }
        });

        this.getChildren().addAll(radioButton1, radioButton2, radioButton3, radioButton4);
    }

    private void establecerEstiloRadioButton(RadioButton radioButton) {
        radioButton.setStyle("-fx-alignment: center;" + "-fx-text-fill: white;" + "-fx-alignment: center;");
        radioButton.setFont(Font.font("Arial", FontWeight.BOLD, 12));
    }

}
