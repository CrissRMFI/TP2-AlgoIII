package modelo.sistemas;

import modelo.energia.Energia;
import modelo.premios.JerarquiaEquipos;

public interface SistemaDefensa {

    void recibirDanio(Energia energia);

    void defenderse();

    void equipar();

    boolean esEquipoMaximo();

    boolean compararEquipo(JerarquiaEquipos equipo);
}