package Entidades.Jugadores;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador {
    protected SistemaDefensa sistemaDefensa;
    protected Energia energia;
    protected Posicion posicion;
    protected Casillero casillero;
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
    public abstract  void iniciarTurno ();
    public abstract void perderTurnos ();
    public Energia getSalud() {
        return this.energia;
    }

    public Posicion miPosicion () {
        return this.posicion;
    }
    /*
    public Equipo miEquipo () {
        return this.sistemaDefensa.miEquipo();
    }
     */
}