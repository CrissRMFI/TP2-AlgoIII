package Entidades.Equipo;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public abstract class Equipo implements Interactuable {
    protected Equipamiento tipoEquipo;

    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar(this);
    }
    public abstract Energia energiaAReducir();
    public boolean esEquipoSuperador (Equipo equipo) {
        return this.tipoEquipo.ordinal() < equipo.tipoEquipo.ordinal();
    }
}