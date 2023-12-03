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
    public boolean habilitar () {
        if (!this.energia.tengoEnergia()) {
            this.energia.afectarEnergia(new Energia(5));
            return false;
        }

        this.turno.habilitar();
        return  true;

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