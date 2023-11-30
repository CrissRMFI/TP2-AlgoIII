package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroCamino extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasillero();
    }
}
