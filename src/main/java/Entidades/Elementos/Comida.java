package Entidades.Elementos;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Comida implements Objetos {
    private Energia energia;


    public void Comida () {
        this.energia = new Energia(15);
    }

    @Override
    public void accionar(Jugador jugador) {
        jugador.afectarEnergia(this.energia);
    }
}
