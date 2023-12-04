package Vista.BotonHandlers;

import Datos.MensajesErrores;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

/*
public class BotonCargarMapaEventHandler implements EventHandler<ActionEvent> {
    Stage stage;
    FileChooser fileChooser;
    public BotonCargarMapaEventHandler(Stage stage, FileChooser fileChooser){
        this.stage = stage;
        this.fileChooser = fileChooser;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            File archivo = fileChooser.showOpenDialog(this.stage);
            this.viewModel.cargarMapa(archivo.getAbsolutePath());
        } catch (IOException | ArchivoNoEncontrado | DatoNoValido | DatoNoEncontrado error) {
            MensajesErrores me = new MensajesErrores();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(me.ErrorAlCargarElMapa());
            alert.show();
        }
    }
}
*/