package Vista;

import Datos.MensajesUsuario;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class LoginVistaModelo {

    private final LinkedList<String> usuarios = new LinkedList<>();
    private final LoginModelo model = new LoginModelo();
    private Stage stage;

    public void agregarUsuario (String nombre) {
        this.usuarios.add(nombre);
    }
    public void iniciar() throws ElNombreDebeContenerUnMinimoDe4Caracteres,IOException {
        MensajesUsuario m = new MensajesUsuario();

        if (this.usuarios.size() < 2) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(m.CantidadMinimaDeJugadores());
            alert.show();
        } else {
            for (int i=0; i< this.usuarios.size(); i++) {
                Jugador jugador = this.crearGladiador(this.usuarios.get(i));
                this.model.recibirJugador(jugador);
            }

            this.model.iniciar(this.stage);
        }



    }

    public void implementarStage (Stage stage) {
        this.stage = stage;
    }
    public void cargarMapa (String ruta) throws IOException{
        this.model.cargarMapa(ruta);
    }

    private Jugador crearGladiador (String nombre) {
        return new Gladiador(nombre);
    }
}