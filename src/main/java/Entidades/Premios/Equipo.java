package Entidades.Premios;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public abstract class Equipo implements Premio {
    protected JerarquiaEquipos jerarquia;
    protected Energia energiaQueAbsorbe;

    public abstract Equipo mejorar();

    public Energia recibirDanio(Energia energia){
        energia.afectarEnergia(this.energiaQueAbsorbe);
        return energia;
    }

    public boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }

    @Override
    public boolean soyJugador() {
        return false;
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }
}