package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Obstaculos.FieraSalvaje;

import java.util.Arrays;
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
            Casillero casillero = new Casillero();
            for (int j = 0; j < this.informacionMapa[i].length ; j++) {
                casillero.recibirElemento(this.informacionMapa[i][j]);
            }
            casilleros.add(casillero);
        }

        return casilleros;
    }
}
