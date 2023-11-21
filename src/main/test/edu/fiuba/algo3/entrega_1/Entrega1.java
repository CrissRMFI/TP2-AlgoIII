
package edu.fiuba.algo3.entrega_1;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Jugadores.Gladiador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Premios.Comida;
import Entidades.Tablero.InformacionMapaEnMatriz;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import Entidades.Tablero.Posicion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {
    private Tablero tablero;
    private DispositivoDeAzar mockDado = new MockDado(); // Devuelve siempre 1

    public Mapa mapaConFieraSalvaje() {
        int cantidadCasilleros = 10;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    public Mapa mapaConComida() {
        int cantidadCasilleros = 10;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new Comida();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    /*
    public Mapa mapaCon1EquipamientoYLoDemasFieraSalvaje() {
        int cantidadCasilleros = 10;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            if (i == 1){
                elementosMapa[1][0] = new Equipo();
            }
            else{
                elementosMapa[i][0] = new Comida();
            }
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }


     */

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {
        tablero = new Tablero(mapaConFieraSalvaje());
        AlgoRoma algoRoma = new AlgoRoma(tablero, mockDado, 1);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        algoRoma.comenzarPartida();
        Assertions.assertEquals(0, algoRoma.obtenerCantidadDeEnergiaDelJugadorActual());
    }

    @Test
    public void jugadorSaleDeLaCasillaInicial() {
        tablero = new Tablero(mapaConFieraSalvaje());
        AlgoRoma algoRoma = new AlgoRoma(tablero, mockDado, 1);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        Posicion posicionActual = algoRoma.obtenerPosicionDelJugadorActual();
        Assertions.assertEquals(0, posicionActual.obtenerCoordenada().valor());
    }

    @Test
    public void jugadorSinEnergiaNoPuedeJugarSuTurno() {
        tablero = new Tablero(mapaConFieraSalvaje());
        AlgoRoma algoRoma = new AlgoRoma(tablero, mockDado, 2);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        algoRoma.comenzarPartida();
        Posicion posicionActual = algoRoma.obtenerPosicionDelJugadorActual();
        Assertions.assertEquals(1, posicionActual.obtenerCoordenada().valor());
    }

    @Test
    public void AlRecibirComidaSuEnergiaSeIncrementaEn10() {
        tablero = new Tablero(mapaConComida());
        AlgoRoma algoRoma = new AlgoRoma(tablero, mockDado, 1);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        algoRoma.comenzarPartida();
        Assertions.assertEquals(35, algoRoma.obtenerCantidadDeEnergiaDelJugadorActual());
    }


}