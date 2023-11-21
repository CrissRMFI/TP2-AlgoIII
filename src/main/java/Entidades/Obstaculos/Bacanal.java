package Entidades.Obstaculos;

import Entidades.Elementos.Dado;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Bacanal extends Obstaculo{

    private int proporcion = 4;

    @Override
    public void interactuar(Jugador jugador) throws SinDispositivoDeAzar {

        ValorAzar valor = jugador.lanzar();

        Energia energia = new Energia(-proporcion* valor.obtenerValor());

        jugador.afectarEnergia(energia);
    }
}