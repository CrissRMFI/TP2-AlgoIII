package Entidades.Tablero;

import Entidades.Elementos.Comida;
import Entidades.Obstaculos.Obstaculo;

import java.util.List;
import java.util.ArrayList;

public class Casillero {
    private List<Comida> comida;
    private Obstaculo obstaculo;

    public Casillero() {
        this.comida = new ArrayList<>();
    }
    public Comida otorgarComida () {
        return comida.get(0);
    }

    public Obstaculo otorgarObstaculo () {
        return obstaculo;
    }
}

