package Vista;

import Componentes.BotonIniciarJuego;
import Componentes.InputNombre;
import Componentes.SeleccionMapa;
import Entidades.Errores.*;
import Entidades.Jugadores.Gladiador;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class AppVistaIngreso extends GridPane{
    private App controlador;
    private AppModelo modelo;
    private Scene escena;

    public AppVistaIngreso(App controlador, AppModelo modelo) {
        this.controlador = controlador;
        this.modelo = modelo;
        this.imagenDeFondo();


        Button iniciar = new BotonIniciarJuego("INICIAR JUEGO");

        TextField input1 = new InputNombre();

        TextField input2 = new InputNombre();

        TextField input3 = new InputNombre();

        TextField input4 = new InputNombre();

        TextField input5 = new InputNombre();

        TextField input6 = new InputNombre();


        SeleccionMapa selectMapa = new SeleccionMapa(this.modelo);

        this.addRow(0,selectMapa);

        this.addRow(2,input1);
        this.addRow(3,input2);
        this.addRow(4,input3);
        this.addRow(5,input4);
        this.addRow(6,input5);
        this.addRow(7,input6);
        this.addRow(10,iniciar);

        this.setPadding(new Insets(10,0,10,0));
        this.setAlignment(Pos.CENTER);
        this.setVgap(10);

        iniciar.setOnAction(e -> {
            for (int i=0;i<this.getChildren().size();i++) {
                try {
                    TextField text = (TextField) this.getChildren().get(i);
                    String nombre = text.getText();
                    if (!nombre.equals("")) modelo.agregarJugador(new Gladiador(text.getText()));
                } catch (Exception error) {

                }
            }
            controlador.iniciarJuego(modelo);
        });
        escena = new Scene(this, 800, 700);
    }

    public Scene obtenerEscena() {
        return this.escena;
    }
    private void imagenDeFondo(){
        Image imagen = new Image("file:src/main/java/Vista/Imagenes/pruebaDeFondo.png");

        BackgroundImage imagenDeFondo = new BackgroundImage(imagen,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));

        this.setBackground(new Background(imagenDeFondo));
    }
}
