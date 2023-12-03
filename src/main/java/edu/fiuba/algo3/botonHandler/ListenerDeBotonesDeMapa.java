package edu.fiuba.algo3.botonHandler;

import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Tablero.Mapa;
import Datos.InformacionMapaEnJSON;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class ListenerDeBotonesDeMapa implements ChangeListener<Toggle> {
    ToggleGroup grupoDeMapas;
    InformacionMapaEnJSON informacion;

    public ListenerDeBotonesDeMapa(ToggleGroup grupoDeMapas, Mapa mapaActual){
        this.grupoDeMapas = grupoDeMapas;
    }
    @Override
    public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
        RadioButton botonElegido = (RadioButton) this.grupoDeMapas.getSelectedToggle();
        String nombreDeMapaElegido = botonElegido.getText();
        try {
            System.out.print("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            informacion = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            Mapa mapa = new Mapa(informacion);
            mapa.contruirMapa();
        } catch (ArchivoNoEncontrado | DatoNoEncontrado | DatoNoValido e) {
            throw new RuntimeException(e);
        }
    }
}
