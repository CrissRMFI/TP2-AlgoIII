package edu.fiuba.algo3.modelo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class EscenaDeInicio{
    Stage stage;
    BorderPane borderPane;
    VBox vbox;

    public EscenaDeInicio(Stage stage){
        this.stage = stage;
        this.borderPane = new BorderPane();

        //borderPane.setPadding(new Insets(20, 0, 20, 20));

        this.ponerImagenDeFondo();

        this.vbox = new VBox();
        //this.vbox.setAlignment(Pos.CENTER_LEFT);
        this.vbox.setSpacing(10);
        this.vbox.setPadding(new Insets(10, 20, 10, 20));

        this.ponerLogo();

        //this.vbox.setBackground(new Background(imagenDeFondo));

        Button botonIniciarJuego = new Button("Iniciar Juego");
        Button botonInformacion = new Button("Informacion");
        Button botonSalirDelJuego = new Button("Salir del juego");

        botonIniciarJuego.setMaxWidth(Double.MAX_VALUE);
        botonInformacion.setMaxWidth(Double.MAX_VALUE);
        botonSalirDelJuego.setMaxWidth(Double.MAX_VALUE);

        this.vbox.getChildren().addAll(botonIniciarJuego, botonInformacion, botonSalirDelJuego);

        this.borderPane.setLeft(this.vbox);

        /*
        button1.setMaxSize((Double.MAX_VALUE)/32, (Double.MAX_VALUE)/8);
        button2.setMaxSize((Double.MAX_VALUE)/32, (Double.MAX_VALUE)/8);
        button3.setMaxSize((Double.MAX_VALUE)/16, (Double.MAX_VALUE)/8);
         */
        /*
        VBox.setVgrow(button1, Priority.ALWAYS);
        VBox.setVgrow(button2, Priority.ALWAYS);
        VBox.setVgrow(button3, Priority.ALWAYS);

         */
        /*
        Button botonIniciarPartida = new Button("Iniciar Partida");
        botonIniciarPartida.setMaxSize(100, 200);
        this.vbox.getChildren().addAll(botonIniciarPartida);

        Button botonInformacion = new Button("Info");
        botonIniciarPartida.setMaxSize(300, 200);
        this.vbox.getChildren().addAll(botonInformacion);

        Button botonSalir = new Button("Salir");
        botonSalir.setMaxSize(100, 200);
        this.vbox.getChildren().addAll(botonSalir);
         */

        Scene scene = new Scene(this.borderPane, 600, 600);
        this.stage.setScene(scene);
        this.stage.show();
    }

    private void ponerImagenDeFondo(){
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/roma.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        borderPane.setBackground(new Background(imagenDeFondo));
    }

    private void ponerLogo(){
        ImageView muestraImagen = new ImageView();
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fetchimage.png", 170, 170, false, false);
        muestraImagen.setImage(logo);

        this.vbox.getChildren().addAll(muestraImagen);
    }

}
