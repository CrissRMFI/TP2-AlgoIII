package Vista;

import Componentes.MenuPrincipal;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import edu.fiuba.algo3.App;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class AppVistaInicio {
    private Scene escena;


    public AppVistaInicio(App controlador)  {

        MenuPrincipal menu = new MenuPrincipal(controlador);
        this.escena = new Scene(menu, 700, 600);
    }

    public Scene obtenerEscena() {
        return this.escena;
    }


}
