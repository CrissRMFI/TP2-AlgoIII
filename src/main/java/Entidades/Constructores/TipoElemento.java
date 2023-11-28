package Entidades.Constructores;

import Entidades.Obstaculos.*;
import Entidades.Premios.*;
import Entidades.Premios.Equipamiento;

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
                return new Lesion();
            case Fiera:
                return new Fiera();
            case Bacanal:
                return new Bacanal();
            default:
                throw null;
        }
    }

    public Premio obtenerPremio() {
        switch (this) {
            case Equipamiento:
                return new Equipamiento();
            case Comida:
                return new Comida();
            default:
                throw null;
        }
    }
}
