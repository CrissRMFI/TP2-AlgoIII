package Entidades.Constructores;

import Entidades.Obstaculos.*;
import Entidades.Premios.*;
import Entidades.Tablero.Equipo;

public enum TipoElemento {
    Lesion,
    Fiera,
    Bacanal,
    Equipamiento,
    Comida,
    Vacio;


    public Obstaculo obtenerObstaculo() {
        switch (this) {
            case Lesion:
                return new Piedra();
            case Fiera:
                return new FieraSalvaje();
            case Bacanal:
                return new Bacanal();
            default:
                throw null;
        }
    }

    public Premio obtenerPremio() {
        switch (this) {
            case Equipamiento:
                return new Equipo();
            case Comida:
                return new Comida();
            default:
                throw null;
        }
    }
}
