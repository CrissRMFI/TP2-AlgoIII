package Entidades.Tablero;

public class Coordenada {
    private int coordenada;

    public Coordenada (int c) {
        this.coordenada = c;
    }

    public int valor () {
        return this.coordenada;
    }

    public void moverCoordenada(Coordenada c) {
        this.coordenada += c.valor();
    }
}
