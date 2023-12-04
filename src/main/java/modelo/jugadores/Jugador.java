package modelo.jugadores;

import modelo.AlgoRoma;
import modelo.elementos.DispositivoDeAzar;
import modelo.elementos.Turno;
import modelo.elementos.ValorAzar;
import modelo.energia.Energia;
import modelo.sistemas.SistemaDefensa;
import modelo.sistemas.SistemaTurnos;
import modelo.tablero.Casillero;
import modelo.tablero.Mapa;

public abstract class Jugador implements SistemaDefensa, SistemaTurnos, JugadorGanador {

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
        return this.nombre;}

    public void posicionar(Casillero casillero) {
        this.casillero = casillero;
    }

    public void ingresar (Mapa mapa) {
        this.mapa = mapa;
        this.mapa.ubicarEnInicio(this);
    }

    public abstract void moverse();

    public boolean compararPosicion (Casillero casillero) {
        return this.casillero.equals(casillero);
    }


    public abstract void finalizarTurno (AlgoRoma algoRoma);

    public abstract String miDescripcion ();

    public abstract void obtenerElementos();
}