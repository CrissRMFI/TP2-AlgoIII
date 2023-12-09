package Parseador;

import Componentes.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Celda {
    private int x;
    private int y;
    private String tipo;
    private String obstaculo;
    private String premio;


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setObstaculo(String obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}

    public HBox getObstaculo () {
        if (this.obstaculo.equals("Lesion")) return new Lesion();
        if (this.obstaculo.equals("Fiera")) return new Fiera();
        if (this.obstaculo.equals("Bacanal")) return new Bacanal();
        return new SinElemento();
    }

    public HBox getPremio () {
        if (this.premio.equals("Comida")) return new Comida();
        if (this.premio.equals("Equipamiento")) return new Equipamiento();
        return new SinElemento();
    }
}
