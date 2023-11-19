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
        if (inicio == null) {
            inicio = nuevoNodo;
            nuevoNodo.cambiarSiguiente(inicio);
        } else {
            Nodo<T> actual = inicio;
            while (actual.elSiguiente() != inicio) {
                actual = actual.elSiguiente();
            }
            actual.cambiarSiguiente(nuevoNodo);
            nuevoNodo.cambiarSiguiente(inicio);
        }
        longitud++;
    }

    /*
    public T obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            actual = actual.elSiguiente();
        }
        return actual.obtenerElemento();
    }
*/
    public T obtener() {
        return this.actual.obtenerElemento();
    }
    public T eliminar(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException();
        }
        Nodo<T> anterior = null;
        Nodo<T> actual = inicio;
        for (int i = 0; i < indice; i++) {
            anterior = actual;
            actual = actual.elSiguiente();
        }
        if (anterior == null) {
            inicio = actual.elSiguiente();
        } else {
            anterior.cambiarSiguiente(actual.elSiguiente());
        }
        longitud--;
        return actual.obtenerElemento();
    }

    public T seleccionAleatoria() {
        Nodo<T> nodoActual = inicio;
        int numeroAleatorio = (int) (Math.random() * longitud);
        for (int i = 0; i < numeroAleatorio; i++) {
            nodoActual = nodoActual.elSiguiente();
        }
        this.actual = nodoActual;
        return nodoActual.obtenerElemento();
    }

    public T siguiente() {

        this.actual = this.actual.elSiguiente();
        return this.actual.obtenerElemento();
    }

}
