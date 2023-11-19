package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador {
    protected SistemaDefensa sistemaDefensa;
    protected Energia energia;
    protected Posicion posicion;
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
    public abstract void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    public abstract void finalizarTurno ();
    public abstract void obtenerElementos (Tablero tablero);
    public abstract  void iniciarTurno ();
    public abstract void perderTurnos ();
    public abstract int getSalud(); // TODO: lUEGO BORRAR ESTO, ES UN HACK PARA PRUEBAS
}
