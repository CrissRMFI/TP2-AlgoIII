package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.botonHandler.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class EscenaDeInicio {
    Stage stage;
    BorderPane borderPane;
    VBox vbox;
    Scene escenaDeInicio;
    Scene escenaDeElegir;

    public EscenaDeInicio(Stage stage, Scene escenaDeElegir){
        this.stage = stage;
        this.escenaDeElegir = escenaDeElegir;
        this.borderPane = new BorderPane();

        this.ponerImagenDeFondo();

        this.vbox = new VBox();
        this.vbox.setSpacing(10);
        this.vbox.setPadding(new Insets(10, 20, 10, 20));

        this.ponerLogo();

        Button botonIniciarJuego = new Button("Iniciar Juego");
        botonIniciarJuego.setOnAction(e -> this.stage.setScene(escenaDeElegir));

        Button botonSalirDelJuego = new Button("Salir del juego");
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonSalirDelJuego.setOnAction(botonSalirEventHandler);

        botonIniciarJuego.setMaxWidth(Double.MAX_VALUE);
        botonSalirDelJuego.setMaxWidth(Double.MAX_VALUE);

        this.vbox.getChildren().addAll(botonIniciarJuego, botonSalirDelJuego);

        this.borderPane.setLeft(this.vbox);

        this.escenaDeInicio = new Scene(this.borderPane, 600, 600);

        //this.stage.setScene(scene);
        //this.stage.show();
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

    public Scene devolverEscena(){
        return this.escenaDeInicio;
    }

}
