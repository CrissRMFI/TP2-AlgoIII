package vista;

import componentes.MenuPrincipal;
import edu.fiuba.algo3.App;
import javafx.scene.Scene;

public class AppVistaInicio {
    private Scene escena;


    public AppVistaInicio(App controlador) {

        MenuPrincipal menu = new MenuPrincipal(controlador);
        this.escena = new Scene(menu, 700, 600);
    }

    public Scene obtenerEscena() {
        return this.escena;
    }


}
