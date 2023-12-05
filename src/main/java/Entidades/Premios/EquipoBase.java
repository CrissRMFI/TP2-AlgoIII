package Entidades.Premios;

import Entidades.Energia.Energia;

public class EquipoBase extends Equipo {

    public EquipoBase () {
        this.jerarquia = JerarquiaEquipos.EQUIPO_BASE;
    }

    @Override
    public void recibirDanio(Energia energia) {
        energia.afectarEnergia(new Energia(-20));
    }

    @Override
    public Equipo mejorar() {
        return new Casco();
    }

    @Override
    public String descripcion() {
        return "Equipo Base";
    }
}
