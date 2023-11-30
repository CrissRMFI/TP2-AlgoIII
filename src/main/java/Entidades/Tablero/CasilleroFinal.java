package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroFinal extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasilleroFinal();
    }
}
