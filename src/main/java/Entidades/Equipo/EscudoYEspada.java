package Entidades.Equipo;

import Entidades.Jugadores.Gladiador;
import Entidades.Energia.Energia;

public class EscudoYEspada extends DecoradorEquipo{
    Energia energia;

    public EscudoYEspada () {
        this.energia = new Energia(-10);
    }

}
