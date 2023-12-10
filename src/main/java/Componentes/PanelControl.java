package Componentes;

import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PanelControl extends GridPane {
    public PanelControl (AppModelo modelo) {
        BotonLanzar botonLanzar = new BotonLanzar("LANZAR",modelo);
        this.add(botonLanzar,0,2);
    }
}
