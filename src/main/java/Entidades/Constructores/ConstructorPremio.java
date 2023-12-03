package Entidades.Constructores;

import Entidades.Premios.Comida;
import Entidades.Premios.Equipamiento;
import Entidades.Premios.Premio;
import Entidades.Premios.SinPremio;

public class ConstructorPremio {
    public Premio construirPremio (String tipo) {
        switch (tipo) {
            case "Comida": return new Comida();
            case "Equipamiento": return new Equipamiento();
            default: return new SinPremio();
        }
    }
}
