package Entidades.Elementos;

import Entidades.Energia.Energia;

public class Comida {
    private Energia energia;

    public void Comida () {
        this.energia = new Energia(15);
    }

    public Energia alimentar () {
        return energia;
    }
}
