package Datos;

import Entidades.Interactuable;
import Entidades.Tablero.*;

import java.util.*;

public class InformacionMapaLinealEnMatriz implements InformacionMapa {

    private Interactuable[][] informacionMapa;
    public InformacionMapaLinealEnMatriz(Interactuable[][] informacion) {

        this.informacionMapa = informacion;
    }
    @Override
    public void construirCamino(LinkedList<Casillero> camino) {

        Casillero casilleroInicial = new Casillero(0,0);

        camino.add(casilleroInicial);

        int k = 0;
        for (int i = 0; i < this.informacionMapa.length; i++) {
            Casillero casilleroMapa = new Casillero(i+1,0);
            for (int j = 0; j < this.informacionMapa[i].length ; j++) {
                casilleroMapa.recibirElemento(this.informacionMapa[i][j]);
            }

            camino.add(casilleroMapa);
            k++;
        }


        Casillero casilleroFinal = new Casillero(k+1,0);
        camino.add(casilleroFinal);

    }
}
