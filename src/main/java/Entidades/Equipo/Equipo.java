package Entidades.Equipo;

import Entidades.Elementos.Objetos;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public abstract class Equipo implements Objetos {
    protected Equipamiento tipoEquipo;

    public void accionar(Jugador jugador) {
        jugador.equipar(this);
    }
    public void recibirDanio(Jugador jugador) {
        jugador.afectarEnergia(this.energiaAReducir());
    }
    protected abstract Energia energiaAReducir();
    public boolean esEquipoSuperador (Equipo equipo) {
        return this.tipoEquipo.ordinal() < equipo.tipoEquipo.ordinal();
    }
}