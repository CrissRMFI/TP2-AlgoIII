package Entidades.Premios;

import Entidades.Energia.Energia;

public class Llave extends Equipo {

    public Llave () {
        this.jerarquia = JerarquiaEquipos.LLAVE;
        this.energiaQueAbsorbe = new Energia(20);
    }

    @Override
    public Equipo mejorar() {
        return this;
    }

    @Override
    public boolean sePuedeMejorar() {
       return false;
    }
}