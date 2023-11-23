package TestIntegracion;

import Entidades.AlgoRoma;
import Entidades.Elementos.Comida;
import Entidades.Elementos.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Equipo.*;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Errores.PartidaFinalizada;
import Entidades.Errores.PartidaNoFinalizada;
import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;
import Entidades.Obstaculos.Bacanal;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Obstaculos.Piedra;
import Entidades.Tablero.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestIntegracion {
    public Mapa MapaConFieraSalvaje() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaSoloConArmaduras () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Armadura();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaSoloUnCasco () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];
        elementosMapa[8][0] = new Casco();

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaSoloConArmadurasEscudoYEspadaYLlave () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        ListaCircular<Equipo> equipos = new ListaCircular<Equipo>();
        equipos.agregarElemento(new Armadura());
        equipos.agregarElemento(new EscudoYEspada());
        equipos.agregarElemento(new Llave());

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = equipos.seleccionAleatoria();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa MapaConCascoAlInicioYEnMedioYDespuesEscudoYEspadaYLlave () {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        ListaCircular<Equipo> equipos = new ListaCircular<Equipo>();
        equipos.agregarElemento(new EscudoYEspada());
        equipos.agregarElemento(new Llave());

        elementosMapa[0][0] = new Casco();
        for (int i = 1; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = equipos.seleccionAleatoria();
        }

        elementosMapa[15][0] = new Casco();
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

        elementosMapa[4][1] = new Casco();
        elementosMapa[7][1] = new Casco();

        elementosMapa[9][1] = new Armadura();
        elementosMapa[13][1] = new Armadura();

        elementosMapa[19][1] = new EscudoYEspada();
        elementosMapa[22][1] = new EscudoYEspada();

        elementosMapa[28][1] = new Llave();
        elementosMapa[29][1] = new Llave();


        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }
    @Test
    public void NoSePuedeInicializarPartidaConUnSoloJugador(){

        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        Gladiador Carpoforo = new Gladiador();
        algoRoma.agregarJugador(Carpoforo);
        assertThrows(CantidadMinimaDeJugadores.class, () -> algoRoma.comenzarPartida());
    }

    @Test
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinaliza () throws CantidadMinimaDeJugadores, PartidaFinalizada, SinDispositivoDeAzar {
        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnError () throws CantidadMinimaDeJugadores, PartidaFinalizada,SinDispositivoDeAzar {
        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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

        jugador.moverse(tablero);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.finalizarTurno();

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
    }


    @Test
    public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnError () throws PartidaFinalizada, PartidaNoFinalizada,CantidadMinimaDeJugadores,SinDispositivoDeAzar {

        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void SeJuegaUnaPartidaCon30CasillerosNoSeGanaYElJugadorQuedaPosicoinadoEnLa15AlFinalizarElJuego () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void SeJuegaUnaPartidaCasillerosSoloTienenArmaduraElJugadorNoLaPuedeEquipar () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaSoloConArmaduras();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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

        assertFalse(Carpoforo.compararEquipo(Equipamiento.ARMADURA));
        assertFalse(Espartaco.compararEquipo(Equipamiento.ARMADURA));
        assertTrue(Carpoforo.compararEquipo(Equipamiento.EQUIPOBASE));
        assertTrue(Espartaco.compararEquipo(Equipamiento.EQUIPOBASE));

    }

    @Test
    public void SeJuegaUnaPartidaCasillerosSoloTienenCascoElJugadorQueLlegaPrimeroLaPuedeEquipar () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaSoloUnCasco();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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

        assertTrue(Espartaco.compararEquipo(Equipamiento.EQUIPOBASE));
        assertTrue(Carpoforo.compararEquipo(Equipamiento.CASCO));
        assertFalse(Espartaco.compararEquipo(Equipamiento.CASCO));
        assertFalse(Carpoforo.compararEquipo(Equipamiento.EQUIPOBASE));

    }

    @Test
    public void SeJuegaUnaPartidaCasillerosTienenEquiposQueNoSonEquipablesAPartirDelEquipoBase () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaSoloConArmadurasEscudoYEspadaYLlave();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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

        assertFalse(Espartaco.compararEquipo(Equipamiento.ARMADURA));
        assertFalse(Espartaco.compararEquipo(Equipamiento.ESCUDOYESPADA));
        assertFalse(Espartaco.compararEquipo(Equipamiento.LLAVE));


        assertFalse(Carpoforo.compararEquipo(Equipamiento.ARMADURA));
        assertFalse(Carpoforo.compararEquipo(Equipamiento.ESCUDOYESPADA));
        assertFalse(Carpoforo.compararEquipo(Equipamiento.LLAVE));

        assertTrue(Espartaco.compararEquipo(Equipamiento.EQUIPOBASE));
        assertTrue(Carpoforo.compararEquipo(Equipamiento.EQUIPOBASE));

    }

    @Test
    public void SeEquipaConCascoNoHayArmaduraPeroSiHayEscudoYEspadaYLlaveNoLosPuedeEquipar () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaConCascoAlInicioYEnMedioYDespuesEscudoYEspadaYLlave();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();



        assertFalse(Espartaco.compararEquipo(Equipamiento.EQUIPOBASE));
        assertFalse(Espartaco.compararEquipo(Equipamiento.ESCUDOYESPADA));
        assertFalse(Espartaco.compararEquipo(Equipamiento.LLAVE));

        assertFalse(Carpoforo.compararEquipo(Equipamiento.EQUIPOBASE));
        assertFalse(Carpoforo.compararEquipo(Equipamiento.ESCUDOYESPADA));
        assertFalse(Carpoforo.compararEquipo(Equipamiento.LLAVE));

        assertTrue(Espartaco.compararEquipo(Equipamiento.CASCO));
        assertTrue(Carpoforo.compararEquipo(Equipamiento.CASCO));

    }

    @Test
    public void JugadoresSeAtraviesanConUnaPiedraPierdenUnTurno () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaConPiedraAlInicioElRestoVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void JugadoresAtraviesanMapaLlenoDePiedrasAvanzanHastaLaMitad () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaLlenoDePiedras();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void JugadoresAtraviesanMapaConEquipoBaseConUnBacanalEnElCasillero7PierdeEnergia () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaConBacanalEnElCasillero7();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5 () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void SeJuegan12TurnosYJugadoresAsciendenASemiSiniorYSiniorAumentandoEnergiaCorrespondiente () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaVacio();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
    public void Juegan7TurnosConMapaConComidaSeEsperaAumentoDeEnergia () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
        Energia eneriaEsperadaEspartaco = new Energia(20);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));

    }

    @Test
    public void Juegan8TurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar{
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
        Energia eneriaEsperadaEspartaco = new Energia(25);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
    }

    @Test
    public void JueganTodosLosTurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar,PartidaNoFinalizada{
        Mapa mapa = this.MapaLlenoDeComida();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
        Energia eneriaEsperadaEspartaco = new Energia(220);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
        assertNull(algoRoma.elGanador());
    }

    @Test
    public void JueganTodosLosTurnosHayUnGanador () throws CantidadMinimaDeJugadores,PartidaFinalizada,SinDispositivoDeAzar,PartidaNoFinalizada{
        Mapa mapa = this.MapaQuePermiteGanar();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador();
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador();
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
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();



        assertNotNull(algoRoma.elGanador());

    }


}










