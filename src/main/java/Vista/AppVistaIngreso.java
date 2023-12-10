package Vista;

import Componentes.*;
import Entidades.Errores.*;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
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
                    if (!nombre.equals("")) {
                        Jugador jugador = new Gladiador(nombre);
                        Componentes.Jugador jugadorVista = this.getJugador(i,jugador);
                        modelo.agregarJugador(jugadorVista);
                    };
                } catch (Exception error) {

                }
            }
            controlador.iniciarJuego(modelo);
        });
        escena = new Scene(this, 800, 700);
    }

    private Componentes.Jugador getJugador(int i,Jugador jugador) {
        switch (i) {
            case 1 : return new GladiadorUno(jugador);
            case 2 : return new GladiadorDos(jugador);
            case 3 : return new GladiadorTres(jugador);
            case 4 : return new GladiadorCuatro(jugador);
            case 5 : return new GladiadorCinco(jugador);
            case 6 : return new GladiadorSeis(jugador);
            default: return null;
        }
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
