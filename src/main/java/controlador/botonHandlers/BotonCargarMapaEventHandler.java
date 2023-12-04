package controlador.botonHandlers;

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