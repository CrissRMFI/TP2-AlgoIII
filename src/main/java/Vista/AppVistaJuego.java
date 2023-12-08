package Vista;

import Componentes.Mapa;
import Entidades.Errores.ArchivoNoEncontrado;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class AppVistaJuego {
    private Scene scene;

    public AppVistaJuego (AppModelo modelo) {
        try {
            GridPane gridPane = new GridPane();

            Mapa mapa = new Mapa(modelo.getRutaArchivo());

            gridPane.add(mapa,0,1);
            gridPane.setAlignment(Pos.CENTER);
            this.scene = new Scene(gridPane, 1000, 800);
        } catch (ArchivoNoEncontrado e) {

        }
    }
    public Scene obtenerEscena() {
        return this.scene;
    }

}
