package Entidades.Elementos;

import Entidades.ListaCircular;

public class MockDado implements DispositivoDeAzar{

    private CaraDado cara;

    public MockDado () {
        this.cara = new CaraDado(3);}
    @Override
    public CaraDado lanzar() {
        return this.cara;
    }

}
