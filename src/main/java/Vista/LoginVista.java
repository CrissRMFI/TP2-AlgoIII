package Vista;

import Datos.MensajesErrores;
import Datos.MensajesUsuario;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class LoginVista {
    private MensajesUsuario m = new MensajesUsuario();
    private GridPane grid = new GridPane();
    private Label titulo = new Label(m.IngresoDeJugadores());
    private Button botonIniciar = new Button(m.IninciarJuego());

    private Button botonMapa = new Button(m.CargarMapa());

    private FileChooser fileChooser = new FileChooser();

    private LinkedList jugadores = new LinkedList<>();
    private Stage stage = new Stage();
    private final LoginVistaModelo viewModel =
            new LoginVistaModelo();

    public void crearVista ()  {

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
        this.botonMapa.setOnAction(this::cargarMapa);
        this.botonIniciar.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        this.grid.add(this.botonIniciar,0,j+1);
        this.grid.setHalignment(botonIniciar, HPos.CENTER);

        grid.setVgap(20);

        this.enlazarVistaModelo();

        this.fileChooser.setTitle(m.CargarMapa());

        this.grid.add(this.botonMapa,0,j+2);

        Scene scene = new Scene(this.grid,700,450);

        this.stage.setTitle(m.TituloAplicacion());
        this.stage.setScene( scene );
        this.stage.show();
    }

    private void enlazarVistaModelo () {
        this.viewModel.implementarStage(this.stage);
    }
    private void iniciarJuego (ActionEvent actionEvent)  {
        try {
            this.agregarJugadores();
            this.viewModel.iniciar();
        } catch (Exception error) {
            MensajesErrores me = new MensajesErrores();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(me.ErrorAlIniciarElJuego());
            alert.show();
        }

    }

    private void cargarMapa (ActionEvent actionEvent) {


        try {
            File archivo = fileChooser.showOpenDialog(this.stage);
            this.viewModel.cargarMapa(archivo.getAbsolutePath());
        } catch (IOException error) {
            MensajesErrores me = new MensajesErrores();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(me.ErrorAlCargarElMapa());
            alert.show();
        }
    }

    private TextField crearTextField () {
        TextField textField = new TextField();
        textField.setStyle("-fx-margin: 40");
        return textField;
    }

    private void construirInputs (int cantidad) {
        for (int i= 0; i< cantidad ; i++ ) {
            this.jugadores.add(crearTextField());
        }
    }

    private void agregarJugadores () {
        for (int i=0;i<grid.getChildren().size();i++) {
            if (grid.getChildren().get(i).getClass() == TextField.class) {
                TextField t = (TextField) grid.getChildren().get(i);
                if (!t.getText().equals("")) this.viewModel.agregarUsuario(t.getText());
            }
        }
    }
}
