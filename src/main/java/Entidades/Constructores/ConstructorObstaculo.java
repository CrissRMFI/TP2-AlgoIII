package Entidades.Constructores;

import Entidades.Obstaculos.*;

public class ConstructorObstaculo {
    public Obstaculo construirObstaculo (String tipo) {
        switch (tipo) {
            case "Lesion": return new Lesion();
            case "Fiera": return new Fiera();
            case "Bacanal": return new Bacanal();
            default: return new SinObstaculo();
        }
    }
}