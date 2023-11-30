package Vista;

import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelDeControlVista {
    private GridPane grid;
    private VBox columna1;
    private VBox columna2;
    private VBox columna3;

    public PanelDeControlVista() {
        this.columna1 = new VBox();
        this.columna2 = new VBox();
        this.columna3 = new VBox();
        this.grid = new GridPane();
    }

    public void establecerLabelReferencia(int index) {
        // Obtiene el label de la primera columna
        Label label = (Label) this.columna1.getChildren().get(index);

        // Establece la referencia al label en la segunda columna
        this.columna2.getChildren().add(label);
    }

    public GridPane crearVista (ListaCircular<Jugador> jugadores) {

        this.grid.add(this.columna1,0,0);
        this.grid.add(this.columna2,0,1);
        this.grid.add(this.columna3,0,2);

        for (int i = 0; i < jugadores.tamanio(); i++) {
            Label label = new Label(jugadores.obtener().miNombre());
            this.columna1.getChildren().add(label);
            jugadores.siguiente();
        }

        return this.grid;
    }
}
