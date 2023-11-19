package Entidades.Jugadores;

import Entidades.Elementos.Dado;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Tablero;

public class Jugador{
    Gladiador gladiador = new Gladiador();
    int turnosJugados = 0;

    public void jugarTurno(Dado dado, Tablero tablero){
        if (gladiador.getPuntosDeEnergia() >= 0 ){
            int cantidadAMoverse = dado.lanzar();
            Casillero nuevoCasillero = this.casilleroAMoverse(cantidadAMoverse, tablero);
            gladiador.jugarTurno(nuevoCasillero, this.turnosJugados);
        }
        else{
            gladiador.ganarEnergia(5);
        }
        this.turnosJugados++;
    }

    private Casillero casilleroAMoverse(int cantidadAMoverse, Tablero tablero){
        int nuevaPosicionX = this.gladiador.getPosicionX() + cantidadAMoverse;
        return tablero.obtenerCasillero(nuevaPosicionX, 0);
    }
}








/*
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.ElementosMapa;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Tablero.Tablero;

public interface Jugador extends ElementosMapa {

    public void afectarEnergia (Energia energia);
    public void equipar(Equipo equipo);
    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    public void finalizarTurno ();
    public void obtenerElementos (Tablero tablero);
    public void iniciarTurno ();
    public int getSalud(); // TODO: lUEGO BORRAR ESTO, ES UN HACK PARA PRUEBAS
}
*/