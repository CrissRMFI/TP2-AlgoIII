package Entidades.Tablero;

public class Tablero{
    int filas; int columnas;
    Casillero[][] tablero;
    public Tablero(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.tablero = new Casillero[this.filas][this.columnas];
        this.llenarTablero();
    }

    private void llenarTablero(){
        for(int i=0; i<this.filas; i++){
            for(int j=0; j<this.columnas; j++){
                this.tablero[i][j] = new Casillero(i, j);
            }
        }
    }

    public int getFilas(){
        return this.filas;
    }

    public int getColumnas(){
        return this.columnas;
    }

    public Casillero obtenerCasillero(int x, int y){
        return this.tablero[x][y];
    }
}






/*
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;

public class Tablero {

    private Mapa mapa;
    private ListaCircular<Jugador> jugadores;



    public Tablero(Mapa mapa) {
        this.mapa = mapa;
        this.jugadores = new ListaCircular<Jugador>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.agregarElemento(jugador);
        Posicion posicion = this.mapa.obtenerPosicionInicial();
        mapa.ubicar(jugador, posicion);

    }

    public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    };

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }
    public void terminarTurno () {
        Jugador jugador = this.jugadores.obtener();
        jugador.finalizarTurno();
    }

    public Jugador siguienteJugador () {
        Jugador jugador = this.jugadores.siguiente();
        jugador.iniciarTurno();
        return this.jugadores.obtener();
    }

    public Jugador iniciarPartida () {
        Jugador jugador = this.jugadores.seleccionAleatoria();
        jugador.iniciarTurno();
        return jugador;
    }
}

 */

