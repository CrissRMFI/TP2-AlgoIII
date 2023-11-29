package Vista;

import Datos.InformacionMapa;
import Datos.MensajesUsuario;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.Posicion;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class TableroVista {

    private final MensajesUsuario m = new MensajesUsuario();
    private final GridPane grid = new GridPane();
    private final Stage stage = new Stage();

    private void enlazarVistaModelo () {}

    public void mostrarTablero () {
        this.stage.show();
    }

    public void cargarCasilleros (InformacionMapa informacionMapa) {

        this.grid.setStyle("-fx-background-color: #000000;");
        this.grid.setAlignment(Pos.TOP_CENTER);
        this.grid.setPrefWidth(-1);
        this.grid.setPrefHeight(-1);

        LinkedList<Posicion> posiciones = informacionMapa.listaDePosiciones();



        for (int i=0;i<posiciones.size();i++) {
            Casillero casillero = null;
            if (i == 0) {
                casillero = new Casillero().crearCasilleroInicial();
            } else if (i == posiciones.size() - 1) {
                casillero = new Casillero().crearCasilleroFinal();
            } else {
                casillero = new Casillero().crearCasillero();
            }


            int x = posiciones.get(i).posicionLineal();
            int y = posiciones.get(i).posicionVertical();
            this.grid.add(casillero,x,y);
        }

        this.grid.setVgap(20);
        this.grid.setHgap(20);
        this.grid.setScaleY(-1);

        this.enlazarVistaModelo();

        Scene scene = new Scene(this.grid,1600,800);




        this.stage.setTitle(m.TituloAplicacion());
        this.stage.setScene( scene );
    }
}
