package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.EquipoBase;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador extends Jugador {
    private Seniority seniority;
    public  Gladiador (String nombre) {
        this.nombre = nombre;
        this.energia = new Energia();
        this.seniority = new Novato();
        this.turno = new Turno();
        this.equipo = new EquipoBase();
        this.dispositivoDeAzar = new Dado();
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    }


    @Override
    public void moverse(Tablero tablero) {

        if (this.estaHabilitado() && this.energia.tengoEnergia()) {
            ValorAzar valorAzar = this.dispositivoDeAzar.lanzar();
            Posicion posicion = tablero.calcularPosicion(valorAzar);
            this.posicion.cambiarPosicion(posicion);

        }

        if (!this.energia.tengoEnergia()) {
            this.energia.afectarEnergia(new Energia(5));
            this.deshabilitar();
        }
    }
    @Override
    public void perderTurnos (Turno turnos) {
        if (this.turno.estaHabilitado()) {
            this.turno.perderTurnos(turnos);
        }

    }
    @Override
    public void finalizarTurno () {
        this.turno.finalizar();
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();

    }

    @Override
    public void recibirDanio(Energia energia) {
        if (this.turno.estaHabilitado()) {
            this.energia.afectarEnergia(energia);
        }
    }

    @Override
    public void defenderse() {
        if (this.turno.estaHabilitado()) {
            Energia energia = this.equipo.energiaAReducir();
            this.energia.afectarEnergia(energia);
        }
    }
}

