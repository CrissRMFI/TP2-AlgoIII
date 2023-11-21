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
    protected AlgoRoma algoRoma;
    protected CasilleroMapa casilleroMapa;
    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public void defenderse() {
        if (this.turno.estaHabilitado()) {
            this.sistemaDefensa.recibirDanio(this.energia);
        }

    }
    public void equipar(Equipo equipo) {
        this.sistemaDefensa.modificarEquipo(equipo);
    }
    public  void posicionar (Posicion posicion) {
        this.posicion = posicion;
    }
    public abstract void moverse(Tablero tablero) throws SinDispositivoDeAzar;
    public abstract void finalizarTurno ();
    public abstract void perderTurnos ();
    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }

    public Posicion miPosicion () {
        return this.posicion;
    }
    public boolean comprarEquipo (Equipamiento equipamiento) {
        return this.sistemaDefensa.comparar(equipamiento);
    }

    public void habilitar () {
        this.turno.habilitar();
    }

    public void agregarDispositivoAzar (DispositivoDeAzar dispositivoDeAzar) {
        this.dispositivoDeAzar = dispositivoDeAzar;
    }

    public ValorAzar lanzar () throws SinDispositivoDeAzar {
        if (this.dispositivoDeAzar == null) {
            throw new SinDispositivoDeAzar(new Mensajes().SinDispositivoDeAzar());
        }
        return this.dispositivoDeAzar.lanzar();
    }



}