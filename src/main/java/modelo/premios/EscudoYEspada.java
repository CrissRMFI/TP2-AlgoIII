package modelo.premios;

import modelo.energia.Energia;

public class EscudoYEspada extends Equipo {
    public EscudoYEspada () {
        this.jerarquia = JerarquiaEquipos.ESCUDO_Y_ESPADA;
    }

    @Override
    public void recibirDanio(Energia e) {
        e.afectarEnergia(new Energia(-2));
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