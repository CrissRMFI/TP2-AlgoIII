package Entidades.Tablero;
import Entidades.Elementos.ValorAzar;
import Vista.TableroVista;
import javafx.scene.layout.GridPane;

public class Tablero {
    private final Mapa mapa;
    private TableroVista tableroVista = new TableroVista();

    public Tablero(Mapa mapa) {
        this.mapa = mapa;
    }

    public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    }

    public Posicion calcularPosicion (ValorAzar valor, Posicion posicion) {
        return this.mapa.calcularSiguientePosicion(valor,posicion);
    }

    public Posicion posicionInicial () {
        return this.mapa.obtenerPosicionInicial();
    }

    public Posicion posicionFinal () {
        return this.mapa.obtenerPosicionFinal();
    }

    public Posicion posicionMedio() {
        return mapa.obtenerPosicionDelMedio();
    }

    public GridPane renderizarTablero () {
        return this.mapa.construirVistaMapa(this.tableroVista);
    }

    public int conseguirAncho(){
        return this.mapa.conseguirAncho();
    }

    public int conseguirLargo(){
        return this.mapa.conseguirLargo();
    }


}