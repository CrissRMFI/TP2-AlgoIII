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

    private int ancho;
    private int largo;

    public Mapa (InformacionMapa informacionMapa) {
        this.casilleros = new HashMap<>();
        this.informacionMapa = informacionMapa;
        this.secuenciaPosiciones = new LinkedList<>();
    }

    public void contruirMapa () throws DatoNoValido {
        this.casilleros = this.informacionMapa.construirMapa(secuenciaPosiciones);
        this.largo = this.informacionMapa.conseguirLargo();
        this.ancho = this.informacionMapa.conseguirAncho();
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
        Posicion posicion1 = null;
        Iterator<Posicion> iterador = this.secuenciaPosiciones.iterator();

        while (iterador.hasNext()) {
            posicion1 = iterador.next();
            if (posicion1.esIgual(posicion)) {
                break;
            }
        }

        for (int i=0; i< valor.obtenerValor(); i++) {
            if (iterador.hasNext()) {
                posicion1 = iterador.next();
            } else {
                return this.obtenerPosicionDelMedio();
            }
        }
        return posicion1;
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

    public int conseguirAncho(){
        return this.ancho;
    }

    public int conseguirLargo(){
        return this.largo;
    }
}