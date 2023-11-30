package Entidades.Premios;

import Entidades.Energia.Energia;

public class Armadura extends Equipo {

    public Armadura () {
        this.jerarquia = JerarquiaEquipos.ARMADURA;
        this.energiaQueAbsorbe = new Energia(10);
    }

    @Override
    public Equipo mejorar() {
        return new EscudoYEspada();
    }
}