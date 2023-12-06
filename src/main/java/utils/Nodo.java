package utils;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> siguiente;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.siguiente = null;
    }

    public void cambiarSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    public Nodo<T> elSiguiente() {
        return this.siguiente;
    }

    public T obtenerElemento() {
        return this.elemento;
    }
}
