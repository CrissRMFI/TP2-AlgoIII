package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Tablero.Casillero;

public class Gladiador{
    Energia energia = new Energia(20);
    Casillero casillero = new Casillero(0, 0);
    Seniority seniority = new Novato();
    public int getPuntosDeEnergia(){
        return energia.getEnergia();
    }

    public int getPosicionX(){
        return casillero.getX();
    }

    public void jugarTurno(Casillero casillero, int cantidadDeTurnosJugados){
        this.ascenderSeniority(cantidadDeTurnosJugados);
        this.energia.ganarEnergia(this.seniority.plusDeEnergia());
        this.moverse(casillero);
    }

    private void moverse(Casillero casillero){
        this.casillero = casillero;
    }

    private void ascenderSeniority(int cantidadDeTurnosJugados){
        this.seniority = this.seniority.ascenderSeniority(cantidadDeTurnosJugados);
    }

    public void perderEnergia(int cantidadAPerder){
        this.energia.perderEnergia(cantidadAPerder);
    }

    public void ganarEnergia(int cantidadAGanar){
        this.energia.ganarEnergia(cantidadAGanar);
    }
}






/*
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Equipo.EquipoBase;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.PosicionLineal;
import Entidades.Tablero.Tablero;

public class Gladiador implements Jugador {
    private Seniority seniority;
    private Equipo equipo;
    private Turno turno;
    private Energia energia;
    private Posicion posicion;

    public  Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.equipo = new EquipoBase();
        this.turno = new Turno();
    }

    public int getSalud ()  {
        return this.energia.getEnergia();
    } // TODO: Esto se tiene que borrar es un hack para ver pruebas
    @Override
    public void accionar(Gladiador gladiador) {
        this.turno.habilitar();
    }

    private void posicionar (Posicion posicion) {
        this.posicion = posicion;
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    };

    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    };

    public void obtenerElementos (Tablero tablero) {
        if (this.turno.estaHabilitado()) {
            Casillero casillero = tablero.obtenerCasillero(this.posicion);
            casillero.entregarElementos(this);
        }

    }

    // TODO: Hay que crear un error que se mande cuando quiera mover y no es mi turno o no puea mover
    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar) {
        if (this.turno.estaHabilitado()) {
            ValorAzar valor = dispositivoDeAzar.lanzar();
            Posicion posicion = tablero.calcularPosicion(valor);
            this.posicionar(posicion);
        } else {
            this.finalizarTurno();
        }
    };

    public void defenderse () {
        this.equipo.recibirDanio(this);
    }

    public void comer (Energia energia) {
        this.energia.afectarEnergia(energia);
    }

    public void equipar(Equipo equipo) {
        this.equipo = equipo;
    }

    public void finalizarTurno () {
        this.turno.sumarTurno();
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();
        this.turno.deshabilitar();

    };

    @Override
    public void iniciarTurno() {
        if (this.energia.tengoEnergia()) {
            this.turno.habilitar();
        }
    }
}
*/

