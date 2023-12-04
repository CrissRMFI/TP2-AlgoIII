package vista;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Titulo extends StackPane {
    public Titulo(String nombre){
        Rectangle rectangulo = new Rectangle(32*nombre.length(), 60);
        rectangulo.setStroke(Color.DARKGOLDENROD);
        rectangulo.setStrokeWidth(3);
        rectangulo.setFill(null);

        Text texto = new Text(nombre);
        texto.setFill(Color.LIGHTGOLDENRODYELLOW);
        texto.setFont(Font.font("Verdana", FontWeight.BOLD, 50));

        setAlignment(Pos.CENTER);
        getChildren().addAll(rectangulo,texto);
    }
}
