package Entidades.Jugadores;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Interactuable;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Sistemas.SistemaTurnos;
import Entidades.Tablero.Casillero;

public abstract class Jugador implements SistemaDefensa, SistemaTurnos, JugadorGanador {
    protected Energia energia;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Turno turno;
    protected String nombre;
    protected Casillero casillero;


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
        return this.nombre;
    }

    public void posicionar(Casillero casillero) {
        this.casillero = casillero;
    }
    public abstract void moverse(Casillero casillero);

    public boolean compararPosicion (Casillero casillero) {
        return this.casillero.equals(casillero);
    }


    public abstract void finalizarTurno (AlgoRoma algoRoma);

    public abstract String miDescripcion ();

    public abstract void obtenerElementos();
}