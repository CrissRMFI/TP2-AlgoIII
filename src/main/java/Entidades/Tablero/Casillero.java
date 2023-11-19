package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public class Casillero {
   private LinkedList<Interactuable> elementos;
   private Posicion posicion;

   public Casillero (Posicion posicion) {
       this.posicion = posicion;
       this.elementos = new LinkedList<>();
   }
   public void recibirElemento (Interactuable elemento) {
       this.elementos.add(elemento);
   }

   public void entregarElementos (Jugador jugador) {
        for (int i=0;i< this.elementos.size();i++) {
            Interactuable interactuable = this.elementos.get(i);
            interactuable.interactuar(jugador);
            if (interactuable.esPremio()) {
                this.elementos.remove(i);
            }
       }
   }
}

