package Entidades.Premios;

import Entidades.Energia.Energia;

import java.util.Arrays;

public class Casco extends Equipo {

    public Casco () {
        this.jerarquia = JerarquiaEquipos.CASCO;
    }

    @Override
    public void recibirDanio(Energia e) {
        e.afectarEnergia(new Energia(-15));
    }

    @Override
    public Equipo mejorar() {
        return new Armadura();
    }

    @Override
    public String descripcion() {
        return "Casco";
    }
}