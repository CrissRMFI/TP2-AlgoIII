package edu.fiuba.algo3.entrega_2;

import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Errores.*;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Premios.JerarquiaEquipos;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Entrega2 {

    private  final Jugador Carpoforo = new Gladiador("Carpoforo");
    private final Jugador Espartaco = new Gladiador("Espartaco");

    public Mapa MapaCatedra(String nombreDelMapa) throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDelMapa);

        Mapa mapa = new Mapa(informacionMapaEnJSON);
        mapa.contruirMapa();
        return mapa;
    }


    @Test
    //Caso de uso 13 (1/7)
    public void siElArchivoNoExisteLanzaExcepcion(){
        assertThrows(ArchivoNoEncontrado.class, () -> new InformacionMapaEnJSON("map31232a.json"));
    }

    @Test
    //Caso de uso 13 (2/7)
    public void siElArchivoNoTieneDatoMapaLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoMapa.json"));
    }

    @Test
    //Caso de uso 13 (3/7)
    public void siElArchivoNoTieneDatoAnchoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoAncho.json"));
    }

    @Test
    //Caso de uso 13 (4/7)
    public void siElArchivoNoTieneDatoLargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoLargo.json"));
    }

    @Test
    //Caso de uso 13 (5/7)
    public void siElDatoAnchoNoEsUnNumeroLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNoSiendoUnNumero.json"));
    }

    @Test
    //Caso de uso 13 (6/7)
    public void siElDatoAnchoEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNegativo.json"));
    }

    @Test
    //Caso de uso 13 (7/7)
    public void siElDatoLargoEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoLargoNegativo.json"));
    }


    @Test
    //Caso de uso 14 (1/4)
    public void elObstaculoNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConObstaculoRobin.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(InteractuableNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    //Caso de uso 14 (2/4)
    public void elPremioNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConPremioFalso.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }


    @Test
    //Caso de uso 14 (3/4)
    public void elJugadorRecibeComidaYAumentaSuVidaEn15() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra("mapaDePrueba.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 14 (2/4)
    public void elCasilleroEstaVacio() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConCeldaTipoVacia.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(CasilleroNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    //Caso de uso 14 (4/4)
    public void elJugadorEsAtacadoPorUnaFieraYPierde20DeEnergia() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra("mapaDePrueba.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Energia eneriaEsperada = new Energia(0);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
    }


    @Test
    public void siElArchivoNoTieneDatoCaminoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCamino.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCeldasLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCeldas.json"));
    }

    @Test
    public void siElArchivoNoTieneNingunaCeldaLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinCeldas.json"));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaNegativo.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoFueraDeRango.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorXDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaFueraDeRango.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoFueraDeRango.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorYDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYDeCeldaFueraDeRango.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoFueraDeRango.class, () -> mapa.contruirMapa());
    }

    @Test
    public void siElValorYDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYCero.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoFueraDeRango.class, () -> mapa.contruirMapa());
    }

    @Test
    public void elTipoDeCeldaEsBatman() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConCeldaTipoBatman.json");
        Mapa mapa = new Mapa(informacionMapaEnJSON);
        assertThrows(DatoNoValido.class, () -> mapa.contruirMapa());
    }

    @Test
    public void RevisandoCelda2DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(1));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(2,7);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda3DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(2,6);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda4DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(3));
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

        Posicion posicionEsperada = new Posicion(2,5);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        posicionEsperada = new Posicion(2,2);
        energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda5DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(2,4);
        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda6DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(5));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(2,3);
        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda7DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(6));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(2,2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda8DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(7));
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

        Posicion posicionEsperada = new Posicion(2,1);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));

        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();
        jugador = algoRoma.siguienteJugador();
        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        posicionEsperada = new Posicion(9,1);
        energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda9DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(8));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(3,1);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda10DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(9));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(4,1);
        Energia energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda11DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(10));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(5,1);
        Energia energiaEsperada = new Energia(-20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda12DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(11));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(6,1);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda14DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(13));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(8,1);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda15DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(14));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(9,1);
        Energia energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda16DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(15));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(10,1);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda17DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(16));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(11,1);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda19DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(18));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,2);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda20DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(19));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda21DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(20));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,4);
        Energia energiaEsperada = new Energia(15);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda22DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(21));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,5);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda23DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(22));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,6);
        Energia energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda24DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(23));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,7);
        Energia energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda25DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(24));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,8);
        Energia energiaEsperada = new Energia(-76);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda26DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(25));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,9);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda28DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(27));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(14,9);
        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda29DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(28));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(15,9);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda30DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(29));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(16,9);
        Energia energiaEsperada = new Energia(-96);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda31DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(30));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,9);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda33DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(32));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,7);
        Energia energiaEsperada = new Energia(-108);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda34DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(33));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,6);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda35DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(34));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,5);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda36DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(35));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,4);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda37DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(36));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda38DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(37));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(17,2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void ComoCelda39DeMapaDeCatedraEsLaUltimaEntoncesTerminamosEnLaCelda20() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(38));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    /*
    @Test
    public void AgarraElEquipamientoDeLaUltimaCeldaPeroNoElDeLaCeldaDelMedio() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapaConEquipamientoEnLaUltimaCelda.json");
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(38));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse(tablero);
        algoRoma.entregarElementos(jugador);
        algoRoma.finalizarTurno();

        Posicion posicionEsperada = new Posicion(12,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.miPosicion().esIgual(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

     */

}