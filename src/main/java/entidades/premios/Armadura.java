package entidades.premios;

import entidades.energia.Energia;

public class Armadura extends Equipo {

    public Armadura() {
        this.jerarquia = JerarquiaEquipos.ARMADURA;
    }

    @Override
    public void recibirDanio(Energia energia) {
        energia.afectarEnergia(new Energia(-10));
    }

    @Override
    public Equipo mejorar() {
        return new EscudoYEspada();
    }

    @Override
    public String descripcion() {
        return "Armadura";
    }
}