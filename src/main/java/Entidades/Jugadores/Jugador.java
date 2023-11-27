package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Sistemas.SistemaPosicionamiento;
import Entidades.Sistemas.SistemaTurnos;
import Entidades.Tablero.Posicion;

public abstract class Jugador implements SistemaDefensa, SistemaPosicionamiento, SistemaTurnos {

    protected Energia energia;
    protected Posicion posicion;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Turno turno;
    protected String nombre;


    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }


    public void posicionar(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void perderTurnos (Turno turnos);


    @Override
    public Posicion miPosicion () {
        return this.posicion;
    }

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

    public String miNombre () {
        return this.nombre;
    }

}