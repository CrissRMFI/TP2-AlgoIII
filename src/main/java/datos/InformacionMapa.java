package datos;

import entidades.errores.DatoNoValido;
import entidades.tablero.Casillero;

import java.util.LinkedList;

public interface InformacionMapa {
    void construirCamino(LinkedList<Casillero> casilleros) throws DatoNoValido;
}