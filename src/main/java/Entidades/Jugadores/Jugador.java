package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipo;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public interface Jugador extends ElementosMapa {

    public void afectarEnergia (Energia energia);
    public void equipar(Equipo equipo);
    public void moverse(Tablero tablero, DispositivoDeAzar dispositivoDeAzar);
    public void finalizarTurno ();
    public void obtenerElementos (Tablero tablero);
}
