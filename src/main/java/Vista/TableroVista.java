package Vista;

import Datos.MensajesUsuario;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Map;

public class TableroVista {

    private final MensajesUsuario m = new MensajesUsuario();
    private final GridPane grid = new GridPane();
    private final TableroVistaModelo vistaModelo = new TableroVistaModelo();
    private void enlazarVistaModelo () {}

    private void construirCasilleros (Map<Posicion, Entidades.Tablero.Casillero> casilleros) {

        Iterator<Posicion> iteradorPosicion = casilleros.keySet().iterator();
        Iterator<Entidades.Tablero.Casillero> iteradorCasillero = casilleros.values().iterator();

        while (iteradorPosicion.hasNext() && iteradorCasillero.hasNext()) {
            Posicion posicion = iteradorPosicion.next();
            Entidades.Tablero.Casillero casillero = iteradorCasillero.next();

            int x = posicion.posicionLineal();
            int y = posicion.posicionVertical();

            this.grid.add(casillero.construirVistaCasillero(),x,y);
        }
    }

    public GridPane construirTablero(Map<Posicion, Casillero> casilleros) {

        this.grid.setStyle("-fx-background-color: #000000;");
        this.grid.setAlignment(Pos.TOP_CENTER);
        this.grid.setPrefWidth(-1);
        this.grid.setPrefHeight(-1);

        this.construirCasilleros(casilleros);


        this.grid.setVgap(20);
        this.grid.setHgap(20);
        this.grid.setScaleY(-1);

        this.enlazarVistaModelo();

        return this.grid;
    }
}
