package componentes;

import componentes.botones.BotonJuego;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.PartidaFinalizada;
import entidades.errores.PartidaNoFinalizada;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;


public class PanelControl extends VBox {
    public PanelControl(AppModelo modelo, MapaVista mapaVista) {
        BotonJuego botonLanzar = new BotonJuego("LANZAR", "blue");
        PanelEstadisticasJugadores panelEstadisticasJugadores = new PanelEstadisticasJugadores(modelo);
        VentanaPartidaFinalizada ventanaPartidaFinalizada = new VentanaPartidaFinalizada(Alert.AlertType.INFORMATION);

        this.getChildren().add(botonLanzar);
        this.getChildren().add(panelEstadisticasJugadores);
        botonLanzar.setOnAction(e -> {
            try {
                modelo.moverJugador(mapaVista);
                panelEstadisticasJugadores.actualizarEstadisticas(modelo);
            } catch (PartidaFinalizada | PartidaNoFinalizada err) {

            }
            //
            e.consume();
        });

        this.setPadding(new Insets(25));
        this.setAlignment(Pos.CENTER);
    }
}
