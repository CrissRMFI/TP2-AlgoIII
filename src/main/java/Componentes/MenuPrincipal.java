package Componentes;

import Entidades.AlgoRoma;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Vista.Titulo;
import edu.fiuba.algo3.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MenuPrincipal extends BorderPane {
    private Image background;

    public MenuPrincipal(App controlador)  {
        super();


        this.imagenDeFondo();

        Button ingresar = new BotonIngresar("INGRESAR");
        Button salir = new BotonSalir("SALIR");
        Titulo titulo = new Titulo("A L G O R O M A");
        VBox botonesLayout = new VBox(ingresar, salir);

        ingresar.setOnAction(e -> {controlador.mostrarVentanaIngreso();
        });
        salir.setOnAction(e -> controlador.salirDeEscena());

        setAlignment(titulo, Pos.CENTER);
        setTop(titulo);

        // centra los botones
        botonesLayout.setPadding(new Insets(15, 15, 15, 15));
        botonesLayout.setAlignment(Pos.CENTER);
        botonesLayout.setSpacing(20);
        setCenter(botonesLayout);
    }

    private void imagenDeFondo() {
        this.background = new Image("file:src/main/java/Vista/Imagenes/roma.png");

        BackgroundImage backgroundImage = new BackgroundImage(this.background,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(backgroundImage));
    }
}
