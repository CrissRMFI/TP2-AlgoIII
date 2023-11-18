package Entidades.Equipo;

import Entidades.Jugadores.Gladiador;
import Entidades.Energia.Energia;

public class EscudoYEspada extends Equipo{
   public EscudoYEspada () {
        this.tipoEquipo = Equipamiento.ESCUDOYESPADA;
    }

    @Override
    public Energia energiaAReducir() {
        return new Energia(-2);
    }

}
