package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Tablero.Casillero;
import Parseador.*;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;
public class Mapa extends GridPane {
    private MapaJson mapaJson;
    private GridPane gridPane = new GridPane();
    private LinkedList<CasilleroCamino> camino = new LinkedList<>();


    public Mapa (String ruta,AppModelo modelo) throws ArchivoNoEncontrado {
        Parseador parseador = new ParseadorMapaJson();
        parseador.leerArchivo(ruta);
        this.mapaJson = (MapaJson) parseador.obtenerInformacion();
        this.construirTablero();
        this.construirCamino(modelo);
        modelo.ubicarJugadoresEnElMapa(this);
    }

    private void construirTablero () {

        InfoMapa infoMapa = this.mapaJson.getInfoMapa();

        for (int i = 0; i < infoMapa.getLargo(); i++) {
            for (int j = 0; j < infoMapa.getAncho(); j++) {
                this.add(new CasilleroNoCamino(), i+1, j+1);
            }
        }

    }
    public void construirCamino (AppModelo modelo) {
        Camino camino = this.mapaJson.getCamino();
        LinkedList<Celda> celdas = camino.getCeldas();
        LinkedList<Casillero> casilleros = modelo.getCasilleros();

        for (int i=0; i<celdas.size();i++) {
            CasilleroCamino casilleroCamino = new CasilleroCamino(casilleros.get(i));
            casilleroCamino.agregar(celdas.get(i).getObstaculo());
            casilleroCamino.agregar(celdas.get(i).getPremio());
            casilleroCamino.setAlignment(Pos.CENTER);
            this.add(casilleroCamino,celdas.get(i).getX(),celdas.get(i).getY());
            this.camino.add(casilleroCamino);

        }

        Celda celdaInicial = camino.getCeldas().get(0);
        this.add(this.gridPane,celdaInicial.getX(),celdaInicial.getY());

    }

    public void moverJugador (Jugador jugador) {
        this.camino.get(0).remover(jugador);
    }

    public void agregarJugador (Jugador jugador) {
        jugador.setCasillero(this.camino.get(0));
    }

    public LinkedList<CasilleroCamino> getCamino () {
        return this.camino;
    }
}
