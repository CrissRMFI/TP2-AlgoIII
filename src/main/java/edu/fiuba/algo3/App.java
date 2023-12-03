package edu.fiuba.algo3;

import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Elementos.MockDado;
import Entidades.Errores.ArchivoNoEncontrado;
import Entidades.Errores.DatoNoEncontrado;
import Entidades.Errores.DatoNoValido;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.Tablero;
import Vista.LoginVista;
import edu.fiuba.algo3.modelo.EscenaDeInicio;
import edu.fiuba.algo3.modelo.EscenaDeJuego;
import edu.fiuba.algo3.modelo.EscenaNombrarJugadoresYElegirMapa;
import Datos.MensajesUsuario;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;


public class App extends Application {

    @Override
    public void start(Stage stage) throws ArchivoNoEncontrado, DatoNoValido, DatoNoEncontrado, ElNombreDebeContenerUnMinimoDe4Caracteres {
        MensajesUsuario mensajesUsuario = new MensajesUsuario();
        stage.setTitle(mensajesUsuario.TituloAplicacion());

        EscenaNombrarJugadoresYElegirMapa generaEscena = new EscenaNombrarJugadoresYElegirMapa(stage);
        Scene escenaDeElegir = generaEscena.devolverEscena();

        EscenaDeInicio generaEscenaDeInicio = new EscenaDeInicio(stage, escenaDeElegir);
        Scene escenaDeInicio = generaEscenaDeInicio.devolverEscena();

        stage.setScene(escenaDeInicio);
        stage.show();



        //EscenaDeInicio escenaDeInicio = new EscenaDeInicio(stage);
        //EscenaDeJuego escenaDeJuego = new EscenaDeJuego(stage);
        //EscenaNombrarJugadoresYElegirMapa escenaDeOpciones = new EscenaNombrarJugadoresYElegirMapa(stage);
        /*
        LoginVista login = new LoginVista();
        login.crearVista();
         */




        /*
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapa.json");
        InformacionMapaEnJSON informacionMapaEnJSON2 = new InformacionMapaEnJSON("src/main/java/Datos/mapaEjemplo.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON2);
        mapa.contruirMapa();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();
        Jugador Carpoforo = new Gladiador("Carpoforo");
        Jugador Espartaco = new Gladiador("Espartaco");
        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(Carpoforo);
        jugadores.add(Espartaco);
        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        EscenaDeJuego escenaDeJuego = new EscenaDeJuego(stage, algoRoma, jugadores, tablero);

         */



    }

    public static void main(String[] args) {
        launch();
    }

}