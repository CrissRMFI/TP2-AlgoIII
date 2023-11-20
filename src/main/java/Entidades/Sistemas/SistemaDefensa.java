package Entidades.Sistemas;

import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Obstaculos.Obstaculo;

public interface SistemaDefensa {
    void recibirDanio (Energia energia);

    void modificarEquipo (Equipo equipo);

    boolean comparar (Equipamiento equipamiento);
}