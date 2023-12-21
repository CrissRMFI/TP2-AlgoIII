package entidades.constructores;

import entidades.Interactuable;
import entidades.obstaculos.*;

public class ConstructorObstaculo implements ConstructorInteractuable{
    public Interactuable construir(String tipo) {
        switch (tipo) {
            case "Lesion":
                return new Lesion();
            case "Fiera":
                return new Fiera();
            case "Bacanal":
                return new Bacanal();
            default:
                return new SinObstaculo();
        }
    }
}
