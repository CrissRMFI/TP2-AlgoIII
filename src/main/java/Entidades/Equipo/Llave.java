package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Llave extends Equipamiento {

    public Llave () {
        this.jerarquia = JerarquiaEquipos.LLAVE;
    }
   @Override
    public Energia energiaAReducir() {
        return new Energia(0);
    }

    @Override
    public Equipamiento mejorar() {
        return this;
    }

    @Override
    public boolean sePuedeMejorar() {
       return false;

    }
}