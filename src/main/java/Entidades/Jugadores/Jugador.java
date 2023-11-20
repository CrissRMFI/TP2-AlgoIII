package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador {
    protected SistemaDefensa sistemaDefensa;
    protected Energia energia;
    protected Posicion posicion;

    public void Jugador(Posicion posicion){
        this.posicion = posicion;
    }

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
    public Energia getSalud() {
        return this.energia;
    }
    public abstract void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    //public abstract void finalizarTurno ();
    public abstract void obtenerElementos (Tablero tablero);
    public abstract  void jugarTurno(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    //public abstract void perderTurnos ();


    /*
    public Equipo miEquipo () {
        return this.sistemaDefensa.miEquipo();
    }
     */
}