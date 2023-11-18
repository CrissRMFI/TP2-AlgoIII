package Entidades.Tablero;

public class PosicionLineal implements Posicion {
    private Coordenada x;

    public PosicionLineal(int x) {
        this.x = new Coordenada(x);
    }

    public Posicion cambiarPosicion (Posicion posicion) {
        this.x.moverCoordenada(posicion.obtenerCoordenada());
        return new PosicionLineal(this.x.valor());
    }
    @Override
    public Coordenada obtenerCoordenada() {
        return this.x;
    }

    public boolean comparar (Posicion posicion) {
        Coordenada coordenada = posicion.obtenerCoordenada();
        return this.x.valor() == coordenada.valor();
    }

}