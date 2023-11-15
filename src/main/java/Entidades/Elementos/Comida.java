package Entidades.Elementos;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Comida implements Elemento {
    private Energia energia;


    public void Comida () {
        this.energia = new Energia(15);
    }

    @Override
    public void accionar(Gladiador gladiador) {
        gladiador.afectarEnergia(energia);
    }
}
