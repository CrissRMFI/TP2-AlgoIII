package modelo.elementos;

public class CaraDado extends ValorAzar {
    private int valor;

    public CaraDado (int valor) {
        this.valor = valor;
    }

    @Override
    public int obtenerValor() {
        return this.valor;
    }
}
