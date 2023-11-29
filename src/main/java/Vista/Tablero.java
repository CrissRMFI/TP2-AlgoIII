package Vista;
import Datos.MensajesUsuario;
import Entidades.Jugadores.Jugador;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.LinkedList;

public class Tablero {

    private LinkedList<Jugador> jugadores;

    public Tablero(LinkedList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public void start()  {

        MensajesUsuario m = new MensajesUsuario();
        Stage stage = new Stage();

        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle(m.CargarMapa());

        Button openButton = new Button(m.CargarMapa());

        openButton.setOnAction(e -> {
            fileChooser.showOpenDialog(stage);
        });


        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: black;");
        grid.add(openButton, 0, 2);


        Scene scene = new Scene(grid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

}
