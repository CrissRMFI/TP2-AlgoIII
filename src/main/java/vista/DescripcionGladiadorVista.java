package vista;

import entidades.jugadores.Jugador;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DescripcionGladiadorVista extends VBox {
    public VBox descripcion(Jugador gladiador) {
        String descripcion = gladiador.miDescripcion();

        String regex = "Nombre: (.*?) Seniority: (.*?) Equipamiento: (.*?) Energia: (\\d+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(descripcion);


        matcher.find();
        String nombre = matcher.group(1);
        String seniority = matcher.group(2);
        String equipo = matcher.group(3);
        int energia = Integer.parseInt(matcher.group(4));

        Label n = new Label("Nombre: " + nombre);
        Label s = new Label("Seniority: " + seniority);
        Label eq = new Label("Equipamiento: " + equipo);
        Label e = new Label("Energia: " + energia);

        this.getChildren().add(n);
        this.getChildren().add(s);
        this.getChildren().add(eq);
        this.getChildren().add(e);

        this.setPadding(new Insets(10));

        return this;
    }
}
