package Vista;

import controller.buttonHandler.HandlerIniciar;
import controller.buttonHandler.HandlerSalir;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorMenuPrincipal extends VBox {

    Stage stage;

    public ContenedorMenuPrincipal(Stage stage, Scene proximaEscena) {
        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Image imagen = scale(new Image("imagen_menu_principal.jpg"), 1920, 1080, false);

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label etiqueta = new Label("Bienvenidos a AlgoRoma");
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        etiqueta.setTextFill(Color.WHITE); //web("#66A7C5")

        BotonMenuPrincipal botonIniciar = new BotonMenuPrincipal("Iniciar");

        BotonMenuPrincipal botonOpciones = new BotonMenuPrincipal("Opciones");

        BotonMenuPrincipal botonSalir = new BotonMenuPrincipal("Salir");


        HandlerIniciar botonIniciarHandler = new HandlerIniciar(stage, proximaEscena);
        botonIniciar.setOnAction(botonIniciarHandler);

        //HandlerOptions botonOpcionesHandler = new HandlerOptions(stage);
        //botonOpciones.setOnAction(botonOpcionesHandler);

        HandlerSalir botonSalirHandler = new HandlerSalir();
        botonSalir.setOnAction(botonSalirHandler);

        this.getChildren().addAll(etiqueta, botonIniciar, botonOpciones,botonSalir);
    }

    public Image scale(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {
        ImageView imageView = new ImageView(source);
        imageView.setPreserveRatio(preserveRatio);
        imageView.setFitWidth(targetWidth);
        imageView.setFitHeight(targetHeight);
        return imageView.snapshot(null, null);
    }
}
