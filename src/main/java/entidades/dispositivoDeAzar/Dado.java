package entidades.dispositivoDeAzar;

public class Dado implements DispositivoDeAzar {
    private final int caras;

    public Dado(int caras) {
        this.caras = caras;
    }

    @Override
    public int lanzar() {
        return (int) (Math.random() * this.caras) + 1;
    }
}