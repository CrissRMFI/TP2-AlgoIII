package Vista;

import Datos.MensajesUsuario;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JuegoVista {
    private VBox box = new VBox();
    public void renderizarJuego () {

        MensajesUsuario m = new MensajesUsuario();
        this.box.setAlignment(Pos.CENTER);
        Scene scene = new Scene(this.box,1600,800);
        Stage stage = new Stage();
        stage.setTitle(m.TituloAplicacion());
        stage.setScene( scene );

        stage.show();
    }

    public void agregarVista (GridPane grid) {
        box.getChildren().add(grid);
    }


}
