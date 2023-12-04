package modelo.premios;

import modelo.energia.Energia;
import modelo.jugadores.Jugador;

public abstract class Equipo implements Premio {
    protected JerarquiaEquipos jerarquia;

    public abstract Equipo mejorar();

    public abstract void recibirDanio(Energia e);

    public boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

    public abstract String descripcion();
}