package modelo.constructores;

import modelo.premios.Comida;
import modelo.premios.Equipamiento;
import modelo.premios.Premio;
import modelo.premios.SinPremio;

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
