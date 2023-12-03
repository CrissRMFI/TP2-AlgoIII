package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroSalida extends Casillero{
    public CasilleroSalida (int x,int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean soyMeta() {
        return false;
    }
}
