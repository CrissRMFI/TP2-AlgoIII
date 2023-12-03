package TestIntegracion;

import Datos.InformacionMapaEnJSON;
import Datos.InformacionMapaLinealEnMatriz;
import Entidades.AlgoRoma;
import Entidades.ElementoMapa;
import Entidades.Errores.*;
import Entidades.Obstaculos.SinObstaculo;
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
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Fiera();
        }



        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaSoloConUnEquipo () throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];


        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }
    public Mapa MapaConDosEquipos () throws DatoNoValido {
        int cantidadCasilleros = 30;

        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[3][0] = new Equipamiento();
        elementosMapa[7][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaSoloConTresEquipos () throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Equipamiento();
        elementosMapa[17][0] = new Equipamiento();
        elementosMapa[26][0] = new Equipamiento();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaConPiedraAlInicioElRestoVacio () throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Lesion();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaConBacanalEnElCasillero7() throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[6][0] = new Bacanal();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaVacio() throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaLlenoDeComida() throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        for (int i=0;i<elementosMapa.length;i++) {
            elementosMapa[i][0] = new Comida();
        }
        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaQuePermiteGanar() throws DatoNoValido {
        int cantidadCasilleros = 30;
        ElementoMapa[][] elementosMapa = new ElementoMapa[cantidadCasilleros][2];


        for (int i=0;i<cantidadCasilleros;i++) {
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

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    public Mapa MapaCatedra() throws ArchivoNoEncontrado, DatoNoEncontrado, DatoNoValido {

        InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON("src/main/java/Datos/mapa.json");


        Mapa mapa = new Mapa(informacionMapaEnJSON);

        return mapa;
    }

    private void jugarTurnosGladiador (int cantidad, Gladiador gladiador,AlgoRoma algoRoma) throws PartidaFinalizada {

        for (int i = 0; i< cantidad ; i++ ) {
            gladiador.moverse();
            gladiador.obtenerElementos();
            gladiador.finalizarTurno(algoRoma);
            gladiador = (Gladiador) algoRoma.siguienteJugador();
            gladiador.moverse();
            gladiador.obtenerElementos();
            gladiador.finalizarTurno(algoRoma);

            if (i<cantidad-1) {
                gladiador = (Gladiador) algoRoma.siguienteJugador();
            }

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
    public void DosGladiadoresJueganDosTurnosYLaPartidaNoFinaliza () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(2,jugador,algoRoma);

        assertDoesNotThrow(() -> algoRoma.siguienteJugador());
    }

    @Test
    public void DosGladiadoresJueganTodosLosTurnosSeQuiereJugarUnaVezMasEntraEnError () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(30,jugador,algoRoma);

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
    }


    @Test public void SeJuegaUnaPartidaSeConsultaPorElGanadorCuandoLaPartidaNoTerminoEntraEnError () throws PartidaFinalizada, CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {

        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();

        this.jugarTurnosGladiador(29,jugador,algoRoma);
        assertThrows(PartidaNoFinalizada.class, () -> algoRoma.elGanador());
    }

    @Test
    public void SeJuegaUnaPartidaCon32CasillerosElJugadorQueLlegaALaMetaNoGanaYQuedaPosicoinadoEnLa15AlFinalizarElJuego () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(31);


        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(1,jugador,algoRoma);

        Casillero posicionEsperada = new CasilleroCamino(16,0);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));

    }

    @Test
    public void SeJuegaUnaPartidaCasilleroSoloTieneUnEquipoElJugadorLaPuedeEquipar () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConUnEquipo();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(9);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();
        this.jugarTurnosGladiador(2,jugador,algoRoma);

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));

    }

    @Test
    public void SeJuegaUnaPartidaCasillerosTienenDosEquiposElJugadorPuedeEquipar () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConDosEquipos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(4);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador =  (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(2,jugador,algoRoma);


        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Espartaco.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Espartaco.compararEquipo(JerarquiaEquipos.ARMADURA));

        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
        assertFalse(Carpoforo.compararEquipo(JerarquiaEquipos.CASCO));
        assertTrue(Carpoforo.compararEquipo(JerarquiaEquipos.ARMADURA));
    }

    @Test
    public void SeJuegaUnaPartidaMapaConTresEquipoSeEsperaEquipamientoARMADURA () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaSoloConTresEquipos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(9);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(3,jugador,algoRoma);

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
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();
        this.jugarTurnosGladiador(2,jugador,algoRoma);
        CasilleroCamino casilleroCamino = new CasilleroCamino(1,0); //Porque no se pudo mover

        assertTrue(Carpoforo.compararPosicion(casilleroCamino));

    }

    @Test
    public void JugadoresAtraviesanMapaConEquipoBaseConUnBacanalEnElCasillero7PierdeEnergia () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConBacanalEnElCasillero7();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(7);

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(1,jugador,algoRoma);

        Energia eneriaEsperada = new Energia(-8);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5 () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(9,jugador,algoRoma);

        Energia eneriaEsperada = new Energia(25);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void SeJuegan12TurnosYJugadoresAsciendenASemiSiniorYSiniorAumentandoEnergiaCorrespondiente () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(13,jugador,algoRoma);

        Energia eneriaEsperada = new Energia(50);

        assertTrue(Carpoforo.compararSalud(eneriaEsperada));
        assertTrue(Espartaco.compararSalud(eneriaEsperada));

    }

    @Test
    public void Juegan7TurnosConMapaConComidaSeEsperaAumentoDeEnergia () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(7,jugador,algoRoma);

        Energia eneriaEsperadaCarpoforo = new Energia(125);
        Energia eneriaEsperadaEspartaco = new Energia(125);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));

    }

    @Test
    public void Juegan8TurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComidaYSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(9,jugador,algoRoma);

        Energia eneriaEsperadaCarpoforo = new Energia(160);
        Energia eneriaEsperadaEspartaco = new Energia(160);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
    }

    @Test
    public void JueganTodosLosTurnosConMapaConComidaSeEsperaAumentoDeEnergiaPorComitaYSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        this.jugarTurnosGladiador(30,jugador,algoRoma);


        Energia eneriaEsperadaCarpoforo = new Energia(670);
        Energia eneriaEsperadaEspartaco = new Energia(670);

        assertTrue(Carpoforo.compararSalud(eneriaEsperadaCarpoforo));
        assertTrue(Espartaco.compararSalud(eneriaEsperadaEspartaco));
        assertEquals("No hay ganador",algoRoma.elGanador().yoSoy());
    }

    @Test
    public void JueganTodosLosTurnosHayUnGanador () throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaQuePermiteGanar();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Carpoforo.agregarDispositivoAzar(mockDado);
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();
        this.jugarTurnosGladiador(29,jugador,algoRoma);

        Carpoforo.agregarDispositivoAzar(new MockDado(2));
        Espartaco.agregarDispositivoAzar(new MockDado(2));

        jugador = (Gladiador) algoRoma.siguienteJugador();
        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
        assertEquals("Carpoforo",algoRoma.elGanador().yoSoy());

    }

    @Test
    public void JueganSeCruzanConFierasSalvajesEnElPrimerCasilleroPierdenTodaLaEnergiaNoSePuedenMoverPeroAumentanLaEnergiaEn5PuntosPorSuSeniority () throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDadoCarpoforo = new MockDado(1);
        MockDado mockDadoEspartaco = new MockDado(1);

        Carpoforo.agregarDispositivoAzar(mockDadoCarpoforo);
        Espartaco.agregarDispositivoAzar(mockDadoEspartaco);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);


        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i< 1 ; i++ ) {
            for (int j = 0; j<2;j++) {
                jugador.moverse();
                jugador.obtenerElementos();
                jugador.finalizarTurno(algoRoma);
                jugador =  (Gladiador) algoRoma.siguienteJugador();
            }
        }

        Energia energiaEsperadaCarpoforo = new Energia(0);
        Energia energiaEsperadaEspartaco = new Energia(0);


        Casillero posicionEsperada = new CasilleroCamino(1,0);


        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperadaCarpoforo));

        assertTrue(Espartaco.compararPosicion(posicionEsperada));
        assertTrue(Espartaco.compararSalud(energiaEsperadaEspartaco));

        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);
        jugador = (Gladiador) algoRoma.siguienteJugador();
        jugador.moverse();
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        energiaEsperadaCarpoforo = new Energia(5);
        energiaEsperadaEspartaco = new Energia(5);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Carpoforo.compararSalud(energiaEsperadaCarpoforo));

        assertTrue(Espartaco.compararPosicion(posicionEsperada));
        assertTrue(Espartaco.compararSalud(energiaEsperadaEspartaco));
    }



}