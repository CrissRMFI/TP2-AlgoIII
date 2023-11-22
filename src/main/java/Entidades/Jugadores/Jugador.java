package Entidades.Jugadores;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Errores.Mensajes;
import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.CasilleroMapa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador {
    protected SistemaDefensa sistemaDefensa;
    protected Energia energia;
    protected Posicion posicion;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Turno turno;
    protected String nombre;
    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public void defenderse() {
        if (this.turno.estaHabilitado()) {
            this.sistemaDefensa.recibirDanio(this.energia);
        }
    }

    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }

    public boolean comprarEquipo (Equipamiento equipamiento) {
        return this.sistemaDefensa.comparar(equipamiento);
    }

    public void equipar(Equipo equipo) {
        this.sistemaDefensa.modificarEquipo(equipo);
    }

    public  void posicionar (Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void moverse(Tablero tablero);

    public abstract void finalizarTurno ();

    public abstract void perderTurnos ();

    public Posicion miPosicion () {
        return this.posicion;
    }

    public void habilitar () {
        this.turno.habilitar();
    }

    public void agregarDispositivoAzar (DispositivoDeAzar dispositivoDeAzar) {
        this.dispositivoDeAzar = dispositivoDeAzar;
    }

    public ValorAzar lanzar () {
        return this.dispositivoDeAzar.lanzar();
    }



}