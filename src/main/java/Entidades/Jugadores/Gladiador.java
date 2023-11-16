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

    public  Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.equipo = new EquipoBase();
        this.turno = new Turno();
        this.posicion = new Posicion(0,0);
    }

    public int getSalud ()  {
        return this.energia.getEnergia();
    }
    @Override
    public void accionar(Gladiador gladiador) {
        this.turno.deshabilitar();
    }

    public void posicionar (Posicion posicion) {
        this.posicion = this.posicion.cambiarPosicion(posicion);
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    };

    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    };

    public void obtenerElementos (Tablero tablero) {
        Casillero casillero = tablero.obtenerCasillero(this.posicion);
        casillero.entregarElementos(this);
    }

    // TODO: Hay que crear un error que se mande cuando quiera mover y no es mi turno
    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar) {
        if (this.turno.estaHabilitado()) {
            ValorAzar valor = dispositivoDeAzar.lanzar();
            Posicion posicion = tablero.calcularPosicion(valor);
            tablero.moverJugador(this, posicion);
        }
    };

    public void defenderse () {
        this.equipo.recibirDanio(this);
    }

    public void equipar(Equipo equipo) {
        this.equipo = equipo;
    }

    public void finalizarTurno () {
        this.turno.sumarTurno();
        this.seniority.ascenderSeniority(this.turno);
        this.turno.deshabilitar();
    };
}

