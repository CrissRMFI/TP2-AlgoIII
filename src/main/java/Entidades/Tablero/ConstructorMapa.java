package Entidades.Tablero;

import java.util.LinkedList;
import java.util.Map;

public interface ConstructorMapa {
    public abstract void construirMapa(Map<Posicion, Casillero> datos, LinkedList<Casillero> casilleroMapas);
}