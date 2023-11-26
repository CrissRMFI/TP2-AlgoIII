package Entidades.Equipo;

import Entidades.Jugadores.Gladiador;
import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipamiento{
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-2);
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