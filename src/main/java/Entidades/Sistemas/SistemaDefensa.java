package Entidades.Sistemas;

import Entidades.Energia.Energia;
import Entidades.Premios.JerarquiaEquipos;

public interface SistemaDefensa {

    void recibirDanio (Energia energia);

    void defenderse (Energia energia);

    void equipar();

    boolean esEquipoMaximo();

    boolean compararEquipo(JerarquiaEquipos equipo);
}