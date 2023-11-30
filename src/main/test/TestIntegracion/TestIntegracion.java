package TestIntegracion;

import Datos.InformacionMapaEnJSON;
import Datos.InformacionMapaLinealEnMatriz;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Premios.Comida;
import Entidades.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.Bacanal;
import Entidades.Obstaculos.Fiera;
import Entidades.Obstaculos.Lesion;
import Entidades.Premios.Equipamiento;
import Entidades.Premios.JerarquiaEquipos;
import Entidades.Tablero.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestIntegracion {
    private  final Jugador Carpoforo = new Gladiador("Carpoforo");
    private final Jugador Espartaco = new Gladiador("Espartaco");
    private final Jugador Crixo = new Gladiador("Crixo");
    private final Jugador MarcoAtilio = new Gladiador("Marco Atilio");
    private final Jugador Comodo = new Gladiador("Cómodo");

    public Mapa MapaConFieraSalvaje() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Fiera();
        }



        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaSoloConUnEquipo () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];
        elementosMapa[8][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }
    public Mapa MapaConDosEquipos () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[3][0] = new Equipamiento();
        elementosMapa[5][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaSoloConTresEquipos () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];
        elementosMapa[8][0] = new Equipamiento();
        elementosMapa[18][0] = new Equipamiento();
        elementosMapa[12][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaConPiedraAlInicioElRestoVacio () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[0][0] = new Lesion();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaLlenoDePiedras() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Lesion();
        }

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaConBacanalEnElCasillero7() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[6][0] = new Bacanal();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaVacio() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaLlenoDeComida() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i=0;i<elementosMapa.length;i++) {
            elementosMapa[i][0] = new Comida();
        }
        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaQuePermiteGanar() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];

        for (int i=0;i<elementosMapa.length;i++) {
            elementosMapa[i][0] = new Comida();
        }

        elementosMapa[4][1] = new Equipamiento();
        elementosMapa[7][1] = new Equipamiento();

        elementosMapa[9][1] = new Equipamiento();
        elementosMapa[13][1] = new Equipamiento();

        elementosMapa[19][1] = new Equipamiento();
        elementosMapa[22][1] = new Equipamiento();

        elementosMapa[28][1] = new Equipamiento();
        elementosMapa[29][1] = new Equipamiento();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);
        mapa.contruirMapa();
        return mapa;
    }

    public Mapa MapaCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapa.json");

        Mapa mapa = new Mapa(informacionMapaEnJSON);
        mapa.contruirMapa();
        return mapa;
    }

    @Test
    public void NoSePuedeInicializarPartidaConUnSoloJugador() throws ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {

        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        algoRoma.agregarJugador(this.Carpoforo);
        assertThrows(CantidadMinimaDeJugadores.class, () -> algoRoma.comenzarPartida());
    }

    @Test
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinaliza () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 2 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertDoesNotThrow(() -> algoRoma.siguienteJugador());
    }

    @Test
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnError () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            if (i<29) {
                jugador = algoRoma.siguienteJugador();
            }

        }

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
    }


    @Test public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnError () throws PartidaFinalizada, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {

        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
    }

    @Test
    public void SeJuegaUnaPartidaCon32CasillerosElJugadorQueLlegaALaMetaNoGanaYQuedaPosicoinadoEnLa15AlFinalizarElJuego () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();


        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();

        }

        mockDado = new MockDado(3);
        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        jugador.moverse(tablero);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.finalizarTurno();

        Posicion posicionCarpoforo = Carpoforo.miPosicion();
        Posicion posicionEspartaco = Espartaco.miPosicion();

        Posicion posicionEsperada = new Posicion(16,0);

        assertTrue(posicionCarpoforo.esIgual(posicionEsperada));
        assertTrue(posicionEspartaco.esIgual(posicionEsperada));
    }

    @Test
    public void SeJuegaUnaPartidaCasilleroSoloTieneUnEquipoElJugadorLaPuedeEquipar () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConUnEquipo();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));

    }

    @Test
    public void SeJuegaUnaPartidaCasillerosTienenDosEquiposElJugadorPuedeEquipar () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConDosEquipos();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            if (i<29) {
                jugador = algoRoma.siguienteJugador();
            }

        }

        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
    }

    @Test
    public void SeJuegaUnaPartidaCasillerosTienen3Equipos () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConTresEquipos();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));



    }

    @Test
    public void JugadoresSeAtraviesanConUnaPiedraPierdenUnTurno () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConPiedraAlInicioElRestoVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            if (i < 29) {
                jugador = algoRoma.siguienteJugador();
            }

        }

        Posicion posicionEsperada = new Posicion(29,0);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));



    }

    @Test
    public void JugadoresAtraviesanMapaLlenoDePiedrasAvanzanHastaLaMitad () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDePiedras();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            if (i < 29) {
                jugador = algoRoma.siguienteJugador();
            }

        }

        Posicion posicionEsperada = new Posicion(15,0);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));

    }

    @Test
    public void JugadoresAtraviesanMapaConEquipoBaseConUnBacanalEnElCasillero7PierdeEnergia () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConBacanalEnElCasillero7();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 7 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Energia eneriaEsperada = new Energia(16);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5 () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i<= 8 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Energia eneriaEsperada = new Energia(25);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void SeJuegan12TurnosYJugadoresAsciendenASemiSiniorYSiniorAumentandoEnergiaCorrespondiente () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i<= 12 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Energia eneriaEsperada = new Energia(50);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void Juegan7TurnosConMapaConComidaSeEsperaAumentoDeEnergia () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 7 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Energia eneriaEsperadaCarpoforo = new Energia(125);
        Energia eneriaEsperadaEspartaco = new Energia(125);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));

    }

    @Test
    public void Juegan8TurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComidaYSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 9 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Energia eneriaEsperadaCarpoforo = new Energia(160);
        Energia eneriaEsperadaEspartaco = new Energia(160);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
    }

    @Test
    public void JueganTodosLosTurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            if (i<29) {
                jugador = algoRoma.siguienteJugador();
            }

        }

        Energia eneriaEsperadaCarpoforo = new Energia(670);
        Energia eneriaEsperadaEspartaco = new Energia(670);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
        assertNull(algoRoma.elGanador());
    }

    @Test
    public void JueganTodosLosTurnosHayUnGanador () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaQuePermiteGanar();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.entregarElementos(jugador);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(new MockDado(2));

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
        assertNotNull(algoRoma.elGanador());
        assertEquals("Carpoforo",algoRoma.elGanador().miNombre());

    }

    @Test
    public void JueganSeCruzanConFierasSalvajesEnElPrimerCasilleroPierdenTodaLaEnergiaNoSePuedenMoverPeroAumentanLaEnergiaEn5PuntosPorSuSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDadoCarpoforo = new MockDado(1);
        MockDado mockDadoEspartaco = new MockDado(1);

        Carpoforo.agregarDispositivoAzar(mockDadoCarpoforo);
        Espartaco.agregarDispositivoAzar(mockDadoEspartaco);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 1 ; i++ ) {
            for (int j = 0; j<2;j++) {
                jugador.moverse(tablero);
                algoRoma.entregarElementos(jugador);
                algoRoma.finalizarTurno();
                jugador = algoRoma.siguienteJugador();
            }
        }

        Energia energiaEsperadaCarpoforo = new Energia(0);
        Energia energiaEsperadaEspartaco = new Energia(0);


        Posicion posicionEsperadaCarpoforo = new Posicion(1,0);
        Posicion posicionEsperadaEspartaco = new Posicion(1,0);


        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperadaCarpoforo));
        assertTrue(Carpoforo.compararSalud(energiaEsperadaCarpoforo));

        assertTrue(Espartaco.miPosicion().esIgual(posicionEsperadaEspartaco));
        assertTrue(Espartaco.compararSalud(energiaEsperadaEspartaco));

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        energiaEsperadaCarpoforo = new Energia(5);
        energiaEsperadaEspartaco = new Energia(5);


        posicionEsperadaCarpoforo = new Posicion(1,0);
        posicionEsperadaEspartaco = new Posicion(1,0);


        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperadaCarpoforo));
        assertTrue(Carpoforo.compararSalud(energiaEsperadaCarpoforo));

        assertTrue(Espartaco.miPosicion().esIgual(posicionEsperadaEspartaco));
        assertTrue(Espartaco.compararSalud(energiaEsperadaEspartaco));
    }

    /* inician test con mapa de catedra*/

    @Test
    public void NoSePuedeInicializarPartidaConUnSoloJugadorMapaCatedra() throws ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        algoRoma.agregarJugador(this.Carpoforo);
        assertThrows(CantidadMinimaDeJugadores.class, () -> algoRoma.comenzarPartida());
    }


     @Test
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinalizaMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 2 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertDoesNotThrow(() -> algoRoma.siguienteJugador());
    }

    @Test
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnErrorMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 30 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            if (i<29) {
                jugador = algoRoma.siguienteJugador();
            }

        }



        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
    }


    @Test public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnErrorMapaCatedra () throws PartidaFinalizada, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        for (int i = 0; i< 29 ; i++ ) {
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
            jugador.moverse(tablero);
            algoRoma.finalizarTurno();
            jugador = algoRoma.siguienteJugador();
        }

        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
    }

    @Test
    public void SeJuegaUnaPartidaElJugadorQueLlegaALaMetaNoGanaYQuedaPosicoinadoEnElMedioMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();


        Carpoforo.agregarDispositivoAzar(new MockDado(39));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        /*Turno 1*/
        jugador.moverse(tablero);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();

        Posicion posicionCarpoforo = Carpoforo.miPosicion();
        Posicion posicionEspartaco = Espartaco.miPosicion();


        Posicion posicionEsperada = new Posicion(12,3);

        assertTrue(posicionCarpoforo.esIgual(posicionEsperada));

    }

    @Test
    public void SeJuegaUnaPartidaJUgadorEncuentraCasilleroConEquipamientoLoPuedeEquiparYEvoklucionaACascoMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));

    }

    @Test
    public void SeJuegaUnaPartidaSeEquipaDosEquiposElJugadorPuedeEquiparYSuEquipoEsArmaduraMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(new MockDado(4));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
    }

    @Test
    public void SeJuegaUnaPartidaSeObtienen3Equipos () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(new MockDado(4));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));



    }

    @Test
    public void JugadoresSeAtraviesanConUnaPiedraPierdenUnTurnoMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado(3);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        Posicion posicionEsperada = new Posicion(2,5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Espartaco.miPosicion().esIgual(posicionEsperada));



    }

    @Test
    public void JugadoresAtraviesanMapaConEquipoBaseChocanUnBacanalPierdeEnergia () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado(24);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        Energia eneriaEsperada = new Energia(-76);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void JueganHayUnGanadorMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();

        Carpoforo.agregarDispositivoAzar(new MockDado(6));

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();

        Carpoforo.agregarDispositivoAzar(new MockDado(23));

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
        assertNotNull(algoRoma.elGanador());
        assertEquals("Carpoforo",algoRoma.elGanador().miNombre());
    }

    @Test
    public void LlegaPeroNoGanaMapaCatedra () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado(38);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,3);
        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));

    }

    @Test
    public void EnfrentaAFieraConArmaduraYReduceSuEnergiaEn10 () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(8));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(18));
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        Energia energiaEsperada = new Energia(10);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));


    }

    @Test
    public void EnfrentaAFieraConArmaduraYReduceSuEnergiaEn0 () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(8));
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(18));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));

    }

    @Test
    public void EnfrentaAFieraConArmaduraYReduceSuEnergiaEn10V2 () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(14));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Carpoforo.agregarDispositivoAzar(new MockDado(12));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();


        Energia energiaEsperada = new Energia(10);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    public void LaSiguientePosicionEsMayorALaUltimaPeroNoTiraErrorSinoQueLaPosicionAhoraEstaEnElMedio() throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        Mapa mapa = this.MapaCatedra();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado(50);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,3);
        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));

    }

}