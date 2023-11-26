package Entidades.Sistemas;

import Entidades.Energia.Energia;
import Entidades.Equipo.JerarquiaEquipos;

public interface SistemaDefensa {
    void recibirDanio (Energia energia);
    void defenderse ();
    void equipar();
    boolean esEquipoMaximo();
    boolean compararEquipo(JerarquiaEquipos equipo);
}