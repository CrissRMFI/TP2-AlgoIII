package Datos;

import Entidades.Errores.DatoNoValido;
import Entidades.Tablero.Casillero;
import java.util.LinkedList;

public interface InformacionMapa {
    void construirCamino(LinkedList<Casillero> casilleros) throws DatoNoValido;

}