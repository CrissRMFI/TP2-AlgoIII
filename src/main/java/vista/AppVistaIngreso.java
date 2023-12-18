package vista;

import componentes.*;
import componentes.botones.BotonJuego;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.*;
import entidades.jugadores.Gladiador;
import entidades.jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class AppVistaIngreso extends GridPane {
    private App controlador;
    private AppModelo modelo;
    private Scene escena;
    private String rutaMapa;

    public AppVistaIngreso(App controlador, AppModelo modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.imagenDeFondo();

        SeleccionMapa selectMapa = new SeleccionMapa();

        HBox contenedorBoton = new HBox();
        BotonJuego botonIniciar = new BotonJuego("INICIAR JUEGO", "blue");
        contenedorBoton.getChildren().add(botonIniciar);
        contenedorBoton.setAlignment(Pos.CENTER);

        this.addRow(0, selectMapa);

        ContenedorIngresoNombres contenedorIngreso = new ContenedorIngresoNombres();

        this.addRow(1, contenedorIngreso);
        this.addRow(2, contenedorBoton);

        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        botonIniciar.setOnAction(e -> {
            try {
            int jugadorNumero = 1;
            for (String nombreJugador : contenedorIngreso.conseguirNombres()) {
                Jugador jugador = new Gladiador(nombreJugador);
                modelo.agregarJugador(this.getJugador(jugador, jugadorNumero));
                jugadorNumero++;
            }
                controlador.crearJuego(modelo, selectMapa.obtenerRutaMapa());
                controlador.iniciarJuego(modelo, selectMapa.obtenerRutaMapa());
            } catch (DatoNoEncontrado | DatoNoValido | ArchivoNoEncontrado | CantidadMinimaDeJugadores |
                     ElNombreDebeContenerUnMinimoDe4Caracteres er) {
                modelo.clearJugadores();
                VentanaErrores v = new VentanaErrores(Alert.AlertType.WARNING);
                v.setContentText(er.getMessage());
                v.show();
            }
        });
        escena = new Scene(this, 800, 700);
    }

    private JugadorVista getJugador(Jugador jugador, int i) {
        return new GladiadorVista(jugador, i);
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

    private String rutaMapa() {
        return this.rutaMapa;
    }
}
