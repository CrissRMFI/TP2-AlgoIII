package Entidades.Premios;

import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipo {
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
        this.energiaQueAbsorbe = new Energia(18);
    }

    @Override
    public Equipo mejorar() {
        return new Llave();
    }
}