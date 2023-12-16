package componentes;

import componentes.elementos.BacanalVista;
import componentes.elementos.ComidaVista;
import componentes.elementos.FieraVista;
import componentes.elementos.LesionVista;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BarraObjetos extends GridPane {
    public BarraObjetos() {

        ComidaVista comidaVista = new ComidaVista();
        Label text = new Label("COMIDA");
        text.setTextFill(Color.WHITE);

        comidaVista.setScaleX(2);
        comidaVista.setScaleY(2);
        this.add(comidaVista, 0, 0);
        this.add(text, 1, 0);

        EquipamientoVista equipamientoVista = new EquipamientoVista();
        text = new Label("EQUIPAMIENTO");
        text.setTextFill(Color.WHITE);
        equipamientoVista.setScaleX(1.5);
        equipamientoVista.setScaleY(1.5);
        this.add(equipamientoVista, 2, 0);
        this.add(text, 3, 0);

        BacanalVista bacanalVista = new BacanalVista();
        text = new Label("BACANAL");
        text.setTextFill(Color.WHITE);
        bacanalVista.setScaleX(1.5);
        bacanalVista.setScaleY(1.5);
        this.add(bacanalVista, 4, 0);
        this.add(text, 5, 0);

        FieraVista fieraVista = new FieraVista();
        text = new Label("FIERA SALVAJE");
        text.setTextFill(Color.WHITE);
        fieraVista.setScaleX(1.5);
        fieraVista.setScaleY(1.5);
        this.add(fieraVista, 6, 0);
        this.add(text, 7, 0);

        LesionVista lesionVista = new LesionVista();
        text = new Label("PIEDRA");
        text.setTextFill(Color.WHITE);
        lesionVista.setScaleX(1.5);
        lesionVista.setScaleY(1.5);
        this.add(lesionVista, 8, 0);
        this.add(text, 9, 0);

        this.setPadding(new Insets(20));
        Insets padding = new Insets(20);
        GridPane.setMargin(fieraVista, padding);
        GridPane.setMargin(bacanalVista, padding);
        GridPane.setMargin(lesionVista, padding);

        GridPane.setMargin(equipamientoVista, padding);
        GridPane.setMargin(comidaVista, padding);


        this.setAlignment(Pos.BASELINE_CENTER);

    }
}
