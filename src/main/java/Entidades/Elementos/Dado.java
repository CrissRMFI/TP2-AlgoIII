package Entidades.Elementos;

public class Dado implements DispositivoDeAzar {

    private final int caras;

    public Dado() {
        this.caras = 6;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * this.caras) + 1;
    }
}