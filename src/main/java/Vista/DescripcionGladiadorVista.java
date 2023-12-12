package Vista;

import Entidades.Jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DescripcionGladiadorVista extends GridPane {
    Jugador gladiador;
    public DescripcionGladiadorVista(Jugador gladiador) {
        this.gladiador = gladiador;
        String descripcion = gladiador.miDescripcion();

        String regex = "Nombre: (.*?) Seniority: (.*?) Equipamiento: (.*?) Energia: (\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(descripcion);


        matcher.find();
        String nombre = matcher.group(1);
        String seniority = matcher.group(2);
        String equipo = matcher.group(3);
        int energia = Integer.parseInt(matcher.group(4));


        this.add(new Label("TENEMOS UN GANADOR"), 0, 0);

        this.add(new Label("Nombre"), 2, 1);
        this.add(new Label(nombre), 3, 1);

        this.add(new Label("Seniority"), 2, 2);
        this.add(new Label(seniority), 3, 2);

        this.add(new Label("Equipamiento"), 2, 3);
        this.add(new Label(equipo), 3, 3);

        this.add(new Label("Energia"), 2, 4);
        this.add(new Label(Integer.toString(energia)), 3, 4);

        for (Node node : this.getChildren()){
            if (node instanceof Label){
                ((Label) node).setTextFill(Color.WHITE);
            }
        }


        this.setHgap(10);
        this.setVgap(10);

        this.setPadding(new Insets(10, 10, 10, 10));

        this.setStyle("-fx-background-color: grey;");

        /*

        Label n = new Label("Nombre: " + nombre);
        Label s = new Label("Seniority: " + seniority);
        Label eq = new Label("Equipamiento: " + equipo);
        Label e = new Label("Equipamiento: " + energia);

        this.getChildren().add(n);
        this.getChildren().add(s);
        this.getChildren().add(eq);
        this.getChildren().add(e);

         */

        //this.setPadding(new Insets(10));

        //return this;
    }
}
