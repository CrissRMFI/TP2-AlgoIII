package edu.fiuba.algo3.entrega_2;

import Datos.InformacionMapaEnJSON;
import Entidades.AlgoRoma;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Errores.*;
import Entidades.Jugadores.Gladiador;
import Entidades.Premios.JerarquiaEquipos;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Entrega2 {

    private  final Gladiador Carpoforo = new Gladiador("Carpoforo");
    private final Gladiador Espartaco = new Gladiador("Espartaco");

    public Mapa MapaCatedra(String nombreDelMapa) throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/" + nombreDelMapa);

        return new Mapa(informacionMapaEnJSON);

    }

    public Mapa MapaCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapa.json");


        Mapa mapa = new Mapa(informacionMapaEnJSON);

        return mapa;
    }
    @Test
    //Caso de uso 13 (1/7)
    public void siElArchivoNoExisteLanzaExcepcion(){
        assertThrows(ArchivoNoEncontrado.class, () -> new InformacionMapaEnJSON("map31232a.json"));
    }

    @Test
    //Caso de uso 13 (2/7)
    public void siElArchivoNoTieneDatoMapaLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoMapa.json"));
    }

    @Test
    //Caso de uso 13 (3/7)
    public void siElArchivoNoTieneDatoAnchoLanzaExcepcion(){
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoAncho.json"));
    }

    @Test
    //Caso de uso 13 (4/7)
    public void siElArchivoNoTieneDatoLargoLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoLargo.json"));
    }

    @Test
    //Caso de uso 13 (5/7)
    public void siElDatoAnchoNoEsUnNumeroLanzaExcepcion() {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNoSiendoUnNumero.json"));
    }

    @Test
    //Caso de uso 13 (6/7)
    public void siElDatoAnchoEsMenorAUnoLanzaExcepcion(){
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoAnchoNegativo.json"));
    }

    @Test
    //Caso de uso 13 (7/7)
    public void siElDatoLargoEsMenorAUnoLanzaExcepcion() {
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaConDatoLargoNegativo.json"));
    }

    /*
    @Test
    //Caso de uso 14 (1/4)
    public void elObstaculoNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON infoMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConObstaculoRobin.json");
        assertThrows(InteractuableNoValido.class, () -> new Mapa(infoMapaEnJSON));
    }

    @Test
    //Caso de uso 14 (2/4)
    public void elPremioNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConPremioFalso.json");
        assertThrows(DatoNoValido.class, () -> new Mapa(informacionMapaEnJSON));
    }
*/

    @Test
    //Caso de uso 14 (3/4)
    public void elJugadorRecibeComidaYAumentaSuVidaEn15() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 14 (2/4)
    public void elCasilleroEstaVacio() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido,CantidadMinimaDeJugadores,PartidaFinalizada{
       Mapa mapa = this.MapaCatedra();
       AlgoRoma algoRoma = new AlgoRoma(mapa);
       MockDado mockDado = new MockDado(6);

       Carpoforo.agregarDispositivoAzar(mockDado);
       Espartaco.agregarDispositivoAzar(mockDado);

       algoRoma.agregarJugador(Carpoforo);
       algoRoma.agregarJugador(Espartaco);

       Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();
       jugador.moverse();
       jugador.obtenerElementos();
       jugador.finalizarTurno(algoRoma);

       jugador = (Gladiador) algoRoma.siguienteJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Espartaco.compararSalud(energiaEsperada));


    }

    @Test
    //Caso de uso 14 (4/4)
    public void elJugadorEsAtacadoPorUnaFieraYPierde20DeEnergia() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Energia eneriaEsperada = new Energia(0);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
    }


    @Test
    public void siElArchivoNoTieneDatoCaminoLanzaExcepcion()  {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCamino.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCeldasLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinDatoCeldas.json"));
    }

    @Test
    public void siElArchivoNoTieneNingunaCeldaLanzaExcepcion()  {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/java/Datos/mapaSinCeldas.json"));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaNegativo.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorXDeCeldaFueraDeRango.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorYDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYDeCeldaFueraDeRango.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorYDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConValorYCero.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }
/*
    @Test
    public void elTipoDeCeldaEsBatman() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapaConCeldaTipoBatman.json");
        assertThrows(DatoNoValido.class, () -> new Mapa(informacionMapaEnJSON));
    }

 */

    @Test
    public void RevisandoCelda2DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(1));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(2,7);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda3DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(2,6);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda4DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(3));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();
        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Casillero posicionEsperada = new Casillero(2,5);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));


    }

    @Test
    public void RevisandoCelda5DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra("mapa.json");
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(4));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();

        Casillero posicionEsperada = new Casillero(2,4);
        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda6DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(5));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(2,3);
        Energia energiaEsperada = new Energia(0);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }


    @Test
    public void RevisandoCelda7DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(6));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(2,2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));


        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }


    @Test
    public void RevisandoCelda36DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(35));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(17,4);
        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));


        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda37DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(36));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(17,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));


        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda38DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(37));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(17,2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));


        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void ComoCelda39DeMapaDeCatedraEsLaUltimaEntoncesTerminamosEnLaCelda20() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, PartidaFinalizada{
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(new MockDado(38));
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);



        Casillero posicionEsperada = new Casillero(12,3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperada));

        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }



}