
package edu.fiuba.algo3.entrega_1;

import Entidades.Elementos.Dado;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {

    private Tablero tablero;
    private Dado dado;

    @Before
    public void inicializarMapa() {
        int cantidadCasilleros = 30;
        ElementosMapa[][] elementosMapa = new ElementosMapa[cantidadCasilleros][1];

        for (int i = 1; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        MapaLineal mapa = new MapaLineal<>(elementosMapa);
        tablero = new Tablero(mapa);
        dado = new Dado();

    }

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {
        Gladiador gladiador = new Gladiador();

       tablero.agregarJugador(gladiador);

       gladiador.moverse(tablero,dado);
       gladiador.obtenerElementos(tablero);
       //assertEquals(0,gladiador.getSalud());


    }
