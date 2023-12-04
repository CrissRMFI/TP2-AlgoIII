package vista;

import datos.MensajesUsuario;
import modelo.jugadores.Jugador;
import utils.ListaCircular;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

public class PanelDeControlVista {
    private GridPane grid;
    private GridPane columna1;
    private VBox columna2;
    private VBox columna3;

    private MensajesUsuario m = new MensajesUsuario();



    public PanelDeControlVista() {
        this.columna1 = new GridPane();
        this.columna2 = new VBox();
        this.columna3 = new VBox();
        this.grid = new GridPane();
    }


    public GridPane crearVista (ListaCircular<Jugador> jugadores) {

       this.grid.add(this.construirColumna1(jugadores),0,0);
       return this.grid;
    }

    private GridPane construirColumna1(ListaCircular<Jugador> jugadores) {

        MensajesUsuario m = new MensajesUsuario();
        GridPane grid = new GridPane();
        Label tituloJugadores = new Label(m.PanelControlTituloJugadores());

        tituloJugadores.setFont(new Font("Arial", 36));
        tituloJugadores.setTextFill(Color.WHITE);

        this.columna1.add(tituloJugadores,0,0);
        this.columna1.setPadding(new Insets(10));
        this.columna1.setHalignment(tituloJugadores, HPos.CENTER);



        for (int i=0; i<jugadores.tamanio(); i++) {
            Label jugador = new Label(jugadores.obtener().yoSoy());
            jugador.setPadding(new Insets(0, 0, 10, 10));
            jugador.setFont(new Font("Arial", 24));
            jugador.setTextFill(Color.WHITE);
            jugadores.siguiente();
            this.columna1.add(jugador,0,i+2);
            this.columna1.setHalignment(jugador, HPos.LEFT);
        }

        grid.add(this.columna1,0,0);


        grid.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));




        return grid;
    }
}
