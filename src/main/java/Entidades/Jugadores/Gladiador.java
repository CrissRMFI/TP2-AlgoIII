package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.DefensaGladiador;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.EquipoBase;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador extends Jugador {
    private Seniority seniority;
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

}

