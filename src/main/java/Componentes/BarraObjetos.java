package Componentes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BarraObjetos extends GridPane {
    public BarraObjetos () {

        Comida comida = new Comida();
        Label text = new Label("COMIDA");
        text.setTextFill(Color.WHITE);

        comida.setScaleX(2);
        comida.setScaleY(2);
        this.add(comida,0,0);
        this.add(text,1,0);

        Equipamiento equipamiento= new Equipamiento();
        text = new Label("EQUIPAMIENTO");
        text.setTextFill(Color.WHITE);
        equipamiento.setScaleX(1.5);
        equipamiento.setScaleY(1.5);
        this.add(equipamiento,2,0);
        this.add(text,3,0);

        Bacanal bacanal= new Bacanal();
        text = new Label("BACANAL");
        text.setTextFill(Color.WHITE);
        bacanal.setScaleX(1.5);
        bacanal.setScaleY(1.5);
        this.add(bacanal,4,0);
        this.add(text,5,0);

        Fiera fiera= new Fiera();
        text = new Label("FIERA SALVAJE");
        text.setTextFill(Color.WHITE);
        fiera.setScaleX(1.5);
        fiera.setScaleY(1.5);
        this.add(fiera,6,0);
        this.add(text,7,0);

        Lesion lesion = new Lesion();
        text = new Label("PIEDRA");
        text.setTextFill(Color.WHITE);
        lesion.setScaleX(1.5);
        lesion.setScaleY(1.5);
        this.add(lesion,8,0);
        this.add(text,9,0);

        this.setPadding(new Insets(20));
        Insets padding = new Insets(20);
        GridPane.setMargin(fiera, padding);
        GridPane.setMargin(bacanal, padding);
        GridPane.setMargin(lesion, padding);

        GridPane.setMargin(equipamiento, padding);
        GridPane.setMargin(comida, padding);



        this.setAlignment(Pos.BASELINE_CENTER);

    }
}
