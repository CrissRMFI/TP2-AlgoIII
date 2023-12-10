package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import Parseador.*;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.LinkedList;
public class Mapa extends GridPane {
    private MapaJson mapaJson;
    private int x = 0;
    private int y = 0;
    private GridPane gridPane = new GridPane();


    public Mapa (AppModelo modelo) throws ArchivoNoEncontrado {
        Parseador parseador = new ParseadorMapaJson();
        parseador.leerArchivo(modelo.getRutaArchivo());
        this.mapaJson = (MapaJson) parseador.obtenerInformacion();
        this.construirTablero();
        this.construirCamino();
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

    public void construirCamino () {
        Camino camino = this.mapaJson.getCamino();
        LinkedList<Celda> celdas = camino.getCeldas();

        for (Celda celda : celdas) {
            CasilleroCamino casilleroCamino = new CasilleroCamino();
            casilleroCamino.add(celda.getObstaculo(),0,1);
            casilleroCamino.add(celda.getPremio(),0,2);
            casilleroCamino.setAlignment(Pos.CENTER);
            this.add(casilleroCamino,celda.getX(),celda.getY());

        }

        Celda celdaInicial = camino.getCeldas().get(0);
        this.add(this.gridPane,celdaInicial.getX(),celdaInicial.getY());
    }

    public void agregarJugador (Jugador jugador) {
        this.gridPane.add((HBox)jugador,this.x,this.y);
        this.x++;
        this.y++;

    }
}
