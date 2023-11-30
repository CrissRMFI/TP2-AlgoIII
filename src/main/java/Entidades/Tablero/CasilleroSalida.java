package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroSalida extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasilleroInicial();
    }
}
