package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Equipo.Equipo;
import Entidades.Energia.Energia;
import Entidades.Equipo.DefensaGladiador;
import Entidades.Equipo.EquipoBase;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

import java.util.Collection;

public class Gladiador extends Jugador {
    private Seniority seniority;
    private final Turno turno;

    public  Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.turno = new Turno();
        this.sistemaDefensa = new DefensaGladiador(new EquipoBase());
    }

    /*
    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    }

     */

    public void obtenerElementos (Tablero tablero) {
        if (this.turno.estaHabilitado()) {
            Casillero casillero = tablero.obtenerCasillero(this.posicion);
            casillero.entregarElementos(this);
        }
    }

    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar) {
        ValorAzar valor = dispositivoDeAzar.lanzar();
        Posicion posicion = tablero.calcularPosicion(valor);
        this.posicion.cambiarPosicion(posicion);
    }

    /*
    public void perderTurnos () {
        this.turno.perderUnTurno();
    }

     */

    /*
    public void finalizarTurno () {
        this.turno.finalizar();
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();
    }

     */

    @Override
    public void jugarTurno(Tablero tablero, DispositivoDeAzar dispositivoDeAzar) {
        this.seniority.aumentarEnergia(this.energia);
        if ((this.energia.cantidadDeEnergia() > 0 )|| this.turno.estaHabilitado()) {
            this.moverse(tablero, dispositivoDeAzar);
            tablero.obtenerCasillero(this.posicion).entregarElementos(this);
        } else if (this.energia.cantidadDeEnergia() <= 0) {
            this.energia.afectarEnergia(5);
        }
        this.turno.agregarTurnoJugado();
        this.seniority.ascenderSeniority(this.turno);
    }
}

