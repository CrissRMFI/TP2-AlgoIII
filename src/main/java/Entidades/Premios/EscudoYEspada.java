package Entidades.Premios;

import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipamiento{
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
        this.energiaQueAbsorbe = new Energia(18);
    }

    @Override
    public Equipamiento mejorar() {
        return new Llave();
    }

    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();
    }
}