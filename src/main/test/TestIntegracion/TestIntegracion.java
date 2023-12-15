package TestIntegracion;

import datos.InformacionMapaLinealEnMatriz;
import entidades.AlgoRoma;
import entidades.dispositivoDeAzar.Dado;
import entidades.errores.*;
import entidades.Interactuable;
import entidades.obstaculos.SinObstaculo;
import entidades.premios.Comida;
import entidades.energia.Energia;
import entidades.jugadores.Gladiador;
import entidades.jugadores.Jugador;
import entidades.obstaculos.Bacanal;
import entidades.obstaculos.Lesion;
import entidades.premios.Equipamiento;
import entidades.premios.JerarquiaEquipos;
import entidades.tablero.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestIntegracion {
    private final Jugador Carpoforo = new Gladiador("Carpoforo");
    private final Jugador Espartaco = new Gladiador("Espartaco");

    private Mapa MapaSoloConUnEquipo() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];


        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaConDosEquipos() throws DatoNoValido {
        int cantidadCasilleros = 30;

        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[3][0] = new Equipamiento();
        elementosMapa[7][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);

    }

    private Mapa MapaSoloConTresEquipos() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Equipamiento();
        elementosMapa[17][0] = new Equipamiento();
        elementosMapa[26][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaConPiedraAlInicioElRestoVacio() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Lesion();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaConBacanalEnElCasillero7() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[6][0] = new Bacanal();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    public Mapa MapaVacio() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaLlenoDeComida() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        for (int i = 0; i < elementosMapa.length; i++) {
            elementosMapa[i][0] = new Comida();
        }
        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaQuePermiteGanar() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];


        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Comida();
            elementosMapa[i][1] = new SinObstaculo();
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

        return new Mapa(informacionMapaLinealEnMatriz);
    }


    private void jugarTurnosGladiador(int cantidad, AlgoRoma algoRoma) throws PartidaFinalizada, CantidadMinimaDeJugadores {

        for (int i = 0; i < cantidad; i++) {
            algoRoma.jugarTurno();

            algoRoma.jugarTurno();


            //if (i<cantidad-1) {
            //    gladiador = (Gladiador) algoRoma.siguienteJugador();
            //}

        }
    }

    @Test
    public void NoSePuedeInicializarPartidaConUnSoloJugador() throws ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {

        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        algoRoma.agregarJugador(this.Carpoforo);
        assertThrows(CantidadMinimaDeJugadores.class, () -> algoRoma.comenzarPartida());
    }

    @Test
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinaliza() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(2, algoRoma);

        assertDoesNotThrow(() -> algoRoma.jugarTurno());
    }

    @Test
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnError() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(30, algoRoma);

        assertThrows(PartidaFinalizada.class, () -> algoRoma.jugarTurno());
    }


    @Test
    public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnError() throws PartidaFinalizada, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {

        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(29, algoRoma);
        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
    }


    @Test
    public void SeJuegaUnaPartidaCon32CasillerosElJugadorQueLlegaALaMetaNoGanaYQuedaPosicoinadoEnLa15AlFinalizarElJuego() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Gladiador gladiadorQueJugo;
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(31);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero posicionEsperada = new Casillero(16, 0);

        assertTrue(gladiadorQueJugo.compararPosicion(posicionEsperada));
    }


    @Test
    public void SeJuegaUnaPartidaCasilleroSoloTieneUnEquipoElJugadorLaPuedeEquipar() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConUnEquipo();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(9);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(1, algoRoma);

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
    }

    @Test
    public void SeJuegaUnaPartidaCasillerosTienenDosEquiposElJugadorPuedeEquipar() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConDosEquipos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(4);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(2, algoRoma);

        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
    }

    @Test
    public void SeJuegaUnaPartidaMapaConTresEquipoSeEsperaEquipamientoARMADURA() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConTresEquipos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(9);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();
        this.jugarTurnosGladiador(3, algoRoma);

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
    public void JugadoresSeAtraviesanConUnaPiedraPierdenUnTurno() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConPiedraAlInicioElRestoVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(2, algoRoma);
        Casillero casilleroCamino = new Casillero(1, 0); //Porque no se pudo mover

        assertTrue(Carpoforo.compararPosicion(casilleroCamino));

    }

    @Test
    public void JugadoresAtraviesanMapaConEquipoBaseConUnBacanalEnElCasillero7PierdeEnergia() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConBacanalEnElCasillero7();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(7);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(1, algoRoma);

        Energia eneriaEsperada = new Energia(-8);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));
    }

    @Test
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(9, algoRoma);

        Energia eneriaEsperada = new Energia(25);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));
    }

    @Test
    public void SeJuegan12TurnosYJugadoresAsciendenASemiSiniorYSiniorAumentandoEnergiaCorrespondiente() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(13, algoRoma);

        Energia eneriaEsperada = new Energia(50);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }


    @Test
    public void Juegan7TurnosConMapaConComidaSeEsperaAumentoDeEnergia() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(7, algoRoma);

        Energia eneriaEsperadaCarpoforo = new Energia(125);
        Energia eneriaEsperadaEspartaco = new Energia(125);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
    }

    @Test
    public void Juegan8TurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComidaYSeniority() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();
        this.jugarTurnosGladiador(9, algoRoma);

        Energia eneriaEsperadaCarpoforo = new Energia(160);
        Energia eneriaEsperadaEspartaco = new Energia(160);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
    }

    @Test
    public void JueganTodosLosTurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority() throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(30, algoRoma);

        Energia eneriaEsperadaCarpoforo = new Energia(670);
        Energia eneriaEsperadaEspartaco = new Energia(670);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
        assertEquals("No hay ganador", algoRoma.elGanador().yoSoy());
    }


    @Test
    public void JueganTodosLosTurnosHayUnGanador() throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaQuePermiteGanar();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Carpoforo.agregarDispositivoAzar(dado);
        Espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(29, algoRoma);

        Mockito.when(dado.lanzar()).thenReturn(3);

        algoRoma.jugarTurno();

        assertThrows(PartidaFinalizada.class, () -> algoRoma.jugarTurno());
        assertEquals("Carpoforo", algoRoma.elGanador().yoSoy());
    }
}