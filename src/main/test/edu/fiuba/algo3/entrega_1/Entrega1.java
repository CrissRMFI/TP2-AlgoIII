
package edu.fiuba.algo3.entrega_1;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Interactuable;
import Entidades.Elementos.MockDado;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {

    private Tablero tablero;
    private DispositivoDeAzar mockDado;


    public Mapa MapaConFieraSalvaje() {
        int cantidadCasilleros = 30;
        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 1; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

      return new MapaLineal(elementosMapa);
    }

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {

        Mapa mapa = this.MapaConFieraSalvaje();
        Tablero tablero = new Tablero(mapa);

        MockDado mockDado = new MockDado();
        Gladiador Carpoforo  = new Gladiador();

        tablero.agregarJugador(Carpoforo);
        Jugador jugador = tablero.iniciarPartida();

        jugador.moverse(tablero,mockDado);
        jugador.obtenerElementos(tablero);

        assertEquals(0,jugador.getSalud());
        tablero.terminarTurno();

        jugador = tablero.siguienteJugador();
        jugador.moverse(tablero,mockDado);
        jugador.obtenerElementos(tablero);



    }
