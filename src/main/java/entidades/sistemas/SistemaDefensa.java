package entidades.sistemas;

import entidades.energia.Energia;
import entidades.premios.JerarquiaEquipos;

public interface SistemaDefensa {

    public abstract void afectarEnergia(Energia energia);

    public abstract void defenderse();

    public abstract void equipar();

    public abstract boolean esEquipoMaximo();

    public abstract boolean compararEquipo(JerarquiaEquipos equipo);
}