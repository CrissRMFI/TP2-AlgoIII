package modelo.premios;

import modelo.energia.Energia;

public class Llave extends Equipo {

    public Llave () {
        this.jerarquia = JerarquiaEquipos.LLAVE;
    }

    @Override
    public void recibirDanio(Energia e) {
        e.afectarEnergia(new Energia(0));
    }
    @Override
    public Equipo mejorar() {
        return this;
    }

    @Override
    public boolean sePuedeMejorar() {
       return false;
    }

    @Override
    public String descripcion() {
        return "Llave";
    }
}