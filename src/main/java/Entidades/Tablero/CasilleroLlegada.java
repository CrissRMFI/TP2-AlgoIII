package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroLlegada extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasilleroFinal();
    }
}
