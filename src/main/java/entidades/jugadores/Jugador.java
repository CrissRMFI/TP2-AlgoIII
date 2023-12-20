package entidades.jugadores;

import entidades.dispositivoDeAzar.Dado;
import entidades.dispositivoDeAzar.DispositivoDeAzar;
import entidades.energia.Energia;
import entidades.errores.NombreDeJugadorConMenosDe4CaracteresExcepcion;
import entidades.sistemaTurnos.Turno;
import entidades.sistemas.SistemaDefensa;
import entidades.tablero.Casillero;
import entidades.tablero.Mapa;

public abstract class Jugador implements SistemaDefensa, JugadorGanador {

    protected Energia energia;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Estado estado;
    protected String nombre;
    protected Casillero casillero;
    protected Turno turno;


    public Jugador(String nombre) throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        if (nombre.trim().length() < 4) {
            throw new NombreDeJugadorConMenosDe4CaracteresExcepcion();
        }
        this.nombre = nombre;
        this.energia = new Energia();
        this.estado = new Habilitado(this);
        this.turno = new Turno();
        this.dispositivoDeAzar = new Dado(6);
    }

    @Override
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
        return this.casillero.esIgualQue(casillero);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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