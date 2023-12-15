package componentes;

import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.layout.HBox;

public class PanelEstadisticasJugadores extends HBox {
    public PanelEstadisticasJugadores(AppModelo modelo) {
        modelo.cargarEstadisticas(this);
    }

    public void actualizarEstadisticas(AppModelo modelo) {
        this.getChildren().clear();
        modelo.cargarEstadisticas(this);

    }
}
