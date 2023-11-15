package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Casco extends DecoradorEquipo {
    private Energia energia;

    public void Casco() {
        this.energia = new Energia(-15);
    }
}
