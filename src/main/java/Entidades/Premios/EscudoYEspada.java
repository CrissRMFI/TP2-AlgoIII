package Entidades.Premios;

import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipo {
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-2);
    }

    @Override
    public Equipo mejorar() {
        return new Llave();
    }

    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();

    }
}