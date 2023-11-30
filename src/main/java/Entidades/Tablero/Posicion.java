package Entidades.Tablero;

public class Posicion {
    private Coordenada x;
    private Coordenada y;

    public Posicion (int x,int y) {
        this.x = new Coordenada(x);
        this.y = new Coordenada(y);
    }
    public void cambiarPosicion (Posicion posicion) {
        this.x.moverCoordenada(posicion.obtenerCoordenadaLinal());
        this.y.moverCoordenada(posicion.obtenerCoordenadaVertical());
    }
    protected Coordenada obtenerCoordenadaLinal() {
        return this.x;
    }

    protected Coordenada obtenerCoordenadaVertical() {
        return this.y;
    }

    public int posicionLineal () {
        return this.x.valor();
    }

    public int posicionVertical () {
        return this.y.valor();
    }


    public boolean esIgual(Posicion posicion) {
        boolean lineal = this.x.comparar(posicion.obtenerCoordenadaLinal());
        boolean vertical = this.y.comparar(posicion.obtenerCoordenadaVertical());

        return lineal && vertical;
    }
}
