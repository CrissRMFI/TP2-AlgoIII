package Entidades.Obstaculos;

import Entidades.Elementos.Dado;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Bacanal implements Obstaculo{

    private int proporcion = 4;
    @Override
    public void enfrentar(Gladiador gladiador) {
        Dado dado = new Dado();
        ValorAzar valor = dado.lanzar();

        Energia energia = new Energia(-proporcion* valor.obtenerValor());

        gladiador.afectarEnergia(energia);
    }

    @Override
    public void accionar(Gladiador gladiador) {
        this.enfrentar(gladiador);
    }
}
