package Vista;

import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Mapa;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class LoginModelo {

    private LinkedList<Jugador> jugadores = new LinkedList<>();
    private Mapa mapa;

    public void iniciar (Stage stageLogin) throws ElNombreDebeContenerUnMinimoDe4Caracteres {
        stageLogin.close();

        AlgoRoma algoRoma = new AlgoRoma(this.mapa);

        for (int i=0;i<this.jugadores.size();i++) {
            Jugador jugador = this.jugadores.get(i);
            algoRoma.agregarJugador(jugador);
        }

        JuegoVista juegoVista = new JuegoVista();

        //GridPane gridTablero = this.mapa.renderizarTablero();
        //GridPane gridPanelControl = algoRoma.panelControl();

        //juegoVista.agregarVista(gridTablero);
        //juegoVista.agregarVista(gridPanelControl);

        juegoVista.renderizarJuego();

    }

    public void cargarMapa (String ruta) throws ArchivoNoEncontrado, DatoNoValido, DatoNoEncontrado {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);

    }

    public void recibirJugador (Jugador jugador) {
        this.jugadores.add(jugador);
    }
}
