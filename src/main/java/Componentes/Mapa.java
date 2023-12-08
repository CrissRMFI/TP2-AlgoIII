package Componentes;

import Entidades.Errores.ArchivoNoEncontrado;
import Parseador.*;
import javafx.scene.layout.GridPane;
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
                Rectangle casillero = new Rectangle(50, 50);
                casillero.setFill(Color.BURLYWOOD);
                casillero.setStroke(Color.BLACK);
                this.add(new CasilleroNoCamino(), i+1, j+1);

            }
        }
    }

    public void construirCamino () {
        Camino camino = this.mapaJson.getCamino();
        LinkedList<Celda> celdas = camino.getCeldas();

        for (Celda celda : celdas) {
            CasilleroCamino casilleroCamino = new CasilleroCamino();
            this.add(casilleroCamino,celda.getX(),celda.getY());
        }
    }
}
