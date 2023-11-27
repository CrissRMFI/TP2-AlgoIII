package Entidades.Premios;

import Entidades.Energia.Energia;

public class Llave extends Equipamiento {

    public Llave () {
        this.jerarquia = JerarquiaEquipos.LLAVE;
        this.energiaQueAbsorbe = new Energia(20);
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