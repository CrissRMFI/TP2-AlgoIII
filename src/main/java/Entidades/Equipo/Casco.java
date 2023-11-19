package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Casco extends Equipo {

    public Casco () {
        this.tipoEquipo = Equipamiento.CASCO;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-15);
    }
}
