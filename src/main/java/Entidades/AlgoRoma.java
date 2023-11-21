package Entidades;

import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Tablero.Posicion;

public class AlgoRoma {
    private ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private Tablero tablero;
    private DispositivoDeAzar dispositivoDeAzar;
    private int limiteDeJugadores = 6;
    private int limiteDeTurnos = 20;

    public AlgoRoma(Tablero tablero, DispositivoDeAzar dispositivoDeAzar, int limiteDeTurnos){
        this.tablero = tablero;
        this.dispositivoDeAzar = dispositivoDeAzar;
        this.limiteDeTurnos = limiteDeTurnos;

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
        Posicion posicionInicial = this.tablero.obtenerPosicionInicial();
        jugador.posicionar(posicionInicial);
        this.jugadores.agregarElemento(jugador);
    }

    private void pasarAlSiguienteJugador(){
        this.jugadores.siguiente();
    }


    // PARA PRUEBAS
    public int cantidadDeEnergiaDelJugadorActual(){
        return this.jugadores.obtener().getSalud().getEnergia();
    }
}
