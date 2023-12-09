package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import Parseador.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;
public class Mapa extends GridPane {
    private MapaJson mapaJson;

    public Mapa (String ruta) throws ArchivoNoEncontrado {
        Parseador parseador = new ParseadorMapaJson();
        parseador.leerArchivo(ruta);
        this.mapaJson = (MapaJson) parseador.obtenerInformacion();
        this.construirTablero();
        this.construirCamino();
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
    }
}
