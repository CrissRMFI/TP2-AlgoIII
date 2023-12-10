package modelo.obstaculos;


import modelo.energia.Energia;
import modelo.jugadores.Jugador;

public class Bacanal extends Obstaculo {

    private final int proporcion;

    public Bacanal() {
        super();
        this.proporcion = 4;
    }

    @Override
    public void interactuar(Jugador jugador) {
        int valor = jugador.lanzar();
        Energia energia = new Energia(-proporcion * valor);
        jugador.recibirDanio(energia);
    }
}