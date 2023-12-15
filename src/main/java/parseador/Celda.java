package parseador;

import componentes.*;
import componentes.elementos.BacanalVista;
import componentes.elementos.ComidaVista;
import componentes.elementos.FieraVista;
import componentes.elementos.LesionVista;
import javafx.scene.layout.HBox;

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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public HBox getObstaculo() {
        if (this.obstaculo.equals("Lesion")) return new LesionVista();
        if (this.obstaculo.equals("Fiera")) return new FieraVista();
        if (this.obstaculo.equals("Bacanal")) return new BacanalVista();
        return new SinElementoVista();
    }

    public HBox getPremio() {
        if (this.premio.equals("Comida")) return new ComidaVista();
        if (this.premio.equals("Equipamiento")) return new EquipamientoVista();
        return new SinElementoVista();
    }
}
