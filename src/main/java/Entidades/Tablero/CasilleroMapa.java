package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Equipo.Equipamiento;
import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public class CasilleroMapa implements Casillero{
    private LinkedList<Interactuable> elementos;
    public CasilleroMapa() {
        this.elementos = new LinkedList<>();
    }
    public void recibirElemento (Interactuable elemento) {
        this.elementos.add(elemento);
    }

    public void entregarElementos (Jugador jugador) throws SinDispositivoDeAzar {
         for (int i=0;i< this.elementos.size();i++) {
            Interactuable interactuable = this.elementos.get(i);
            if (interactuable != null) {
                interactuable.interactuar(jugador);
                if (interactuable.esPremio() && interactuable.interactuo()) {
                    this.elementos.remove(i);
                }
            }


        }
    }
}
