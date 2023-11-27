package Entidades.Constructores;

import Entidades.Tablero.*;
import Entidades.Tablero.CasilleroInicial;
import Entidades.Tablero.CasilleroMapa;

public enum TipoCasillero {
        Salida,
        Llegada,
        Camino;


        public Casillero obtenerCasillero() {
            switch (this) {
                case Salida:
                    return new CasilleroInicial();
                case Llegada:
                    return new CasilleroFinal();
                case Camino:
                    return new CasilleroMapa();
                default:
                    throw null;
            }
        }



}
