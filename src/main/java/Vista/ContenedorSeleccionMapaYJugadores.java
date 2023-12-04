package Vista;

import Datos.MensajesUsuario;
//import Vista.BotonHandlers.BotonCargarMapaEventHandler;
//import Vista.BotonHandlers.BotonIniciarJuegoEventHandler;
import Vista.BotonHandlers.BotonIniciarJuegoEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class ContenedorSeleccionMapaYJugadores extends BorderPane {
    private Stage stage;
    private MensajesUsuario mensajes = new MensajesUsuario();
    private VBox vBoxDeJugadores;
    private VBox vBoxDeMapas;
    private ToggleGroup grupoDeMapas;


    public ContenedorSeleccionMapaYJugadores(Stage stage){
        this.stage = stage;

        this.vBoxDeJugadores = new VBox(15);
        this.vBoxDeJugadores.setPadding(new Insets(10, 20, 20, 20));
        this.vBoxDeJugadores.setMaxHeight(100);
        //this.vBoxDeJugadores.setStyle("-fx-background-color: black;");

        this.vBoxDeMapas = new VBox(15);
        this.vBoxDeMapas.setPadding(new Insets(10, 20, 20, 20));
        this.vBoxDeMapas.setMaxHeight(100);
        //this.vBoxDeMapas.setStyle("-fx-background-color: black;");

        this.grupoDeMapas = new ToggleGroup();

        //this.setStyle("-fx-background-color: black;");
        this.ponerImagenDeFondo();

        this.agregarParaPonerNombres(6);

        this.agregarParaElegirMapa();

        this.agregarBotones();

        HBox hbox = new HBox(50);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(vBoxDeJugadores, vBoxDeMapas);

        //this.setLeft(vBoxDeJugadores);
        //this.setRight(vBoxDeMapas);

        this.setCenter(hbox);

        //this.add(vBoxDeJugadores, 0, 0);
        //this.add(vBoxDeMapas, 1, 0);

        //this.setAlignment(Pos.TOP_CENTER);


    }


    //private GridPane grid = new GridPane();
    //private Button botonIniciar = new Button(mensajes.IniciarJuego());
    //private Button botonMapa = new Button(mensajes.CargarMapa());
    //private FileChooser fileChooser = new FileChooser();
    //private LinkedList jugadores = new LinkedList<>();
    //private Stage stage = new Stage();
    //private final LoginVistaModelo viewModel = new LoginVistaModelo();

    /*
    public LoginVista() {
        super();
        this.crearVista();
    }

     */

    public void crearVista() {

        //this.grid.setStyle("-fx-background-color: black;");



        //this.grid.add(this.titulo, 0, 0);
        //this.grid.setAlignment(Pos.TOP_CENTER);


        //this.construirInputs(6);


        /*
        int j = 0;
        for (int i = 0; i < this.jugadores.size(); i++) {
            grid.add((TextField) this.jugadores.get(i), 0, i + 1);
            j++;
        }
         */

        //this.botonIniciar.setOnAction(this::iniciarJuego);
        //this.botonMapa.setOnAction(this::cargarMapa);
        //this.botonIniciar.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        //this.grid.add(this.botonIniciar, 0, j + 1);


        /////////7///////this.grid.setHalignment(botonIniciar, HPos.CENTER);

        /////////grid.setVgap(20);

        //this.enlazarVistaModelo();

        //this.fileChooser.setTitle(mensajes.CargarMapa());

        //this.grid.add(this.botonMapa, 0, j + 2);

        //this.setCenter(this.grid);
    }

    /*
    private void enlazarVistaModelo() {
        this.viewModel.implementarStage(this.stage);
    }

     */

    /*
    private void iniciarJuego(ActionEvent actionEvent) {
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

     */

    /*

    private void cargarMapa(ActionEvent actionEvent) {
        try {
            File archivo = fileChooser.showOpenDialog(this.stage);
            this.viewModel.cargarMapa(archivo.getAbsolutePath());
        } catch (IOException | ArchivoNoEncontrado | DatoNoValido | DatoNoEncontrado error) {
            MensajesErrores me = new MensajesErrores();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(me.ErrorAlCargarElMapa());
            alert.show();
        }
    }

     */

    /*
    private TextField crearTextField() {

        TextField textField = new TextField();
        textField.setStyle("-fx-margin: 40");
        return textField;
    }

     */

    /*
    private void construirInputs(int cantidad) {

        for (int i = 0; i < cantidad; i++) {
            this.jugadores.add(crearTextField());
        }
    }

     */

    /*
    private void agregarJugadores() {

        for (int i = 0; i < grid.getChildren().size(); i++) {
            if (grid.getChildren().get(i).getClass() == TextField.class) {
                TextField t = (TextField) grid.getChildren().get(i);
                if (!t.getText().equals("")) this.viewModel.agregarUsuario(t.getText());
            }
        }
    }

     */

    private void ponerImagenDeFondo(){
        Image imagen = new Image("file:src/main/java/Vista/Imagenes/pruebaDeFondo.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }

    private void ponerTituloDeJugadores(){
        Label tituloJugadores = new Label(mensajes.IngresoDeJugadores());
        tituloJugadores.setFont(new Font(" times new roman", 24));
        tituloJugadores.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-padding: 20;");
        tituloJugadores.setAlignment(Pos.TOP_CENTER);

        this.vBoxDeJugadores.getChildren().add(tituloJugadores);
    }

    private void agregarParaPonerNombres(int cantidad){
        this.ponerTituloDeJugadores();
        for (int i = 0; i < cantidad; i++){
            //this.vBoxDeJugadores.add(new Label("Jugador " + (i+1)), 0, i+2);
            this.vBoxDeJugadores.getChildren().add(new TextField());
        }
        //this.vBoxDeJugadores.setHgap(20);
        //this.vBoxDeJugadores.setVgap(10);
        //this.vBoxDeJugadores.setPadding(new Insets(10, 10, 10, 10));
    }

    private void ponerTituloDeMapas(){
        Label tituloDeMapas = new Label(this.mensajes.eleccionDeMapas());
        tituloDeMapas.setStyle("-fx-font-size: 24; -fx-text-fill: white; -fx-padding: 20;");
        tituloDeMapas.setAlignment(Pos.TOP_CENTER);

        this.vBoxDeMapas.getChildren().add(tituloDeMapas);
    }


    private void agregarParaElegirMapa(){
        this.ponerTituloDeMapas();

        RadioButton mapa1 = new RadioButton("mapaDeLaCatedra");
        mapa1.setTextFill(Color.WHITE);
        RadioButton mapa2 = new RadioButton("mapaDeEjemplo");
        mapa2.setTextFill(Color.WHITE);
        RadioButton mapa3 = new RadioButton("mapaDeEjemplo2");
        mapa3.setTextFill(Color.WHITE);
        RadioButton mapa4 = new RadioButton("mapaDeEjemplo3");
        mapa4.setTextFill(Color.WHITE);

        mapa1.setToggleGroup(this.grupoDeMapas);
        mapa2.setToggleGroup(this.grupoDeMapas);
        mapa3.setToggleGroup(this.grupoDeMapas);
        mapa4.setToggleGroup(this.grupoDeMapas);

        this.vBoxDeMapas.getChildren().addAll(mapa1, mapa2, mapa3, mapa4);

        //this.gridPaneMapas.setHgap(20);
        //this.gridPaneMapas.setVgap(10);
        //this.gridPaneMapas.setPadding(new Insets(10, 10, 10, 10));
    }

    private void agregarBotones(){
        this.agregarBotonIniciarJuego();
        this.agregarBotonParaElegirMapa();
    }

    private void agregarBotonIniciarJuego(){
        Button boton = new Button(mensajes.IniciarJuego());
        boton.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        BotonIniciarJuegoEventHandler botonEventHandler = new BotonIniciarJuegoEventHandler(this.stage, this.vBoxDeJugadores, this.grupoDeMapas);
        boton.setOnAction(botonEventHandler);

        //this.vBoxDeJugadores.getChildren().add(boton);
        //boton.setMaxWidth(Double.MAX_VALUE);
        //boton.setMaxHeight(Double.MAX_VALUE);
        boton.setMinWidth(170);
        boton.setMinHeight(100);
        BorderPane.setMargin(boton, new Insets(10, 10, 10, 10));
        BorderPane.setAlignment(boton, Pos.TOP_CENTER);
        this.setBottom(boton);
    }

    private void agregarBotonParaElegirMapa(){
        Button botonMapa = new Button(mensajes.CargarMapa());
        botonMapa.setStyle("-fx-font-size: 18; -fx-text-fill: white;-fx-background-color: green ;-fx-padding: 5;");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(mensajes.CargarMapa());
        //BotonCargarMapaEventHandler botonEventHandler = new BotonCargarMapaEventHandler(this.stage, fileChooser);
        //botonMapa.setOnAction(botonEventHandler);

        this.vBoxDeMapas.getChildren().add(botonMapa);
    }
}