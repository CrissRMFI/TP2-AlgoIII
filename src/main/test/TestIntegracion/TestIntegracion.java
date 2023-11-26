package TestIntegracion;

import Entidades.AlgoRoma;
import Entidades.Errores.ElNombreDebeContenerUnMinimoDe4Caracteres;
import Entidades.Premios.Comida;
import Entidades.Elementos.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Equipo.*;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Errores.PartidaFinalizada;
import Entidades.Errores.PartidaNoFinalizada;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;
import Entidades.Obstaculos.Bacanal;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Obstaculos.Piedra;
import Entidades.Tablero.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestIntegracion {
    private  final Jugador Carpoforo = new Gladiador("Carpoforo");
    private final Jugador Espartaco = new Gladiador("Espartaco");
    private final Jugador Crixo = new Gladiador("Crixo");
    private final Jugador MarcoAtilio = new Gladiador("Marco Atilio");
    private final Jugador Comodo = new Gladiador("Cómodo");

    public Mapa MapaConFieraSalvaje() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaSoloConUnEquipo () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];
        elementosMapa[8][0] = new Equipo();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }
    public Mapa MapaConDosEquipos () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[3][0] = new Equipo();
        elementosMapa[5][0] = new Equipo();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaSoloConTresEquipos () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];
        elementosMapa[8][0] = new Equipo();
        elementosMapa[18][0] = new Equipo();
        elementosMapa[12][0] = new Equipo();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaConPiedraAlInicioElRestoVacio () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[0][0] = new Piedra();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaLlenoDePiedras() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Piedra();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaConBacanalEnElCasillero7() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[6][0] = new Bacanal();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaVacio() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaLlenoDeComida() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i=0;i<elementosMapa.length;i++) {
            elementosMapa[i][0] = new Comida();
        }
        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaQuePermiteGanar() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];

        for (int i=0;i<elementosMapa.length;i++) {
            elementosMapa[i][0] = new Comida();
        }

        elementosMapa[4][1] = new Equipo();
        elementosMapa[7][1] = new Equipo();

        elementosMapa[9][1] = new Equipo();
        elementosMapa[13][1] = new Equipo();

        elementosMapa[19][1] = new Equipo();
        elementosMapa[22][1] = new Equipo();

        elementosMapa[28][1] = new Equipo();
        elementosMapa[29][1] = new Equipo();


        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaConTresTiposDeObstaculos() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        elementosMapa[4][0] = new Bacanal();
        elementosMapa[7][0] = new FieraSalvaje();

        elementosMapa[9][0] = new Piedra();
        elementosMapa[13][0] = new Bacanal();

        elementosMapa[19][0] = new Piedra();
        elementosMapa[22][0] = new Piedra();

        elementosMapa[28][0] = new FieraSalvaje();
        elementosMapa[29][0] = new FieraSalvaje();


        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    @Test
    public void NoSePuedeInicializarPartidaConUnSoloJugador() throws ElNombreDebeContenerUnMinimoDe4Caracteres {

        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        algoRoma.agregarJugador(this.Carpoforo);
        assertThrows(CantidadMinimaDeJugadores.class, () -> algoRoma.comenzarPartida());
    }

    @Test
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinaliza () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres {
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
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnError () throws CantidadMinimaDeJugadores, PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres {
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


    @Test public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnError () throws PartidaFinalizada,CantidadMinimaDeJugadores,ElNombreDebeContenerUnMinimoDe4Caracteres{

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
    public void SeJuegaUnaPartidaCon30CasillerosElJugadorQuedaLlegaALaMetaNoGanaYQuedaPosicoinadoEnLa15AlFinalizarElJuego () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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

        Posicion posicionEsperada = new PosicionLineal(15);

        assertTrue(posicionCarpoforo.esIgual(posicionEsperada));
        assertTrue(posicionEspartaco.esIgual(posicionEsperada));
    }

    @Test
    public void SeJuegaUnaPartidaCasilleroSoloTieneUnEquipoElJugadorLaPuedeEquipar () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void SeJuegaUnaPartidaCasillerosTienenDosEquiposElJugadorPuedeEquipar () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void SeJuegaUnaPartidaCasillerosTienen3Equipos () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void JugadoresSeAtraviesanConUnaPiedraPierdenUnTurno () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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

        Posicion posicionEsperada = new PosicionLineal(29);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));

        

    }

    @Test
    public void JugadoresAtraviesanMapaLlenoDePiedrasAvanzanHastaLaMitad () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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

        Posicion posicionEsperada = new PosicionLineal(15);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));

    }

    @Test
    public void JugadoresAtraviesanMapaConEquipoBaseConUnBacanalEnElCasillero7PierdeEnergia () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5 () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void SeJuegan12TurnosYJugadoresAsciendenASemiSiniorYSiniorAumentandoEnergiaCorrespondiente () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void Juegan7TurnosConMapaConComidaSeEsperaAumentoDeEnergia () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void Juegan8TurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComidaYSeniority () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void JueganTodosLosTurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority () throws CantidadMinimaDeJugadores,PartidaFinalizada,PartidaNoFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void JueganTodosLosTurnosHayUnGanador () throws CantidadMinimaDeJugadores,PartidaFinalizada,PartidaNoFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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
    public void JueganSeCruzanConFierasSalvajesEnElPrimerCasilleroPierdenTodaLaEnergiaNoSePuedenMoverPeroAumentanLaEnergiaEn5PuntosPorSuSeniority () throws CantidadMinimaDeJugadores,PartidaFinalizada,ElNombreDebeContenerUnMinimoDe4Caracteres{
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


        Posicion posicionEsperadaCarpoforo = new PosicionLineal(1);
        Posicion posicionEsperadaEspartaco = new PosicionLineal(1);


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


        posicionEsperadaCarpoforo = new PosicionLineal(1);
        posicionEsperadaEspartaco = new PosicionLineal(1);


        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperadaCarpoforo));
        assertTrue(Carpoforo.compararSalud(energiaEsperadaCarpoforo));

        assertTrue(Espartaco.miPosicion().esIgual(posicionEsperadaEspartaco));
        assertTrue(Espartaco.compararSalud(energiaEsperadaEspartaco));
    }
}