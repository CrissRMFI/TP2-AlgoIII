package Entidades.Premios;

import Entidades.Energia.Energia;

public class Armadura extends Equipo {

    public Armadura () {
        this.jerarquia = JerarquiaEquipos.ARMADURA;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-10);
    }

    @Override
    public Equipo mejorar() {
        return new EscudoYEspada();
    }
    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();

    }
}