package parseador;

import java.util.LinkedList;

public class Camino {
    private LinkedList<Celda> celdas = new LinkedList<>();

    public void setCeldas(LinkedList<Celda> celdas) {
        this.celdas = celdas;
    }

    public LinkedList<Celda> getCeldas() {
        return celdas;
    }
}


