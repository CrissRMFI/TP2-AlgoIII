package Entidades.Elementos;

import Entidades.ListaCircular;

public class MockDado implements DispositivoDeAzar{

    private CaraDado cara;

    public MockDado () {
        this.cara = new CaraDado(1);}
    @Override
    public CaraDado lanzar() {
        return this.cara;
    }

}
