package modelo.elementos;

public class MockDado implements DispositivoDeAzar {

    private CaraDado cara;

    public MockDado() {
        this.cara = new CaraDado(1);
    }

    public MockDado(int valor) {
        this.cara = new CaraDado(valor);
    }

    @Override
    public CaraDado lanzar() {
        return this.cara;
    }

}
