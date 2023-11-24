package Entidades.Equipo;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public abstract class Equipo implements Interactuable {
    protected Equipamiento tipoEquipo;
    protected boolean interacturo = false;
    @Override
    public void interactuar(Jugador jugador) {
        jugador.modificarEquipo(this);
    }
    public abstract Energia energiaAReducir();
    public boolean puedoEquipar(Equipo equipo) {
        return equipo.tipoEquipo.ordinal() == this.tipoEquipo.ordinal() + 1;
    }

    @Override
    public boolean esPremio() {
        return true;
    }

    @Override
    public boolean interactuo() {
        return this.interacturo;
    }

    public void equipoEsEquipado () {
        this.interacturo = true;
    }

    public boolean comparar (Equipamiento equipamiento) {
        return this.tipoEquipo == equipamiento;
    }
}