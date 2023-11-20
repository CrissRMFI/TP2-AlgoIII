package Entidades.Jugadores;
import Entidades.AlgoRoma;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.DefensaGladiador;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Equipo.EquipoBase;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador extends Jugador {
    private Seniority seniority;
    private final Turno turno;

    public  Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.turno = new Turno();
        this.sistemaDefensa = new DefensaGladiador(new EquipoBase());
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    }

    public void moverse(DispositivoDeAzar dispositivoDeAzar, Tablero tablero) {
        if (this.turno.estaHabilitado()) {
            ValorAzar valorAzar = dispositivoDeAzar.lanzar();
            Posicion posicion = tablero.calcularPosicion(valorAzar);
            this.posicion.cambiarPosicion(posicion);
        } else {
            this.finalizarTurno();
        }
    }

    public void perderTurnos () {
        this.turno.perderUnTurno();
    }

    public void finalizarTurno () {
        this.turno.finalizar();
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();
    }

    @Override
    public void iniciarTurno() {
        if (this.energia.tengoEnergia() || this.turno.estaHabilitado()) {
            this.turno.habilitar();
        }
    }


}

