package Entidades.Sistemas;

import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;

public interface SistemaDefensa {
    public abstract void recibirDanio (Energia energia);

    public abstract void modificarEquipo (Equipo equipo);

    public abstract boolean compararEquipo (Equipamiento equipamiento);

    public abstract void defenderse ();


}