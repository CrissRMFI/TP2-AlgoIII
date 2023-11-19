package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Llave extends Equipo {

    public Llave () {

        this.tipoEquipo = Equipamiento.LLAVE;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(0);
    }
}