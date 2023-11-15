package Entidades.Jugadores;
import Entidades.Elementos.*;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Equipo.EquipoBase;
import Entidades.Obstaculos.Obstaculo;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class Gladiador {
    private Seniority seniority;
    private Equipo equipo;
    private Turno turno;
    private Energia energia;

    public void Gladiador () {
        this.energia = new Energia();
        this.seniority = new Novato();
        this.equipo = new EquipoBase();
        this.turno = new Turno();
    }

    private void ascenderSeniority () {
        this.seniority =  this.seniority.ascenderSeniority(this.turno);
    };

    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    };

    public void enfrentarObstaculo (Casillero casillero) {
        Obstaculo obstaculo = casillero.otorgarObstaculo();
        obstaculo.enfrentar(this);
    }

    public void equipar(Equipo equipo) {
        this.equipo = equipo;
    }

    public int jugarTurno (DispositivoDeAzar dispositivo) {
        return dispositivo.lanzar();
    };

    public Casillero moverse(Tablero tablero, Posicion posicion) {
        if (this.turno.estaHabilitado()) {
            return tablero.moverJugador(posicion);
        }
        return null; //TODO ver que hacer con este retorno de tipo de dato, que no retorne NULL
    };

    public void deshabilitar() {
        this.turno.deshabilitar();

    }

    public void finalizarTurno () {
        this.turno.sumarTurno();
        this.seniority.ascenderSeniority(this.turno);
    };
}

