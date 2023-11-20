package Entidades.Tablero;

import Entidades.Elementos.Interactuable;

import java.util.LinkedList;

public class InformacionMapaEnMatriz implements InformacionMapa {
    private Interactuable[][] informacionMapa;
    public InformacionMapaEnMatriz (Interactuable[][] informacion) {
        this.informacionMapa = informacion;
    }
    @Override
    public LinkedList<Casillero> construirCasilleros() {
        LinkedList<Casillero> casilleros = new LinkedList<Casillero>();

        for (int i = 0; i < this.informacionMapa.length; i++) {
            CasilleroMapa casilleroMapa = new CasilleroMapa();
            for (int j = 0; j < this.informacionMapa[i].length ; j++) {
                casilleroMapa.recibirElemento(this.informacionMapa[i][j]);
            }
            casilleros.add(casilleroMapa);
        }

        return casilleros;
    }
}
