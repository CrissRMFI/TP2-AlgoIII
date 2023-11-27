package Entidades.Constructores;

import Entidades.Tablero.Casillero;

public class Casilleros {
    public  Casillero obtenerCasillero (String casillero) {
        return TipoCasillero.valueOf(casillero).obtenerCasillero();
    }
}
