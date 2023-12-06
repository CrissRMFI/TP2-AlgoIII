package vista;


import controlador.BotonHandlers.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorMenuPrincipal extends BorderPane {
    Stage stage;
    VBox vbox;

    public ContenedorMenuPrincipal(Stage stage, Scene proximaEscena) {
        this.stage = stage;

        /*
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
         */

        //Image imagen = scale(new Image("imagenes/imagen_menu_principal.jpg"), 1920, 1080, false);

        this.ponerImagenDeFondo();

        this.vbox = new VBox();
        this.vbox.setSpacing(20);
        this.vbox.setPadding(new Insets(10, 20, 10, 20));

        Titulo titulo = new Titulo("A L G O R O M A");
        this.vbox.getChildren().add(titulo);

        //this.ponerLogo();

        /*
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
         */

        //Label etiqueta = new Label("Bienvenidos a AlgoRoma");
        //etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        //etiqueta.setTextFill(Color.WHITE); //web("#66A7C5")

        /*
        BotonMenuPrincipal botonIniciar = new BotonMenuPrincipal("Iniciar");

        BotonMenuPrincipal botonOpciones = new BotonMenuPrincipal("Opciones");

        BotonMenuPrincipal botonSalir = new BotonMenuPrincipal("Salir");
         */

        BotonMenuPrincipal botonIniciarJuego = new BotonMenuPrincipal("Iniciar Juego");
        botonIniciarJuego.setOnAction(e -> this.stage.setScene(proximaEscena));

        /*
        HandlerIniciar botonIniciarHandler = new HandlerIniciar(stage, proximaEscena);
        botonIniciar.setOnAction(botonIniciarHandler);
         */

        //HandlerOptions botonOpcionesHandler = new HandlerOptions(stage);
        //botonOpciones.setOnAction(botonOpcionesHandler);

        BotonMenuPrincipal botonSalirDelJuego = new BotonMenuPrincipal("Salir del juego");
        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonSalirDelJuego.setOnAction(botonSalirEventHandler);

        /*
        HandlerSalir botonSalirHandler = new HandlerSalir();
        botonSalir.setOnAction(botonSalirHandler);
         */

        this.vbox.getChildren().addAll(botonIniciarJuego, botonSalirDelJuego);

        //this.vbox.getChildren().addAll(etiqueta, botonIniciarJuego, botonSalirDelJuego);

        //this.getChildren().addAll(etiqueta, botonIniciar, botonOpciones,botonSalir);

        this.setLeft(this.vbox);
    }

    private void ponerImagenDeFondo() {
        Image imagen = new Image("imagenes/roma.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }

    /*
    private void ponerLogo(){
        ImageView muestraImagen = new ImageView();
        Image logo = new Image("imagenes/fetchimage.png", 170, 170, false, false);
        muestraImagen.setImage(logo);

        this.vbox.getChildren().addAll(muestraImagen);
    }

     */


    public Image scale(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {
        ImageView imageView = new ImageView(source);
        imageView.setPreserveRatio(preserveRatio);
        imageView.setFitWidth(targetWidth);
        imageView.setFitHeight(targetHeight);
        return imageView.snapshot(null, null);
    }

}