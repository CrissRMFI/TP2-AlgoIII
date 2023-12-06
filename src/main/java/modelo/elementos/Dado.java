package modelo.elementos;

import utils.ListaCircular;

public class Dado implements DispositivoDeAzar {
    private ListaCircular<CaraDado> caras;

    public Dado() {
        this.caras = new ListaCircular<CaraDado>();
        this.caras.agregarElemento(new CaraDado(1));
        this.caras.agregarElemento(new CaraDado(2));
        this.caras.agregarElemento(new CaraDado(3));
        this.caras.agregarElemento(new CaraDado(4));
        this.caras.agregarElemento(new CaraDado(5));
        this.caras.agregarElemento(new CaraDado(6));


    }

    @Override
    public CaraDado lanzar() {
        return this.caras.seleccionAleatoria();
    }
}