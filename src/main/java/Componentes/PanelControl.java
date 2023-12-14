package Componentes;

import Entidades.Errores.PartidaFinalizada;
import Entidades.Errores.PartidaNoFinalizada;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;



public class PanelControl extends VBox {
    public PanelControl (AppModelo modelo,Mapa mapa) {
        BotonLanzar botonLanzar = new BotonLanzar("LANZAR");
        PanelEstadisticasJugadores panelEstadisticasJugadores = new PanelEstadisticasJugadores(modelo);
        VentanaPartidaFinalizada ventanaPartidaFinalizada = new VentanaPartidaFinalizada(Alert.AlertType.INFORMATION);

        botonLanzar.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        this.getChildren().add(botonLanzar);
        this.getChildren().add(panelEstadisticasJugadores);
        botonLanzar.setOnAction(e -> {
            try {

                modelo.moverJugador(mapa);
                panelEstadisticasJugadores.actualizarEstadisticas(modelo);
            } catch (PartidaFinalizada | PartidaNoFinalizada err) {

            }
            e.consume();
        });

        this.setPadding(new Insets(25));
        this.setAlignment(Pos.CENTER);
    }
}
