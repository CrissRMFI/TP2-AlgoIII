package Componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BarraObjetos extends HBox {
    public BarraObjetos () {

        VBox vBox = new VBox();
        //vBox.getChildren().add(0,new Comida());
        vBox.getChildren().add(0,new Label("COMIDA"));
        vBox.getChildren().add(1,new Comida());

        this.getChildren().add(vBox);

        vBox = new VBox();
        vBox.getChildren().add(0,new Equipamiento());
        vBox.getChildren().add(1,new Label("EQUIPAMIENTO"));

        this.getChildren().add(vBox);

        vBox = new VBox();
        vBox.getChildren().add(0,new Bacanal());
        vBox.getChildren().add(1,new Label("BACANAL"));

        this.getChildren().add(vBox);

        vBox = new VBox();
        vBox.getChildren().add(0,new Fiera());
        vBox.getChildren().add(1,new Label("FIERA"));

        this.getChildren().add(vBox);

        vBox = new VBox();
        vBox.getChildren().add(0,new Lesion());
        vBox.getChildren().add(1,new Label("LESION"));

        this.getChildren().add(vBox);

        this.setPadding(new Insets(10,10,10,10));

        this.setMinHeight(50);
        this.setAlignment(Pos.TOP_CENTER);

    }
}
