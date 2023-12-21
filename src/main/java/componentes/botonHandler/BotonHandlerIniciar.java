package componentes.botonHandler;

import componentes.SeleccionMapa;
import componentes.verificador.*;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class BotonHandlerIniciar implements EventHandler<ActionEvent> {
    App controlador;
    AppModelo modelo;
    LinkedList<TextField> nombresJugadores;
    SeleccionMapa seleccionMapa;

    public BotonHandlerIniciar(LinkedList<TextField> nombresJugadores, App controlador,
                               AppModelo modelo, SeleccionMapa seleccionMapa){
        this.controlador = controlador;
        this.modelo = modelo;
        this.nombresJugadores = nombresJugadores;
        this.seleccionMapa = seleccionMapa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Verificador verificador = Verificador.enlace(
                new VerificadorMapa(),
                new VerificadorDeExistenciaDeNombres(),
                new VerificadorGladiador(),
                new VerificadorDeAlgoRoma()
        );

        verificador.revisar(this.nombresJugadores, this.controlador, this.modelo, this.seleccionMapa);
    }
}
