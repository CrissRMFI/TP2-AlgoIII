package Componentes;

import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PanelControl extends GridPane {
    public PanelControl (AppModelo modelo, ModeloMapa mapa, Stage stage) {
        BotonLanzar botonLanzar = new BotonLanzar("LANZAR",modelo,mapa, stage);
        this.add(botonLanzar,0,2);
    }
}
