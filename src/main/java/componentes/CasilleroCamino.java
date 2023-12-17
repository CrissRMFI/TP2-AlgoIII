package componentes;

import entidades.tablero.Casillero;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class CasilleroCamino extends GridPane {

    private int pos;
    private Casillero casillero;

    public CasilleroCamino(Casillero casillero, int tamanio) {
        this.casillero = casillero;
        this.setMinSize(tamanio, tamanio);
        this.setPrefSize(tamanio, tamanio);
        this.setMaxSize(tamanio, tamanio);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(20);
        this.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(20);
        this.getRowConstraints().add(rowConstraints);

        this.setStyle("-fx-background-color: beige;-fx-border-color: black; -fx-border-width: 2;");

        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(1.0);
        lighting.setSpecularConstant(0.5);
        lighting.setSpecularExponent(10.0);
        lighting.setSurfaceScale(5.0);

        this.setEffect(lighting);
        this.setAlignment(Pos.CENTER);

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


    public void remover(JugadorVista elemento) {
        for (int i = 0; i < this.getChildren().size(); i++) {
            try {
                JugadorVista jugadorVistaARemover = (JugadorVista) this.getChildren().get(i);
                if (elemento.equals(jugadorVistaARemover)) {
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), jugadorVistaARemover);
                    fadeTransition.setToValue(0.0);
                    fadeTransition.setOnFinished(event -> {
                        this.getChildren().remove(jugadorVistaARemover);
                        this.pos--;
                    });
                    fadeTransition.play();
                }
            } catch (ClassCastException er) {

            }
        }
    }

    public boolean comparar(Casillero casillero) {
        return this.casillero.esIgualQue(casillero);
    }
}
