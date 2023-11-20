package Entidades;

import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.DispositivoDeAzar;

public class AlgoRoma {
    private ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private Tablero tablero;
    private DispositivoDeAzar dispositivoDeAzar;
    private int limiteDeJugadores = 6;
    private int limiteDeTurnos = 30;

    public AlgoRoma(Tablero tablero, DispositivoDeAzar dispositivoDeAzar){
        this.tablero = tablero;
        this.dispositivoDeAzar = dispositivoDeAzar;

    }

    public void comenzarPartida(){
        jugadores.seleccionAleatoria();
        for (int i=0; i < (limiteDeTurnos * this.jugadores.verLongitud()); i++){
            jugadores.obtener().jugarTurno(this.tablero, this.dispositivoDeAzar);
            // AQUI VOY A PONER EL METODO PARA VER AL GANADOR
            this.pasarAlSiguienteJugador();
        }
        // AQUI CREO QUE IRIA COMO UN PRINT PARA DECIR QUE TODOS PERDIERON
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.agregarElemento(jugador);
        //Posicion posicion = this.mapa.obtenerPosicionInicial();
        //jugador.posicionar(posicion);
    }

    public Jugador obtenerJugadorActual(){
        return jugadores.obtener();
    }

    private void pasarAlSiguienteJugador(){
        this.jugadores.siguiente();
    }
}
