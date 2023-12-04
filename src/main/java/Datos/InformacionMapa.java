package Datos;

import Entidades.Errores.DatoNoValido;
import Entidades.Tablero.Casillero;
import java.util.LinkedList;

public interface InformacionMapa {
    public abstract void construirCamino(LinkedList<Casillero> casilleros) throws DatoNoValido;

    public abstract int conseguirAncho();

    public abstract int conseguirLargo();
}