package Datos;

import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;

import java.util.LinkedList;
import java.util.Map;

public interface InformacionMapa {
    Map<Posicion, Casillero> construirMapa(LinkedList<Posicion> posiciones);
}