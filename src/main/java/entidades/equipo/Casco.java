package entidades.equipo;

import entidades.energia.Energia;

public class Casco extends Equipo {

    public Casco() {
        this.jerarquia = JerarquiaEquipos.CASCO;
    }

    @Override
    public void recibirDanio(Energia energia) {
        energia.afectarEnergia(new Energia(-15));
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