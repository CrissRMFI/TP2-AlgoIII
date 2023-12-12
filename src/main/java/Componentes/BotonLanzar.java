package Componentes;

import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Errores.JuegoTerminadoHayUnGanador;
import Entidades.Errores.PartidaFinalizada;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BotonLanzar extends Button {
    public BotonLanzar (String texto, AppModelo modelo, ModeloMapa mapa, Stage stage) {
        super(texto);

        this.setId("Lanzar");

        DropShadow shadow = new DropShadow();
        this.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> this.setEffect(shadow));
        this.addEventHandler(MouseEvent.MOUSE_EXITED, e -> this.setEffect(null));


        this.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> this.setTranslateZ(2));
        this.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> this.setTranslateZ(0));

        this.setOnAction(e -> {
            try {
                modelo.moverJugador(mapa);
            } catch (CantidadMinimaDeJugadores er) {

            } catch (JuegoTerminadoHayUnGanador ex) {
                FadeTransition transicion = new FadeTransition(Duration.seconds(6), stage.getScene().getRoot());
                transicion.setFromValue(1);
                transicion.setToValue(0);
                transicion.play();

                transicion.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Scene escenaDeHayGanador = new ContenedorJugadorGano(modelo.devolverJugadorActual()).obtenerScena();
                        stage.setScene(escenaDeHayGanador);
                        stage.show();
                    }
                });
            } catch (PartidaFinalizada err) {

            }
            e.consume();
        });



        this.setStyle("-fx-background-color: purple; -fx-text-fill: white;");
        this.setPrefWidth(300);
        this.setPrefHeight(30);
    }
}
