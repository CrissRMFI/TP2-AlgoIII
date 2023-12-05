package Entidades;

public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> actual;
    private int longitud;

    public ListaCircular() {
        this.inicio = null;
        this.actual = null;
        this.longitud = 0;
    }

    public void agregarElemento(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);

        if (this.inicio == null) {
            this.inicio = nuevoNodo;
            nuevoNodo.cambiarSiguiente(this.inicio);
            this.actual = this.inicio;
        } else {
            nuevoNodo.cambiarSiguiente(this.inicio);
            this.actual.cambiarSiguiente(nuevoNodo);
            this.actual = nuevoNodo;
        }

        this.longitud++;
    }

    public T obtener() {
        return this.actual.obtenerElemento();
    }

    public T seleccionAleatoria() {
        Nodo<T> nodoActual = this.inicio;
        int numeroAleatorio = (int) (Math.random() * this.longitud);
        for (int i = 0; i < numeroAleatorio; i++) {
            nodoActual = nodoActual.elSiguiente();
        }

        this.actual = nodoActual;
        Nodo<T> auxiliar = this.actual;
        while (auxiliar.elSiguiente() != this.actual) {
                auxiliar = auxiliar.elSiguiente();
        }
        this.inicio = auxiliar;

        return this.actual.obtenerElemento();
    }

    public T iniciarConElPrimero() {
        Nodo<T> auxiliar = this.actual;
        this.actual = this.inicio;
        this.inicio = auxiliar;

        return this.actual.obtenerElemento();
    }

    public T siguiente() {
        this.actual = this.actual.elSiguiente();
        return this.actual.obtenerElemento();
    }

    public int tamanio () {
        return this.longitud;
    }

    public boolean vueltaCompleta() {
        if (this.longitud > 0) {
            return this.actual == this.inicio;
        }
        return false;
    }
}
