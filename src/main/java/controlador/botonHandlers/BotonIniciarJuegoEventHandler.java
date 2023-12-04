package controlador.botonHandlers;

import datos.InformacionMapaEnJSON;
import datos.MensajesErrores;
import modelo.AlgoRoma;
import modelo.elementos.MockDado;
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
    private Mapa mapa;
    private VBox gridPaneNombres;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ToggleGroup grupoDeMapas;

    public BotonIniciarJuegoEventHandler(Stage stage, VBox gridPaneNombres, ToggleGroup grupoDeMapas){
        this.stage = stage;
        this.gridPaneNombres = gridPaneNombres;
        this.grupoDeMapas =  grupoDeMapas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        this.generarGladiadores();
        MockDado mockDado = new MockDado();
        generarMapa();
        juego = new AlgoRoma(this.mapa);
        this.agregarDadosALosGladiadores(mockDado);
        try {
            this.agregarGladiadorAlJuego();
        } catch (ElNombreDebeContenerUnMinimoDe4Caracteres e) {
            throw new RuntimeException(e);
        }

        try {
            this.pasarEscena();
        } catch (CantidadMinimaDeJugadores e) {
            throw new RuntimeException(e);
        }
    }

    private void generarMapa(){
        RadioButton botonElegido = (RadioButton) this.grupoDeMapas.getSelectedToggle();
        String nombreDeMapaElegido = botonElegido.getText();
        try {
            System.out.print("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            InformacionMapaEnJSON informacion = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            this.mapa = new Mapa(informacion);
        } catch (ArchivoNoEncontrado | DatoNoEncontrado | DatoNoValido e) {
            MensajesErrores mensajes = new MensajesErrores();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(mensajes.ErrorAlCargarElMapa());
            alert.show();
        }
    }

    private void generarGladiadores(){
        for (int i = 0; i < this.gridPaneNombres.getChildren().size(); i++) {
            if (this.gridPaneNombres.getChildren().get(i).getClass() == TextField.class) {
                TextField t = (TextField) this.gridPaneNombres.getChildren().get(i);
                if (!t.getText().equals("")){
                    this.jugadores.add(new Gladiador(t.getText()));
                }
            }
        }
    }

    private void agregarDadosALosGladiadores(MockDado dado){
        for (int i = 0; i < this.jugadores.size(); i++){
            if (i == 1){
                jugadores.get(i).agregarDispositivoAzar(new MockDado(3));
            }
            jugadores.get(i).agregarDispositivoAzar(dado);
        }
    }

    private void agregarGladiadorAlJuego() throws ElNombreDebeContenerUnMinimoDe4Caracteres {
        for (int i = 0; i < this.jugadores.size(); i++){
            this.juego.agregarJugador(jugadores.get(i));
        }
    }


    private void pasarEscena() throws CantidadMinimaDeJugadores {
        ContenedorJuego contenedorJuego = new ContenedorJuego(this.stage, this.juego, this.jugadores, this.mapa);
        Scene escenaDeJuego = new Scene(contenedorJuego);
        this.stage.setScene(escenaDeJuego);

    }

}
