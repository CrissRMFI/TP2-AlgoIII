package Entidades.Obstaculos;

import Entidades.Elementos.Dado;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Bacanal implements Obstaculo{

    private int proporcion = 4;

    @Override
    public void interactuar(Jugador jugador) {
        Dado dado = new Dado();
        ValorAzar valor = dado.lanzar();

        Energia energia = new Energia(-proporcion* valor.obtenerValor());

        jugador.defenderse();
    }
}
