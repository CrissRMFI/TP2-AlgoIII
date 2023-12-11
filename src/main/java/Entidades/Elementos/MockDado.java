package Entidades.Elementos;


public class MockDado implements DispositivoDeAzar { // TODO: volar esta clase

    private final int cara;

    public MockDado() {
        this.cara = 1;
    }

    public MockDado(int valor) {
        this.cara = valor;
    }

    @Override
    public int lanzar() {
        return this.cara;
    }

}
