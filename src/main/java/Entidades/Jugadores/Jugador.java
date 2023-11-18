package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.ElementosMapa;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Tablero.Tablero;

public interface Jugador extends ElementosMapa {

    public void afectarEnergia (Energia energia);
    public void defenderse();
    public void equipar(Equipo equipo);
    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    public void finalizarTurno ();
    public void obtenerElementos (Tablero tablero);
    public void iniciarTurno ();
    public int getSalud(); // TODO: lUEGO BORRAR ESTO, ES UN HACK PARA PRUEBAS
}
