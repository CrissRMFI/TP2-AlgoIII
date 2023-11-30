package Entidades.Tablero;

import Datos.InformacionMapa;
import Entidades.Elementos.ValorAzar;
import Vista.TableroVista;
import javafx.scene.layout.GridPane;
import Entidades.Errores.DatoNoValido;

import java.util.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Mapa {
    private Map<Posicion, Casillero> casilleros;

    private LinkedList<Posicion> secuenciaPosiciones;

    private InformacionMapa informacionMapa;

    public Mapa (InformacionMapa informacionMapa) {
        this.casilleros = new HashMap<>();
        this.informacionMapa = informacionMapa;
        this.secuenciaPosiciones = new LinkedList<>();
    }

    public void contruirMapa () throws DatoNoValido {
        this.casilleros = this.informacionMapa.construirMapa(secuenciaPosiciones);
    }

    public Casillero obtenerCasillero (Posicion posicion) {
        return this.casilleros.get(this.obtenerPosicion(posicion));
    }

    private Posicion obtenerPosicion (Posicion posicion) {
        for (Posicion p : this.casilleros.keySet()) {
            if (p.esIgual(posicion)) {
                return p;
            }
        }
        return null;
    }

    public Posicion calcularSiguientePosicion(ValorAzar valor, Posicion posicion) {
        int indiceDePosicionActual = this.secuenciaPosiciones.indexOf(posicion) +1;
        int cantidadDeMovimiento = 0;
        Posicion nuevaPosicion = null;
        Iterator<Posicion> iterator = this.secuenciaPosiciones.listIterator(indiceDePosicionActual);

        while (iterator.hasNext() && cantidadDeMovimiento < valor.obtenerValor()) {
            nuevaPosicion = iterator.next();
            cantidadDeMovimiento++;
        }
        return nuevaPosicion;
    }

    public Posicion obtenerPosicionInicial () {
        return this.secuenciaPosiciones.get(0);
    }

    public Posicion obtenerPosicionFinal() {
        return this.secuenciaPosiciones.get(this.secuenciaPosiciones.size()-1);
    }

    public Posicion obtenerPosicionDelMedio() {
        return this.secuenciaPosiciones.get(this.secuenciaPosiciones.size()/2);
    }

    public GridPane construirVistaMapa (TableroVista tableroVista) {
        return tableroVista.construirTablero(this.casilleros);
    }
}