package Vista;

import Datos.MensajesUsuario;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JuegoVista {
    private VBox box = new VBox();
    public void renderizarJuego () {

        MensajesUsuario m = new MensajesUsuario();
        this.box.setAlignment(Pos.TOP_CENTER);
        Background background = new Background(new BackgroundFill(Color.valueOf("#202124"), null, null));
        this.box.setBackground(background);
        Scene scene = new Scene(this.box,1600,800);
        Stage stage = new Stage();
        stage.setTitle(m.TituloAplicacion());
        stage.setScene( scene );

        stage.show();
    }

    public void agregarVista (GridPane grid) {
        this.box.getChildren().add(grid);
    }

}
