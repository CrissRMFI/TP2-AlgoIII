package Vista;

import Datos.InformacionMapa;
import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.Tablero;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class LoginModelo {

    private LinkedList<Jugador> jugadores = new LinkedList<>();
    private Mapa mapa;
    private TableroVista tablero;

    public void iniciar (Stage stageLogin) throws ElNombreDebeContenerUnMinimoDe4Caracteres,IOException {
        stageLogin.close();
        Tablero tablero = new Tablero(this.mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);

        for (int i=0;i<this.jugadores.size();i++) {
            Jugador jugador = this.jugadores.get(i);
            algoRoma.agregarJugador(jugador);
        }

        this.tablero.mostrarTablero();

    }

    public void cargarMapa (String ruta) throws IOException {
        InformacionMapa informacionMapa = new InformacionMapaEnJSON(ruta);
        this.mapa = new Mapa(informacionMapa);
        this.mapa.contruirMapa();
        this.tablero = new TableroVista();
        this.tablero.cargarCasilleros(informacionMapa);
    }
    public void recibirJugador (Jugador jugador) {
        this.jugadores.add(jugador);
    }
}
