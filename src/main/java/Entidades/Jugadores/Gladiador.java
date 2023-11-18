package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Equipo.EquipoBase;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador implements Jugador {
    private Seniority seniority;
    private Equipo equipo;
    private final Turno turno;
    private final Energia energia;
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
    public void accionar(Jugador jugador) {
        this.turno.habilitar();
    }

    private void posicionar (Posicion posicion) {
        this.posicion = posicion;
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    }

    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }

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
    }

    public void defenderse () {
        this.equipo.recibirDanio(this);
    }

    public void equipar(Equipo equipo) {
        if (this.equipo.esEquipoSuperador(equipo)) {
            this.equipo = equipo;
        }
    }

    public void finalizarTurno () {
        this.turno.sumarTurno();
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();
        this.turno.deshabilitar();

    }

    @Override
    public void iniciarTurno() {
        if (this.energia.tengoEnergia()) {
            this.turno.habilitar();
        }
    }
}


