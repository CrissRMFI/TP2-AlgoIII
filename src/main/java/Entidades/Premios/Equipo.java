package Entidades.Premios;

import Entidades.Energia.Energia;

public abstract class Equipo {
    protected JerarquiaEquipos jerarquia;
    protected Energia energiaQueAbsorbe;


    public abstract Equipo mejorar();

    public Energia recibirDanio(Energia energia){
        energia.afectarEnergia(this.energiaQueAbsorbe);
        return energia;
    }

    public boolean esEquipoMaximo(){
        return this.jerarquia.equals(JerarquiaEquipos.LLAVE);
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}