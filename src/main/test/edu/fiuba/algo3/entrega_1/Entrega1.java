package edu.fiuba.algo3.entrega_1;
import Datos.InformacionMapaEnJSON;
import Datos.InformacionMapaLinealEnMatriz;
import Entidades.AlgoRoma;
import Entidades.Errores.*;
import Entidades.Interactuable;
import Entidades.Obstaculos.Bacanal;
import Entidades.Obstaculos.Lesion;
import Entidades.Obstaculos.SinObstaculo;
import Entidades.Premios.Comida;
import Entidades.Elementos.MockDado;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.Fiera;
import Entidades.Premios.Equipamiento;
import Entidades.Premios.JerarquiaEquipos;
import Entidades.Tablero.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1{

    private Mapa MapaConFieraSalvaje() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Fiera();



        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    private Mapa MapaConCuatroEquipamientosYUnaFieraSalvaje () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];


        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[0][0] = new Equipamiento();
        elementosMapa[1][0] = new Equipamiento();
        elementosMapa[2][0] = new Equipamiento();
        elementosMapa[3][0] = new Equipamiento();
        elementosMapa[4][0] = new Fiera();

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }
    private Mapa MapaLlenoDeEquipamientos () throws DatoNoValido {
        int cantidadCasilleros = 30;

        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new Equipamiento();
            elementosMapa[i][1] = new SinObstaculo();
        }


        elementosMapa[5][0] = new Fiera();
        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    private Mapa MapaConUnaPiedra () throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        elementosMapa[8][0] = new Lesion();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }
    private Mapa MapaVacio() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][0] = new SinObstaculo();
        }

        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        Mapa mapa = new Mapa(informacionMapaLinealEnMatriz);

        return mapa;
    }

    private Mapa MapaLlenoDeComida() throws DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

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
    private Mapa MapaConUnEquipoYFieraSalvaje() throws  DatoNoValido {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][2];


        for (int i=0;i<cantidadCasilleros;i++) {
            elementosMapa[i][1] = new SinObstaculo();
        }

        elementosMapa[2][0] = new Equipamiento();
        elementosMapa[5][0] = new Fiera();


        InformacionMapaLinealEnMatriz informacionMapaLinealEnMatriz = new InformacionMapaLinealEnMatriz(elementosMapa);

        return new Mapa(informacionMapaLinealEnMatriz);
    }

    @Test
    //Caso de uso 1 --> Fiera saca 20 ya que no tiene equipamiento
    public void jugadorEmpiezaConEnergiaYEquipamientoCorrespondiente() throws CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();

        Casillero casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Energia energiaEsperada = new Energia(0);

        assertTrue(jugador.compararSalud(energiaEsperada));
        assertTrue(jugador.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }

    @Test
    //Caso de uso 2
    public void jugadorSaleDeLaCasillaInicial() throws CantidadMinimaDeJugadores, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Jugador jugador = algoRoma.comenzarPartida();

        Casillero casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);


        Casillero casilleroSiguienteAlInicial = new Casillero(1,0);


        assertTrue(jugador.compararPosicion(casilleroSiguienteAlInicial));
    }

    @Test
    //Caso de uso 3
    public void jugadorSinEnergiaNoPuedeJugarTurno() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Gladiador Espartaco = new Gladiador("Espartaco");

        Carpoforo.agregarDispositivoAzar(new MockDado(1));
        Espartaco.agregarDispositivoAzar(new MockDado(2));

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        Casillero casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos(); //Carpoforo se enferenta a Fiera
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Casillero casilleroEsperadoCarpoforo = new Casillero(1,0);
        Casillero casilleroEsperadoEspartaco = new Casillero(2,0);

        assertTrue(Carpoforo.compararSalud(new Energia(0)));
        assertTrue(Carpoforo.compararPosicion(casilleroEsperadoCarpoforo));
        assertTrue(Espartaco.compararSalud(new Energia(20)));
        assertTrue(Espartaco.compararPosicion(casilleroEsperadoEspartaco));


        // El siguinete debe ser Carpoforo, pero como no puede juegar por energia en cero es Espartaco
        jugador = (Gladiador) algoRoma.siguienteJugador();

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);


        assertTrue(Carpoforo.compararSalud(new Energia(5)));
        assertTrue(Carpoforo.compararPosicion(new Casillero(1,0)));

        assertTrue(Espartaco.compararSalud(new Energia(20)));
        assertTrue(Espartaco.compararPosicion(new Casillero(4,0)));

    }

    @Test
    //Caso de uso 4
    public void jugadorRecibeComidaEIncrementaSuEnergiaEn15() throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeComida();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        Casillero casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();
        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        Energia energiaEsperada = new Energia(35);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 7
    public void SiTieneCascoYPeleaConFieraPierde15Energia() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConUnEquipoYFieraSalvaje();

        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado(3);

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();

        Casillero casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);

        jugador = (Gladiador) algoRoma.siguienteJugador();

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(algoRoma);


        Energia energiaEsperada = new Energia(5);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));

    }

    @Test
    //Caso de uso 8
    public void SeJuegan8TurnosYJugadoresAsciendenASemiSiniorLoQueAumentaSuEnergiaEn5 () throws CantidadMinimaDeJugadores, PartidaFinalizada, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();
        Casillero casillero = mapa.obtenerProximoDestino(jugador);

        for (int i = 0; i< 9 ; i++ ) {

            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            jugador = (Gladiador) algoRoma.siguienteJugador();

            casillero = mapa.obtenerProximoDestino(jugador);
            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            jugador = (Gladiador) algoRoma.siguienteJugador();
        }

        Energia energiaEsperada = new Energia(25);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
        assertTrue(Espartaco.compararSalud(energiaEsperada));

    }

    @Test
    //Caso de uso 9
    public void SeJuegaUnaPartidaCon30CasillerosNoSeGanaYElJugadorQuedaPosicionadoEnElCasillero15AlFinalizarElJuego() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaVacio();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();
        Casillero casillero = mapa.obtenerProximoDestino(jugador);

        for (int i = 0; i< 29 ; i++ ) {

            jugador.moverse(casillero);
            jugador.finalizarTurno(algoRoma);
            jugador = (Gladiador) algoRoma.siguienteJugador();
            casillero = mapa.obtenerProximoDestino(jugador);
            jugador.moverse(casillero);
            jugador.finalizarTurno(algoRoma);
            jugador = (Gladiador) algoRoma.siguienteJugador();
        }

        Carpoforo.agregarDispositivoAzar(new MockDado(3));
        Espartaco.agregarDispositivoAzar(new MockDado(3));

        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.finalizarTurno(algoRoma);
        jugador = (Gladiador) algoRoma.siguienteJugador();
        casillero = mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.finalizarTurno(algoRoma);




        Casillero posicionEsperada = new Casillero(16,0);

        assertTrue(Carpoforo.compararPosicion(posicionEsperada));
        assertTrue(Espartaco.compararPosicion(posicionEsperada));
    }

    @Test
    //Caso de uso 10
    public void SiTieneTodoElEquipamientoYLoAtacaUnaFieraNoHayPerdidaDeEnergia() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaConCuatroEquipamientosYUnaFieraSalvaje();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();
        Casillero casillero = mapa.obtenerProximoDestino(jugador);

        for (int i = 0; i<= 4 ; i++ ) {

            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            jugador = (Gladiador) algoRoma.siguienteJugador();
            casillero = mapa.obtenerProximoDestino(jugador);
            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            jugador = (Gladiador) algoRoma.siguienteJugador();


        }

        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 11
    public void GladiadorConLlaveRecibeOtroPremioYNoPasaNada() throws CantidadMinimaDeJugadores, PartidaFinalizada, ElNombreDebeContenerUnMinimoDe4Caracteres, DatoNoValido {
        Mapa mapa = this.MapaLlenoDeEquipamientos();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);
        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartidaConElPrimerJugador();
        Casillero casillero = mapa.obtenerProximoDestino(jugador);

        for (int i = 0; i<= 6 ; i++ ) {

            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            jugador = (Gladiador) algoRoma.siguienteJugador();
            casillero = mapa.obtenerProximoDestino(jugador);
            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);
        }


        Energia energiaEsperada = new Energia(20);

        assertTrue(Carpoforo.compararSalud(energiaEsperada));
    }

    @Test
    //Caso de uso 12
    public void Pasan30TurnosYNadieLlegoSeTerminaElJuego() throws CantidadMinimaDeJugadores, PartidaFinalizada,PartidaNoFinalizada, DatoNoValido {
        Mapa mapa = this.MapaConUnaPiedra();
        AlgoRoma algoRoma = new AlgoRoma(mapa);
        MockDado mockDado = new MockDado();

        Gladiador Carpoforo = new Gladiador("Carpoforo");
        Carpoforo.agregarDispositivoAzar(mockDado);
        Gladiador Espartaco = new Gladiador("Espartaco");
        Espartaco.agregarDispositivoAzar(mockDado);

        algoRoma.agregarJugador(Carpoforo);
        algoRoma.agregarJugador(Espartaco);

        Gladiador jugador = (Gladiador) algoRoma.comenzarPartida();
        Casillero casillero = mapa.obtenerProximoDestino(jugador);

        for (int i = 0; i< 30 ; i++ ) {

            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);
            jugador = (Gladiador) algoRoma.siguienteJugador();
            casillero = mapa.obtenerProximoDestino(jugador);
            jugador.moverse(casillero);
            jugador.obtenerElementos();
            jugador.finalizarTurno(algoRoma);

            if (i<29) jugador = (Gladiador) algoRoma.siguienteJugador();
        }

        assertThrows(PartidaFinalizada.class, () -> algoRoma.siguienteJugador());
        assertEquals("No hay ganador",algoRoma.elGanador().yoSoy());
    }

}
