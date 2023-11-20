package Entidades;

public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> actual;

    private int longitud;

    public ListaCircular() {
        this.inicio = null;
        this.longitud = 0;
    }

    public void agregarElemento(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        this.actual = nuevoNodo;
        if (this.inicio == null) {
            this.inicio = nuevoNodo;
            nuevoNodo.cambiarSiguiente(this.inicio);
        } else {
            Nodo<T> actual = this.inicio;
            while (actual.elSiguiente() != this.inicio) {
                actual = actual.elSiguiente();
            }
            actual.cambiarSiguiente(nuevoNodo);
            nuevoNodo.cambiarSiguiente(this.inicio);
        }
        this.longitud++;
    }
    public T obtener() {
        return this.actual.obtenerElemento();
    }
    public T eliminar(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> anterior = null;
        Nodo<T> actual = this.inicio;
        for (int i = 0; i < indice; i++) {
            anterior = actual;
            actual = actual.elSiguiente();
        }
        if (anterior == null) {
            this.inicio = actual.elSiguiente();
        } else {
            anterior.cambiarSiguiente(actual.elSiguiente());
        }
        this.longitud--;
        return actual.obtenerElemento();
    }

    public T seleccionAleatoria() {
        Nodo<T> nodoActual = this.inicio;
        int numeroAleatorio = (int) (Math.random() * this.longitud);
        for (int i = 0; i < numeroAleatorio; i++) {
            nodoActual = nodoActual.elSiguiente();
        }
        this.actual = nodoActual;
        this.inicio = nodoActual;
        return nodoActual.obtenerElemento();
    }

    public T siguiente() {

        this.actual = this.actual.elSiguiente();
        return this.actual.obtenerElemento();
    }

    public int tamanio () {
        return this.longitud;
    }

    public boolean vueltaCompleta () {
        if (this.longitud > 0) {
            return this.actual == this.inicio;
        }
        return false;

    }

}
