package Entidades.Jugadores;

import Entidades.AlgoRoma;
import Entidades.ElementoMapa;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Sistemas.SistemaTurnos;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

import java.util.Map;

public abstract class Jugador implements SistemaDefensa, SistemaTurnos, JugadorGanador, ElementoMapa {

    protected Energia energia;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Turno turno;
    protected String nombre;
    protected Casillero casillero;
    protected Mapa mapa;


    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }
    public abstract void perderTurnos (Turno turnos);
    @Override
    public void habilitar () {
        this.turno.habilitar();
    }
    @Override
    public boolean estaHabilitado () {
        return this.turno.estaHabilitado();
    }
    @Override
    public void deshabilitar () {
        this.turno.deshabilitar();
    }
    public void agregarDispositivoAzar (DispositivoDeAzar dispositivoDeAzar) {
        this.dispositivoDeAzar = dispositivoDeAzar;
    }
    public ValorAzar lanzar () {
        return this.dispositivoDeAzar.lanzar();
    }


    @Override
    public String yoSoy() {
        return this.nombre;
    }

    public void posicionar(Casillero casillero) {
        this.casillero = casillero;
    }

    public void ingresar (Mapa mapa) {
        this.mapa = mapa;
        this.mapa.ubicarEnInicio(this);
    }

    public boolean estoyEnLaMeta () {
        return this.casillero.soyMeta();
    }

    @Override
    public boolean soyJugador() {
        return true;
    }

    public abstract void moverse();

    public boolean compararPosicion (Casillero casillero) {
        return this.casillero.equals(casillero);
    }


    public abstract void finalizarTurno (AlgoRoma algoRoma);
}