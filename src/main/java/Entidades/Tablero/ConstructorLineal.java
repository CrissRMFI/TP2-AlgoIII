package Entidades.Tablero;

import java.util.LinkedList;
import java.util.Map;

public class ConstructorLineal implements ConstructorMapa{
    @Override
    public void construirMapa(Map<Posicion, Casillero> datos, LinkedList<Casillero> casillero) {
        Posicion p = new PosicionLineal(0);
        CasilleroMapa casilleroMapa = new CasilleroMapa();
        datos.put(p, casilleroMapa);
        for (int i = 0; i< casillero.size(); i++) {
            Posicion posicion  = new PosicionLineal(i+1);
            datos.put(posicion, casillero.get(i));
        }

    }
}