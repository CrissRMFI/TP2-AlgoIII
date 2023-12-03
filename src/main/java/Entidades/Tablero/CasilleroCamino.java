package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroCamino extends Casillero{

    public CasilleroCamino(int x,int y) {
        this.x = x;
        this.y = y;

    }
    @Override
    public boolean soyMeta() {
        return false;
    }
}
