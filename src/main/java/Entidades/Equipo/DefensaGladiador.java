package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Sistemas.SistemaDefensa;

public class DefensaGladiador implements SistemaDefensa {
    private Equipo equipo;

    public DefensaGladiador (Equipo equipo) {
        this.equipo = equipo;
    }

    public void recibirDanio (Energia energia) {
        Energia e = this.equipo.energiaAReducir();
        energia.afectarEnergia(e);
    }

    public void modificarEquipo (Equipo equipo) {
        if (this.equipo.esEquipoSuperador(equipo)) {
            this.equipo = equipo;
        }
    }
}
