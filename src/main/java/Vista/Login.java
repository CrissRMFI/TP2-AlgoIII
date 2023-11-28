package Vista;

import Datos.MensajesUsuario;
import Entidades.AlgoRoma;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane; // Importe el layout deseado
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage stage) {
        MensajesUsuario m = new MensajesUsuario();


        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: black;");


        Label tituloLogin = new Label(m.IngresoDeJugadores());
        tituloLogin.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-padding: 20;");

        tituloLogin.setAlignment(Pos.TOP_CENTER);


        grid.add(tituloLogin, 0, 0);
        grid.setAlignment(Pos.TOP_CENTER);


        this.construirInputs(grid,6);

        grid.setVgap(20);

        Button botonIniciarJuego = new Button(m.IninciarJuego());

        botonIniciarJuego.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        botonIniciarJuego.setOnAction(e -> {

            stage.close();
        });

        grid.add(botonIniciarJuego, 0, 7);
        GridPane.setHalignment(botonIniciarJuego, HPos.CENTER);

        Scene scene = new Scene(grid, 700, 450);

        stage.setScene(scene);
        stage.show();
    }


    private void construirInputs (GridPane grid, int cantidad) {
        for (int i= 0; i< cantidad ; i++ ) {
            TextField input = new TextField();
            input.setStyle("-fx-margin: 40");
            grid.add(input,0,i+1);
        }
    }

}
