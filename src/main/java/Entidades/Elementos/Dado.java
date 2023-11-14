package Entidades.Elementos;

import Entidades.Tablero.Posicion;

public class Dado implements DispositivoDeAzar{
    @Override
    public int lanzar() {
        return 6;
    }
}
