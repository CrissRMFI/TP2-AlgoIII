package Entidades.Tablero;

public class Coordenada {
    private int valor;

    public Coordenada(int c) {
        this.valor = c;
    }

    protected int valor() {
        return this.valor;
    }

    public void moverCoordenada(Coordenada c) {
        this.valor += c.valor();
    }

    public boolean comparar (Coordenada coordenada) {
        return this.valor == coordenada.valor;
    }

    public boolean esMayorOIgual (Coordenada coordenada) {
        return this.valor >= coordenada.valor;
    }
}
