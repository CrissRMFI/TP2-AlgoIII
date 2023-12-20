package edu.fiuba.algo3.entrega_2;

import datos.InformacionMapaEnJSON;
import entidades.AlgoRoma;
import entidades.dispositivoDeAzar.Dado;
import entidades.energia.Energia;
import entidades.errores.*;
import entidades.jugadores.Gladiador;
import entidades.premios.JerarquiaEquipos;
import entidades.tablero.Casillero;
import entidades.tablero.Mapa;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Entrega2 {
    private final Gladiador Carpoforo = new Gladiador("Carpoforo");
    private final Gladiador Espartaco = new Gladiador("Espartaco");

    public Entrega2() throws DatoNoValido {
    }

    public Mapa MapaCatedra(String nombreDelMapa) throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/" + nombreDelMapa);

        return new Mapa(informacionMapaEnJSON);

    }

    public Mapa MapaCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaDeLaCatedra.json");


        return new Mapa(informacionMapaEnJSON);
    }

    @Test
    //Caso de uso 13 (1/7)
    public void siElArchivoNoExisteLanzaExcepcion() {
        assertThrows(ArchivoNoEncontrado.class, () -> new InformacionMapaEnJSON("map31232a.json"));
    }

    @Test
    //Caso de uso 13 (2/7)
    public void siElArchivoNoTieneDatoMapaLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinDatoMapa.json"));
    }

    @Test
    //Caso de uso 13 (3/7)
    public void siElArchivoNoTieneDatoAnchoLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinDatoAncho.json"));
    }

    @Test
    //Caso de uso 13 (4/7)
    public void siElArchivoNoTieneDatoLargoLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinDatoLargo.json"));
    }

    @Test
    //Caso de uso 13 (5/7)
    public void siElDatoAnchoNoEsUnNumeroLanzaExcepcion() {
        assertThrows(DatoNoValido.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaConDatoAnchoNoSiendoUnNumero.json"));
    }

    @Test
    //Caso de uso 13 (6/7)
    public void siElDatoAnchoEsMenorAUnoLanzaExcepcion() {
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaConDatoAnchoNegativo.json"));
    }

    @Test
    //Caso de uso 13 (7/7)
    public void siElDatoLargoEsMenorAUnoLanzaExcepcion() {
        assertThrows(DatoFueraDeRango.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaConDatoLargoNegativo.json"));
    }

    /*
    @Test
    //Caso de uso 14 (1/4)
    public void elObstaculoNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON infoMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConObstaculoRobin.json");
        assertThrows(InteractuableNoValido.class, () -> new Mapa(infoMapaEnJSON));
    }

    @Test
    //Caso de uso 14 (2/4)
    public void elPremioNoEsValidoYLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConPremioFalso.json");
        assertThrows(DatoNoValido.class, () -> new Mapa(informacionMapaEnJSON));
    }
*/

    @Test
    //Caso de uso 14 (3/4)
    public void elJugadorRecibeComidaYAumentaSuVidaEn15() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(2);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(35);

        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
    }


    @Test
    //Caso de uso 14 (2/4)
    public void elCasilleroEstaVacio() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(6);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Espartaco.compararSalud(energiaEsperada));


    }

    @Test
    //Caso de uso 14 (4/4)
    public void elJugadorEsAtacadoPorUnaFieraYPierde20DeEnergia() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Gladiador gladiadorQueJugo;
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(4);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(0);

        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
    }


    @Test
    public void siElArchivoNoTieneDatoCaminoLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinDatoCamino.json"));
    }

    @Test
    public void siElArchivoNoTieneDatoCeldasLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinDatoCeldas.json"));
    }

    @Test
    public void siElArchivoNoTieneNingunaCeldaLanzaExcepcion() {
        assertThrows(DatoNoEncontrado.class, () -> new InformacionMapaEnJSON("src/main/resources/mapas/mapaSinCeldas.json"));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConValorXDeCeldaNegativo.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorXDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConValorXDeCeldaFueraDeRango.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorYDeUnaCeldaEsMayorALargoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConValorYDeCeldaFueraDeRango.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    @Test
    public void siElValorYDeUnaCeldaEsMenorAUnoLanzaExcepcion() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {
        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConValorYCero.json");
        assertThrows(DatoFueraDeRango.class, () -> new Mapa(informacionMapaEnJSON));
    }

    // @Test
    //public void elTipoDeCeldaEsBatman() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido{
    //    InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/resources/mapas/mapaConCeldaTipoBatman.json");
    //    assertThrows(DatoNoValido.class, () -> new Mapa(informacionMapaEnJSON));
    //}


    @Test
    public void RevisandoCelda2DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Gladiador gladiadorQueJugo;
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(2, 7);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.CASCO));
    }


    @Test
    public void RevisandoCelda3DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Gladiador gladiadorQueJugo;
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(2);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();


        Casillero posicionEsperada = new Casillero(2, 6);
        Energia energiaEsperada = new Energia(35);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda4DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(3);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();
        //algoRoma.jugarTurno();
        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(2, 5);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda5DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra("mapaDeLaCatedra.json");
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(4);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(2, 4);
        Energia energiaEsperada = new Energia(0);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    public void RevisandoCelda6DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(5);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(2, 3);
        Energia energiaEsperada = new Energia(0);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));

        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.CASCO));
    }


    @Test
    public void RevisandoCelda7DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(6);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();


        Casillero posicionEsperada = new Casillero(2, 2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }


    @Test
    public void RevisandoCelda36DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(35);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(17, 4);
        Energia energiaEsperada = new Energia(35);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));


        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }


    @Test
    public void RevisandoCelda37DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(36);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();


        Casillero posicionEsperada = new Casillero(17, 3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));

        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void RevisandoCelda38DeMapaDeCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(37);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();


        Casillero posicionEsperada = new Casillero(17, 2);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));

        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void ComoCelda39DeMapaDeCatedraEsLaUltimaEntoncesTerminamosEnLaCelda20() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido, CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, PartidaFinalizada {
        Mapa mapa = this.MapaCatedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(38);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(12, 3);
        Energia energiaEsperada = new Energia(20);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));

        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

}