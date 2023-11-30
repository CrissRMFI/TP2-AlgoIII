package Entidades.Tablero;

import Vista.CasilleroVista;

public class CasilleroInicial extends Casillero{
    @Override
    public CasilleroVista construirVistaCasillero() {
        return this.casilleroVista.crearCasilleroInicial();
    }
}
