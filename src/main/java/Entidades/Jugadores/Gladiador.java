package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Equipo.EquipoBase;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador implements Jugador {
    private Seniority seniority;
    private Equipo equipo;
    private Turno turno;
    private Energia energia;

    private Posicion posicion;

    public void Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.equipo = new EquipoBase();
        this.turno = new Turno();
        this.posicion = new Posicion(0,0);
    }

    @Override
    public void accionar(Gladiador gladiador) {
        //TODO: Esto es raro raro raro, ver que hacer luego, metiendo pata para hacer test
    }

    public void posicionar (Posicion posicion) {
        this.posicion.agregarPosicion(posicion);
    }
    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    };

    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    };

    public void obtenerElementos (Casillero casillero) {
        casillero.entregarElementos(this);
    }
    public void equipar(Equipo equipo) {
        this.equipo = equipo;
    }

    public Casillero moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar) {
        ValorAzar valor = dispositivoDeAzar.lanzar();
        Posicion posicion = tablero.calcularPosicion(valor);
        tablero.moverJugador(this,posicion);
        return tablero.obtenerCasillero(posicion);
    };

    public void defenderse () {
        this.equipo.recibirDanio(this);
    }

    public void deshabilitar() {
        this.turno.deshabilitar();

    }

    public void finalizarTurno () {
        this.turno.sumarTurno();
        this.seniority.ascenderSeniority(this.turno);
    };
}

