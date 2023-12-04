package modelo.obstaculos;

import modelo.elementos.ValorAzar;
import modelo.energia.Energia;
import modelo.jugadores.Jugador;

public class Bacanal extends Obstaculo{

    private final int PROPORCION = 4;

    @Override
    public void interactuar(Jugador jugador) {
        ValorAzar valor = jugador.lanzar();
        Energia energia = new Energia(-PROPORCION * valor.obtenerValor());
        jugador.recibirDanio(energia);
    }
}