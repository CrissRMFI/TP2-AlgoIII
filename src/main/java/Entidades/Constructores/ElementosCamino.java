package Entidades.Constructores;

import Entidades.Obstaculos.Obstaculo;
import Entidades.Premios.Premio;

public class ElementosCamino {
    public Obstaculo obtenerTipoDeObstaculo (String obstaculo) {
        if (obstaculo.equals("")) return null;
        return TipoElemento.valueOf(obstaculo).obtenerObstaculo();
    }

    public Premio obtenerTipoDePremio (String premio) {
        if (premio.equals("")) return null;
        return TipoElemento.valueOf(premio).obtenerPremio();
    }
}
