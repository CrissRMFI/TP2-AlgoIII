package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroMapa extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasillero();
    }
}
