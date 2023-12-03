package Entidades.Constructores;

import Entidades.Tablero.Casillero;
import Entidades.Tablero.CasilleroCamino;
import Entidades.Tablero.CasilleroLlegada;
import Entidades.Tablero.CasilleroSalida;

public class ConstructorCasillero {
    public Casillero construirCasillero (String tipo,int x,int y) {
        switch (tipo) {
            case "Salida": return new CasilleroSalida(x, y);
            case "Llegada": return new CasilleroLlegada(x,y);
            default: return new CasilleroCamino(x,y);
        }
    }
}
