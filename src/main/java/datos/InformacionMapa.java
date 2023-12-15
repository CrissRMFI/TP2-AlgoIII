package datos;

import entidades.errores.DatoNoValido;
import entidades.tablero.Casillero;

import java.util.LinkedList;

public interface InformacionMapa {
    public abstract void construirCamino(LinkedList<Casillero> casilleros) throws DatoNoValido;
}