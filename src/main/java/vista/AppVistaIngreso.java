package vista;

import componentes.*;
import componentes.botonHandler.BotonHandlerIniciar;
import componentes.botones.BotonJuego;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AppVistaIngreso extends GridPane {
    private App controlador;
    private AppModelo modelo;
    private Scene escena;

    public AppVistaIngreso(App controlador, AppModelo modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.imagenDeFondo();

        SeleccionMapa selectMapa = new SeleccionMapa();

        HBox contenedorBoton = new HBox();
        BotonJuego botonIniciar = new BotonJuego("INICIAR JUEGO", "blue");
        contenedorBoton.getChildren().add(botonIniciar);
        contenedorBoton.setAlignment(Pos.CENTER);

        Label mensaje = new Label("INGRESE MINIMO 2 JUGADORES");
        Label otroMensaje = new Label("ADVERTENCIA: Cada nombre debe tener minimo 4 caracteres");
        mensaje.setAlignment(Pos.CENTER);
        mensaje.setTextFill(Color.BLUE);
        otroMensaje.setAlignment(Pos.CENTER);
        otroMensaje.setTextFill(Color.BLUE);

        this.addRow(0, mensaje);
        this.addRow(1, otroMensaje);

        this.addRow(2, selectMapa);

        ContenedorIngresoNombres contenedorIngreso = new ContenedorIngresoNombres();

        this.addRow(3, contenedorIngreso);
        this.addRow(4, contenedorBoton);

        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        BotonHandlerIniciar botonHandlerIniciar = new BotonHandlerIniciar(contenedorIngreso.conseguirTextFields(),
                controlador, modelo, selectMapa);
        botonIniciar.setOnAction(botonHandlerIniciar);

        escena = new Scene(this, 800, 700);
    }

    public Scene obtenerEscena() {
        return this.escena;
    }

    private void imagenDeFondo() {
        Image imagen = new Image("file:src/main/resources/imagenes/fondos/fondoIngreso.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }
}
