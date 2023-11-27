package Entidades.Tablero;

import Entidades.Elementos.Interactuable;

import java.util.*;

public class InformacionMapaLinealEnMatriz implements InformacionMapa {
    private Interactuable[][] informacionMapa;
    public InformacionMapaLinealEnMatriz(Interactuable[][] informacion) {
        this.informacionMapa = informacion;
    }
    @Override
    public Map<Posicion,Casillero> construirMapa(LinkedList<Posicion> posiciones) {

        Map<Posicion,Casillero> mapa = new HashMap<>();

        Posicion posicionInicial = new Posicion(0,0);
        Casillero casilleroInicial = new CasilleroInicial(posicionInicial);
        mapa.put(posicionInicial,casilleroInicial);
        posiciones.add(posicionInicial);

        int k = 0;
        for (int i = 0; i < this.informacionMapa.length; i++) {
            CasilleroMapa casilleroMapa = new CasilleroMapa();
            Posicion posicion = new Posicion(i+1,0);
            for (int j = 0; j < this.informacionMapa[i].length ; j++) {
                casilleroMapa.recibirElemento(this.informacionMapa[i][j]);
            }
            mapa.put(posicion,casilleroMapa);
            posiciones.add(posicion);
            k++;
        }

        Posicion posicionFinal = new Posicion(k+1,0);
        Casillero casilleroFinal = new CasilleroFinal(posicionFinal);
        mapa.put(posicionInicial,casilleroFinal);
        posiciones.add(posicionFinal);

        return mapa;
    }
}
