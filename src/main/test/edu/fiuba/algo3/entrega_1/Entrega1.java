package edu.fiuba.algo3.entrega_1;
import datos.InformacionMapaLinealEnMatriz;
import entidades.AlgoRoma;
import entidades.dispositivoDeAzar.Dado;
import entidades.errores.*;
import entidades.Interactuable;
import entidades.obstaculos.Lesion;
import entidades.obstaculos.SinObstaculo;
import entidades.premios.Comida;
import entidades.energia.Energia;
import entidades.jugadores.Gladiador;
import entidades.obstaculos.Fiera;
import entidades.premios.Equipamiento;
import entidades.equipo.JerarquiaEquipos;
import entidades.tablero.*;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


public class Entrega1 {

    private Mapa MapaConFieraSalvaje() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Fiera();
        elementosMapa[1][0] = new Fiera();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaConCuatroEquipamientosYUnaFieraSalvaje() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];


        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Equipamiento();
        elementosMapa[1][0] = new Equipamiento();
        elementosMapa[2][0] = new Equipamiento();
        elementosMapa[3][0] = new Equipamiento();
        elementosMapa[4][0] = new Fiera();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaLlenoDeEquipamientos() throws DatoNoValido {
        int cantidadCasilleros = 30;

        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Equipamiento();
            elementosMapa[i][1] = new SinObstaculo();
        }


        elementosMapa[5][0] = new Fiera();
        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaConUnaPiedra() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Lesion();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    private Mapa MapaVacio() throws DatoNoValido {
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

    private Mapa MapaConUnEquipoYFieraSalvaje() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];


        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][1] = new SinObstaculo();
        }

        elementosMapa[2][0] = new Equipamiento();
        elementosMapa[5][0] = new Fiera();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }


    @Test
    //Caso de uso 1 --> Fiera saca 20 ya que no tiene equipamiento
    public void jugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() throws CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido, PartidaFinalizada {
        Mapa mapa = this.MapaConFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo"); // TODO: volar esto
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();
        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(0);

        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }


    @Test
    //Caso de uso 2
    public void jugadorSaleDeLaCasillaInicial() throws CantidadMinimaDeJugadores, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido, PartidaFinalizada {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();
        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Casillero casilleroSiguienteAlInicial = new Casillero(1, 0);


        assertTrue(gladiadorQueJugo.compararPosicion(casilleroSiguienteAlInicial));
    }

    @Test
    //Caso de uso 3
    public void jugadorSinEnergiaNoPuedeJugarTurno() throws CantidadMinimaDeJugadores, PartidaFinalizada, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido {
        Mapa mapa = this.MapaConFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);

        Dado dado1 = Mockito.mock(Dado.class);
        Mockito.when(dado1.lanzar()).thenReturn(1);
        Dado dado2 = Mockito.mock(Dado.class);
        Mockito.when(dado2.lanzar()).thenReturn(2);
        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado1);
        espartaco.agregarDispositivoAzar(dado2);


        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();
        algoRoma.jugarTurno();

        Casillero casilleroEsperadocarpoforo = new Casillero(2, 0);
        Casillero casilleroEsperadoespartaco = new Casillero(4, 0);

        assertTrue(carpoforo.compararSalud(new Energia(-20)));
        assertTrue(carpoforo.compararPosicion(casilleroEsperadocarpoforo));
        assertTrue(espartaco.compararSalud(new Energia(0)));
        assertTrue(espartaco.compararPosicion(casilleroEsperadoespartaco));


        // el jugador no tiene energia para jugar
        algoRoma.jugarTurno();


        assertTrue(carpoforo.compararSalud(new Energia(-15)));
        assertTrue(carpoforo.compararPosicion(new Casillero(2, 0)));
    }


    @Test
    //Caso de uso 4
    public void jugadorRecibeComidaEIncrementaSuEnergiaEn15() throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();
        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(35);

        assertTrue(gladiadorQueJugo.compararSalud(energiaEsperada));
    }


    @Test
    //Caso de uso 5 -> Verificar que si recibe un premio por primera vez obtiene un casco
    public void jugadorRecibePremioPorPrimeraVezYObtieneCasco() throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeEquipamientos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Gladiador gladiadorQueJugo;
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();
        gladiadorQueJugo = (Gladiador) algoRoma.jugarTurno();


        assertTrue(gladiadorQueJugo.compararEquipo(JerarquiaEquipos.CASCO));
    }


    @Test
    //Caso de uso 6 -> Verificar que si recibe un premio por tercera vez obtiene escudo y espada
    public void jugadorRecibePremioPorTerceraVezYObtieneEscudoYEspada() throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeEquipamientos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();

        for (int i = 0; i < 3; i++) {
            algoRoma.jugarTurno(); // esto es porque no se puede jugar el turno sin que haya un jugador actual
            algoRoma.jugarTurno();
        }

        assertTrue(carpoforo.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));
        assertTrue(espartaco.compararEquipo(JerarquiaEquipos.ESCUDO_Y_ESPADA));
    }


    @Test
    //Caso de uso 7
    public void SiTieneCascoYPeleaConFieraPierde15Energia() throws CantidadMinimaDeJugadores, PartidaFinalizada, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido {
        Mapa mapa = this.MapaConUnEquipoYFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(3);
        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        algoRoma.jugarTurno();

        algoRoma.jugarTurno();

        algoRoma.jugarTurno();

        algoRoma.jugarTurno();

        Energia energiaEsperada = new Energia(5);

        assertTrue(carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 8
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSeniorLoQueAumentaSuEnergiaEn5() throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i < 9; i++) {

            algoRoma.jugarTurno();
            algoRoma.jugarTurno();
        }

        Energia energiaEsperada = new Energia(25);

        assertTrue(carpoforo.compararSalud(energiaEsperada));
        assertTrue(espartaco.compararSalud(energiaEsperada));
    }


    @Test
    //Caso de uso 9
    public void SeJuegaUnaPartidaCon30CasillerosNoSeGanaYElJugadorQuedaPosicionadoEnElCasillero15AlFinalizarElJuego() throws CantidadMinimaDeJugadores, PartidaFinalizada, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(2);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();

        for (int i = 0; i < 16; i++) {
            algoRoma.jugarTurno();
            algoRoma.jugarTurno();
        }


        Casillero posicionEsperada = new Casillero(16, 0);

        assertTrue(carpoforo.compararPosicion(posicionEsperada));
        assertTrue(espartaco.compararPosicion(posicionEsperada));
    }


    @Test
    //Caso de uso 10
    public void SiTieneTodoElEquipamientoYLoAtacaUnaFieraNoHayPerdidaDeEnergia() throws CantidadMinimaDeJugadores, PartidaFinalizada, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido {
        Mapa mapa = this.MapaConCuatroEquipamientosYUnaFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i <= 4; i++) {
            algoRoma.jugarTurno();
            algoRoma.jugarTurno();
        }

        Energia energiaEsperada = new Energia(20);

        assertTrue(carpoforo.compararSalud(energiaEsperada));
    }


    @Test
    //Caso de uso 11
    public void GladiadorConLlaveRecibeOtroPremioYNoPasaNada() throws CantidadMinimaDeJugadores, PartidaFinalizada, NombreDeJugadorConMenosDe4CaracteresExcepcion, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeEquipamientos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        Gladiador espartaco = new Gladiador("espartaco");
        carpoforo.agregarDispositivoAzar(dado);
        espartaco.agregarDispositivoAzar(dado);
        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartidaConElPrimerJugador();

        for (int i = 0; i <= 6; i++) {
            algoRoma.jugarTurno();
            algoRoma.jugarTurno();
        }


        Energia energiaEsperada = new Energia(20);

        assertTrue(carpoforo.compararSalud(energiaEsperada));
    }


    @Test
    //Caso de uso 12
    public void Pasan30TurnosYNadieLlegoSeTerminaElJuego() throws CantidadMinimaDeJugadores, PartidaFinalizada, PartidaNoFinalizada, DatoNoValido {
        Mapa mapa = this.MapaConUnaPiedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        Dado dado = Mockito.mock(Dado.class);
        Mockito.when(dado.lanzar()).thenReturn(1);

        Gladiador carpoforo = new Gladiador("carpoforo");
        carpoforo.agregarDispositivoAzar(dado);
        Gladiador espartaco = new Gladiador("espartaco");
        espartaco.agregarDispositivoAzar(dado);

        algoRoma.agregarJugador(carpoforo);
        algoRoma.agregarJugador(espartaco);

        algoRoma.comenzarPartida();

        for (int i = 0; i < 30; i++) {
            algoRoma.jugarTurno();
            algoRoma.jugarTurno();
        }

        assertEquals("No hay ganador", algoRoma.elGanador().yoSoy());
    }
}

