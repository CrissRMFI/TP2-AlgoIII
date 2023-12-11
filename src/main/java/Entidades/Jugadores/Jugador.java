package Entidades.Jugadores;


import Entidades.Elementos.Dado;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Energia.Energia;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

public abstract class Jugador implements SistemaDefensa, JugadorGanador {

    protected Energia energia;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Estado estado;
    protected String nombre;
    protected Casillero casillero;
    protected int turnos;

    public Jugador(String nombre) { // TODO: directamente pasarle el dispositivo de azar
        this.nombre = nombre;
        this.energia = new Energia();
        this.estado = new Habilitado(this);
        this.turnos = 0;
        this.dispositivoDeAzar = new Dado();
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

    public Casillero miPosicion() {
        return this.casillero;
    }

    public abstract String miDescripcion();


    public abstract void moverse(Mapa mapa);
}