package Entidades.Obstaculos;

import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Bacanal extends Obstaculo{

    private final int PROPORCION = 4;

    @Override
    public void interactuar(Jugador jugador) {
        ValorAzar valor = jugador.lanzar();
        Energia energia = new Energia(-PROPORCION * valor.obtenerValor());
        jugador.recibirDanio(energia);
    }
}