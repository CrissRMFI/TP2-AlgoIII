package controlador.BotonHandlers;

import datos.InformacionMapaEnJSON;
import datos.MensajesErrores;
import modelo.AlgoRoma;
import modelo.elementos.Dado;
import modelo.errores.*;
import modelo.jugadores.Gladiador;
import modelo.jugadores.Jugador;
import modelo.tablero.Mapa;
import vista.ContenedorJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


public class BotonIniciarJuegoEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private AlgoRoma juego;
    private InformacionMapaEnJSON informacion;
    private Mapa mapa;
    private VBox gridPaneNombres;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ToggleGroup grupoDeMapas;

    public BotonIniciarJuegoEventHandler(Stage stage, VBox gridPaneNombres, ToggleGroup grupoDeMapas) {
        this.stage = stage;
        this.gridPaneNombres = gridPaneNombres;
        this.grupoDeMapas = grupoDeMapas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.generarGladiadores();
        Dado dado = new Dado();
        generarMapa();
        juego = new AlgoRoma(this.mapa);
        this.agregarDadosALosGladiadores(dado);
        try {
            this.agregarGladiadorAlJuego();
        } catch (ElNombreDebeContenerUnMinimoDe4Caracteres e) {
            throw new RuntimeException(e);
        }

        try {
            this.pasarEscena();
        } catch (CantidadMinimaDeJugadores e) {
            throw new RuntimeException(e);
        } catch (DatoNoValido e) {
            throw new RuntimeException(e);
        }
    }

    private void generarMapa() {
        RadioButton botonElegido = (RadioButton) this.grupoDeMapas.getSelectedToggle();
        String nombreDeMapaElegido = botonElegido.getText();
        try {
            System.out.print("src/main/java/Datos/" + nombreDeMapaElegido + ".json");
            this.informacion = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDeMapaElegido + ".json");
            this.mapa = new Mapa(this.informacion);
        } catch (ArchivoNoEncontrado | DatoNoEncontrado | DatoNoValido e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(MensajesErrores.ERROR_AL_CARGAR_EL_MAPA);
            alert.show();
        }
    }

    private void generarGladiadores() {
        for (int i = 0; i < this.gridPaneNombres.getChildren().size(); i++) {
            if (this.gridPaneNombres.getChildren().get(i).getClass() == TextField.class) {
                TextField t = (TextField) this.gridPaneNombres.getChildren().get(i);
                if (!t.getText().equals("")) {
                    //this.jugadores.add(new Gladiador(t.getText()));
                }
            }
        }
    }

    private void agregarDadosALosGladiadores(Dado dado) {
        for (int i = 0; i < this.jugadores.size(); i++) {
            if (i == 1) {
                jugadores.get(i).agregarDispositivoAzar(new Dado());
            }
            jugadores.get(i).agregarDispositivoAzar(dado);
        }
    }

    private void agregarGladiadorAlJuego() throws ElNombreDebeContenerUnMinimoDe4Caracteres {
        for (int i = 0; i < this.jugadores.size(); i++) {
            this.juego.agregarJugador(jugadores.get(i));
        }
    }


    private void pasarEscena() throws CantidadMinimaDeJugadores, DatoNoValido {
        ContenedorJuego contenedorJuego = new ContenedorJuego(this.stage, this.juego, this.jugadores, this.informacion);
        Scene escenaDeJuego = new Scene(contenedorJuego);
        this.stage.setScene(escenaDeJuego);

    }

}
