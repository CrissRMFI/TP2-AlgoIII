package Entidades.Tablero;

import java.util.LinkedList;
import java.util.Map;

public interface ConstructorMapa {
    void construirMapa(Map<Posicion, Casillero> datos, LinkedList<Casillero> casilleroMapas);
}