package Entidades.Premios;

import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipo {
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
    }

    @Override
    public void recibirDanio(Energia energia) {
        energia.afectarEnergia(new Energia(-2));
    }

    @Override
    public Equipo mejorar() {
        return new Llave();
    }

    @Override
    public String descripcion() {
        return "Escudo y Espada";
    }
}