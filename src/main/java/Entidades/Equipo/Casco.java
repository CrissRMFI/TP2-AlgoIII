package Entidades.Equipo;

import Entidades.Energia.Energia;

public class Casco extends DecoradorEquipo{

    public void Casco () {
        this.energia = new Energia(-15);
    }

    public Energia recibirDanio () {
        return energia;
    }
}
