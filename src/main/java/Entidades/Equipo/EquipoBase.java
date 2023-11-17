package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class EquipoBase implements Equipo {

    Energia energia;

    public EquipoBase () {
        this.energia = new Energia(-20);
    }
    @Override
    public void accionar(Gladiador gladiador) {
        gladiador.equipar(this);
    }

    @Override
    public void recibirDanio(Gladiador gladiador) {
        gladiador.afectarEnergia(this.energia);
    }

    public int obtener () {
        return this.energia.otorgarEnergia();
    }
}
