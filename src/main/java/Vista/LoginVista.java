package Vista;

import Datos.MensajesUsuario;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.LinkedList;

public class LoginVista {
    private MensajesUsuario m = new MensajesUsuario();
    private GridPane grid = new GridPane();
    private Label titulo = new Label(m.IngresoDeJugadores());
    private Button botonIniciar = new Button(m.IninciarJuego());

    private LinkedList jugadores = new LinkedList<>();
    private Stage stage = new Stage();
    private final LoginVistaModelo viewModel =
            new LoginVistaModelo();

    public void crearVista () {

        this.grid.setStyle("-fx-background-color: black;");
        this.titulo.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-padding: 20;");
        this.titulo.setAlignment(Pos.TOP_CENTER);

        this.grid.add(this.titulo, 0, 0);
        this.grid.setAlignment(Pos.TOP_CENTER);
        this.construirInputs(6);


        int j= 0;
        for (int i=0; i<this.jugadores.size();i++) {
            grid.add((TextField) this.jugadores.get(i),0,i+1);
            j++;
        }

        this.botonIniciar.setOnAction(this::iniciarJuego);
        this.botonIniciar.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        this.grid.add(this.botonIniciar,0,j+1);
        this.grid.setHalignment(botonIniciar, HPos.CENTER);

        grid.setVgap(20);

        this.enlazarVistaModelo();

        Scene scene = new Scene(this.grid,700,450);

        this.stage.setTitle(m.TituloAplicacion());
        this.stage.setScene( scene );
        this.stage.show();
    }
    private void construirInputs (int cantidad) {
        for (int i= 0; i< cantidad ; i++ ) {
            TextField input = new TextField();
            input.setStyle("-fx-margin: 40");
            this.jugadores.add(input);
        }
    }
    private void enlazarVistaModelo () {

        for (int i=0;i<grid.getChildren().size()-1;i++) {
            if (grid.getChildren().get(i).getClass() == TextField.class) {
                TextField t = (TextField) grid.getChildren().get(i);
                String nombre = t.toString();
                if (!nombre.equals("")) this.viewModel.agregarUsuario(t.toString());
            }
        }

        this.viewModel.implementarStage(this.stage);
    }
    private void iniciarJuego (ActionEvent actionEvent) {
        this.viewModel.iniciar();
    }
}
