
package edu.fiuba.algo3.entrega_1;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.MockDado;
import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {

    private Tablero tablero;
    private DispositivoDeAzar mockDado;

    @Before
    public void inicializarMapa() {
        int cantidadCasilleros = 30;
        ElementosMapa[][] elementosMapa = new ElementosMapa[cantidadCasilleros][1];

        for (int i = 1; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        MapaLineal mapa = new MapaLineal(elementosMapa);
        tablero = new Tablero(mapa);
        mockDado = new MockDado();

    }

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {
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
