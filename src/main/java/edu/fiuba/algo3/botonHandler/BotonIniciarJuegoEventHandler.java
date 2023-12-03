package edu.fiuba.algo3.botonHandler;

import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Elementos.MockDado;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Jugadores.SemiSenior;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.Tablero;
import edu.fiuba.algo3.modelo.EscenaDeJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class BotonIniciarJuegoEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private AlgoRoma juego;
    private Tablero tablero;
    private GridPane gridPaneNombres;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private ToggleGroup grupoDeMapas;

    public BotonIniciarJuegoEventHandler(Stage stage, GridPane gridPaneNombres, ToggleGroup grupoDeMapas){
        this.stage = stage;
        this.gridPaneNombres = gridPaneNombres;
        this.grupoDeMapas =  grupoDeMapas;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        MockDado mockDado = new MockDado();
        Mapa mapa = generarMapa();
        tablero = new Tablero(mapa);
        juego = new AlgoRoma(tablero);
        this.generarGladiadores();
        this.agregarDadosALosGladiadores(mockDado);
        try {
            this.agregarGladiadorAlJuego();
        } catch (ElNombreDebeContenerUnMinimoDe4Caracteres e) {
            throw new RuntimeException(e);
        }

        this.pasarEscena();
    }

    private Mapa generarMapa(){
        RadioButton botonElegido = (RadioButton) this.grupoDeMapas.getSelectedToggle();
        String nombreDeMapaElegido = botonElegido.getText();
        try {
            System.out.print("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            InformacionMapaEnJSON informacion = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDeMapaElegido +".json");
            Mapa mapa = new Mapa(informacion);
            mapa.contruirMapa();
            return mapa;
        } catch (ArchivoNoEncontrado | DatoNoEncontrado | DatoNoValido e) {
            throw new RuntimeException(e);
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
            jugadores.get(i).agregarDispositivoAzar(dado);
        }
    }

    private void agregarGladiadorAlJuego() throws ElNombreDebeContenerUnMinimoDe4Caracteres {
        for (int i = 0; i < this.jugadores.size(); i++){
            this.juego.agregarJugador(jugadores.get(i));
        }
    }

    private void pasarEscena(){
        EscenaDeJuego creaEscenaDeJuego = new EscenaDeJuego(this.stage, this.juego, this.jugadores, this.tablero);
        Scene escenaDeJuego = creaEscenaDeJuego.devolverEscena();
        this.stage.setScene(escenaDeJuego);
    }
}
