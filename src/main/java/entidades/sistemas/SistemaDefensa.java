package entidades.sistemas;

import entidades.energia.Energia;
import entidades.equipo.JerarquiaEquipos;

public interface SistemaDefensa {

    void afectarEnergia(Energia energia);

    void defenderse();

    void equipar();

    boolean esEquipoMaximo();

    boolean compararEquipo(JerarquiaEquipos equipo);
}