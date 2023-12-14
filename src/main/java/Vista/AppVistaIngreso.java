package Vista;

import Componentes.*;
import Entidades.Errores.*;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

        HBox hbox = new HBox();
        Button iniciar = new BotonIniciarJuego("INICIAR JUEGO");
        hbox.getChildren().add(iniciar);
        hbox.setAlignment(Pos.CENTER);

        this.addRow(0, selectMapa);

        for(int i = 2; i < 8 ; i++){
            TextField input = new InputNombre();
            this.addRow(i, input);
        }
        this.addRow(10, hbox);

        this.setPadding(new Insets(10, 0, 10, 0));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        iniciar.setOnAction(e -> {
            for (int i = 0; i < this.getChildren().size(); i++) {
                try {
                    TextField text = (TextField) this.getChildren().get(i);
                    String nombre = text.getText();
                    if (!nombre.equals("")) {
                        Jugador jugador = new Gladiador(nombre);
                        Componentes.Jugador jugadorVista = this.getJugador(i, jugador);
                        modelo.agregarJugador(jugadorVista);

                    }

                } catch (Exception error) {
                }
            }

            try {
                controlador.crearJuego(modelo, selectMapa.obtenerRutaMapa());
                controlador.iniciarJuego(modelo, selectMapa.obtenerRutaMapa());
            } catch (DatoNoEncontrado | DatoNoValido | ArchivoNoEncontrado | CantidadMinimaDeJugadores er) {
                modelo.clearJugadors();
                VentanaCantidadJugadores v = new VentanaCantidadJugadores(Alert.AlertType.WARNING);
                v.setContentText("LA CANITDAD DE JUGAODRES DEBE SER DE DOS COMO MINIMO");
                v.show();
            }
        });
        escena = new Scene(this, 800, 700);
    }

    private Componentes.Jugador getJugador(int i, Jugador jugador) {
        return new GladiadorVista(jugador, i);
    }

    public Scene obtenerEscena() {
        return this.escena;
    }

    private void imagenDeFondo() {
        Image imagen = new Image("file:src/main/java/Vista/Imagenes/pruebaDeFondo.png");

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
