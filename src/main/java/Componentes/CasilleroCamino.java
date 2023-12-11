package Componentes;
import Entidades.Tablero.Casillero;
import javafx.animation.FadeTransition;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class CasilleroCamino extends GridPane {

    private int pos;
    private Casillero casillero;
    public CasilleroCamino(Casillero casillero) {
        this.casillero = casillero;
        this.setMinWidth(68);
        this.setMinHeight(68);
        this.setStyle("-fx-background-color: beige;-fx-border-color: black; -fx-border-width: 2;");

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);

    }
    public void agregar(Node elemento) {
        this.pos++;

        StackPane stackPane = new StackPane(elemento);

        this.add(stackPane, 0, pos);

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), stackPane);
        fadeTransition.setToValue(1.0);
        fadeTransition.setFromValue(0.0);
        fadeTransition.play();
    }


    public void remover(Jugador elemento) {
        for (int i = 0; i < this.getChildren().size(); i++) {
            try {
                Jugador jugadorARemover = (Jugador) this.getChildren().get(i);
                if (elemento.comparar(jugadorARemover)) {
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), jugadorARemover);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.setOnFinished(event -> {
                        this.getChildren().remove(jugadorARemover);
                        this.pos--;
                    });
                    fadeTransition.play();


                }
            } catch (ClassCastException er) {

            }
        }
    }

    public boolean comparar (Casillero casillero) {
        return this.casillero.comparar(casillero);
    }
}
