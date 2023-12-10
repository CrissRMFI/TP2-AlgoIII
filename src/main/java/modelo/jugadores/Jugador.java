package modelo.jugadores;

import modelo.AlgoRoma;
import modelo.elementos.Dado;
import modelo.elementos.DispositivoDeAzar;
import modelo.energia.Energia;
import modelo.sistemas.SistemaDefensa;
import modelo.tablero.Casillero;
import modelo.tablero.Mapa;

public abstract class Jugador implements SistemaDefensa, JugadorGanador {

    protected Energia energia;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Estado estado;
    protected String nombre;
    protected Casillero casillero;
    protected int turnos;

    public Jugador(String nombre, DispositivoDeAzar dispositivoDeAzar) {
        this.nombre = nombre;
        this.energia = new Energia();
        this.estado = new Habilitado(this);
        this.dispositivoDeAzar = dispositivoDeAzar;
        this.turnos = 0;
    }


    public void afectarEnergia(Energia energia) {
        this.energia.afectarEnergia(energia);
    }

    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }

    public void agregarDispositivoAzar(DispositivoDeAzar dispositivoDeAzar) {
        this.dispositivoDeAzar = dispositivoDeAzar;
    }

    public int lanzar() {
        return this.dispositivoDeAzar.lanzar();
    }

    @Override
    public String yoSoy() {
        return this.nombre;
    }

    public void posicionar(Casillero casillero) {
        this.casillero = casillero;
    }


    public boolean compararPosicion(Casillero casillero) {
        return this.casillero.equals(casillero);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        this.estado.setJugador(this);
    }

    public boolean tengoEnergia() {
        return this.energia.tengoEnergia();
    }

    //public abstract void finalizarTurno(AlgoRoma algoRoma);

    public abstract String miDescripcion();

    /*
    public abstract void obtenerElementos();
*/
    public abstract void moverse(Mapa mapa);
}