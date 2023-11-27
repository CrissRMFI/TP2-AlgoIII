package Entidades.Tablero;

import java.util.LinkedList;
import java.util.Map;

public interface InformacionMapa {
    Map<Posicion,Casillero> construirMapa(LinkedList<Posicion> posiciones);
}