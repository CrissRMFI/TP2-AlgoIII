package Componentes;

import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Errores.PartidaFinalizada;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class PanelControl extends VBox {
    public PanelControl (AppModelo modelo,Mapa mapa) {
        BotonLanzar botonLanzar = new BotonLanzar("LANZAR");
        PanelEstadisticasJugadores panelEstadisticasJugadores = new PanelEstadisticasJugadores(modelo);


        botonLanzar.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        this.getChildren().add(botonLanzar);
        this.getChildren().add(panelEstadisticasJugadores);
        botonLanzar.setOnAction(e -> {
            try {
                modelo.moverJugador(mapa);
                panelEstadisticasJugadores.actualizarEstadisticas(modelo);
            } catch (CantidadMinimaDeJugadores er) {

            } catch (PartidaFinalizada err) {

            }
            e.consume();
        });

        this.setPadding(new Insets(25));
        this.setAlignment(Pos.CENTER);
    }
}
