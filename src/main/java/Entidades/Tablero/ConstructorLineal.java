package Entidades.Tablero;

import java.util.LinkedList;
import java.util.Map;

public class ConstructorLineal implements ConstructorMapa{
    @Override
    public void construirMapa(Map<Posicion, Casillero> datos, LinkedList<Casillero> casilleros) {
        Posicion p = new PosicionLineal(0);
        Casillero casillero = new Casillero();
        datos.put(p,casillero);
        for (int i=0; i<casilleros.size();i++) {
            Posicion posicion  = new PosicionLineal(i+1);
            datos.put(posicion,casilleros.get(i));
        }

    }
}