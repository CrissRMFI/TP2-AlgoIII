package Entidades.Obstaculos;

import Entidades.Elementos.Dado;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Bacanal implements Obstaculo{

    private int proporcion = 4;
    @Override
    public void enfrentar(Gladiador gladiador) {
        Dado dado = new Dado();
        int cantidad = gladiador.jugarTurno(dado);

        Energia energia = new Energia(-proporcion*cantidad);

        gladiador.afectarEnergia(energia);
    }
}
