package Entidades.Premios;

import Entidades.Energia.Energia;

public class Llave extends Equipo {

    public Llave () {
        this.jerarquia = JerarquiaEquipos.LLAVE;
    }
   @Override
    public Energia energiaAReducir() {
        return new Energia(0);
    }

    @Override
    public Equipo mejorar() {
        return this;
    }
}