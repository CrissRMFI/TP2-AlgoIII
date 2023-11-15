package Entidades.Elementos;

import Entidades.Tablero.Posicion;

public class Dado implements DispositivoDeAzar{
    private CaraDado cara1;
    private CaraDado cara2;
    private CaraDado cara3;
    private CaraDado cara4;
    private CaraDado cara5;
    private CaraDado cara6;
    public Dado () {
        this.cara1 = new CaraDado(1);
        this.cara2 = new CaraDado(2);
        this.cara3 = new CaraDado(3);
        this.cara4 = new CaraDado(4);
        this.cara5 = new CaraDado(5);
        this.cara6 = new CaraDado(6);


    }
    @Override
    public CaraDado lanzar() {
        return this.cara1;
    }
}
