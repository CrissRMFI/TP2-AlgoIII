package Componentes;

import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PanelControl extends GridPane {
    public PanelControl (AppModelo modelo,Mapa mapa) {
        BotonLanzar botonLanzar = new BotonLanzar("LANZAR",modelo,mapa);
        this.add(botonLanzar,0,2);
    }
}
