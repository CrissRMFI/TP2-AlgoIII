package entidades.constructores;

import entidades.premios.Comida;
import entidades.premios.Equipamiento;
import entidades.premios.Premio;
import entidades.premios.SinPremio;

public class ConstructorPremio {
    public Premio construirPremio(String tipo) {
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
