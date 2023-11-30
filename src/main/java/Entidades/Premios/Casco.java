package Entidades.Premios;

import Entidades.Energia.Energia;

import java.util.Arrays;

public class Casco extends Equipo {

    public Casco () {
        this.jerarquia = JerarquiaEquipos.CASCO;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-15);
    }

    @Override
    public Equipo mejorar() {
        return new Armadura();
    }
}