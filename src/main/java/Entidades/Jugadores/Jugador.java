package Entidades.Jugadores;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.CasilleroMapa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador {
    protected SistemaDefensa sistemaDefensa;
    protected Energia energia;
    protected Posicion posicion;
    protected Turno turno;
    protected AlgoRoma algoRoma;
    protected CasilleroMapa casilleroMapa;
    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public void defenderse() {
        this.sistemaDefensa.recibirDanio(this.energia);
    }
    public void equipar(Equipo equipo) {
        this.sistemaDefensa.modificarEquipo(equipo);
    }
    public  void posicionar (Posicion posicion) {
        this.posicion = posicion;
    }
    public abstract void moverse(DispositivoDeAzar dispositivoDeAzar, Tablero tablero);
    public abstract void finalizarTurno ();
    public abstract void perderTurnos ();
    public Energia getSalud() {
        return this.energia;
    }

    public Posicion miPosicion () {
        return this.posicion;
    }
    public boolean comprarEquipo (Equipamiento equipamiento) {
        return this.sistemaDefensa.comparar(equipamiento);
    }

    public void habilitar () {
        this.turno.habilitar();
    }

}