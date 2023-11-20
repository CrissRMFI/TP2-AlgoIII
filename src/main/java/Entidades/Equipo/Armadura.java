package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Armadura extends Equipo{

    public Armadura () {
        this.tipoEquipo = Equipamiento.ARMADURA;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-15);
    }
}