package entidades.constructores;

import entidades.Interactuable;
import entidades.premios.Comida;
import entidades.premios.Equipamiento;
import entidades.premios.SinPremio;

public class ConstructorPremio {
    public Interactuable construirPremio(String tipo) {
        switch (tipo) {
            case "Comida":
                return new Comida();
            case "Equipamiento":
                return new Equipamiento();
            default:
                return new SinPremio();
        }
    }
}
