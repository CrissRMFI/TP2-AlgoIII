
package edu.fiuba.algo3.entrega_1;

import Entidades.AlgoRoma;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Tablero.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {

    private Tablero tablero;
    private DispositivoDeAzar mockDado;


    public Mapa MapaConFieraSalvaje() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {
        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        MockDado dado = new MockDado();
        Gladiador gladiador1 = new Gladiador();

        algoRoma.agregarJugador(gladiador1);

        Jugador jugador = algoRoma.comenzarPartida();

        jugador.moverse(dado,tablero);

        algoRoma.entregarElementos(jugador);

        algoRoma.finalizarTurno();
    }







}