package Entidades.Tablero;

public class Coordenada {
    private int valor;

    public Coordenada(int c) {
        this.valor = c;
    }

    public int valor() {
        return this.valor;
    }

    public void moverCoordenada(Coordenada c) {
        this.valor += c.valor();
    }
}
