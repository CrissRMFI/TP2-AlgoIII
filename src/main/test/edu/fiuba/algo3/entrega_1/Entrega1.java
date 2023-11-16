package edu.fiuba.algo3.entrega_1;

import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;
import Entidades.Obstaculos.FieraSalvaje;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1 {

    private Tablero tablero;  // Declarar tablero como un campo de clase

    @Before
    public void inicializarMapa() {
        int cantidadCasilleros = 30;
        ElementosMapa[][] elementosMapa = new ElementosMapa[cantidadCasilleros][1];

        for (int i = 1; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        MapaLineal mapa = new MapaLineal<>(elementosMapa);
        tablero = new Tablero(mapa);  // Asignar el tablero al campo de clase
    }

    @Test
    public void jugadorEmpiezaConLaEnergíaYEquipamientoCorrespondiente() {
        Gladiador gladiador = new Gladiador();

       tablero.agregarJugador(gladiador);


    }
}
