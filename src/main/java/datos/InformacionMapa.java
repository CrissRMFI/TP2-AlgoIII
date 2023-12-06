package datos;

import modelo.errores.DatoNoValido;
import modelo.tablero.Casillero;

import java.util.LinkedList;

public interface InformacionMapa {
    public abstract void construirCamino(LinkedList<Casillero> casilleros) throws DatoNoValido;
}