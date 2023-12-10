package Vista;

import Componentes.BarraObjetos;
import Componentes.Mapa;
import Componentes.PanelControl;
import Entidades.Errores.ArchivoNoEncontrado;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class AppVistaJuego {
    private Scene scene;

    public AppVistaJuego (AppModelo modelo) {
        try {
            GridPane gridPane = new GridPane();
            gridPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

            BarraObjetos barraObjetos = new BarraObjetos();
            Mapa mapa = new Mapa(modelo);
            PanelControl panelControl = new PanelControl(modelo);

            gridPane.add(barraObjetos,0,0);
            gridPane.add(mapa,0,1);
            gridPane.add(panelControl,0,2);
            gridPane.setAlignment(Pos.BASELINE_CENTER);

            this.scene = new Scene(gridPane, 1000, 800);
        } catch (ArchivoNoEncontrado e) {

        }
    }
    public Scene obtenerEscena() {
        return this.scene;
    }

}
