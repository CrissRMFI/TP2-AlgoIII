package Entidades.Tablero;

import Entidades.Elementos.Comida;
import Entidades.Elementos.Objetos;
import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;
import Entidades.Obstaculos.Obstaculo;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Casillero {
   private LinkedList<ElementosMapa> elementos;
   private Posicion posicion;

   public Casillero (Posicion posicion) {
       this.posicion = posicion;
       this.elementos = new LinkedList<>();
   }
   public void recibirElemento (ElementosMapa elemento) {
       this.elementos.add(elemento);
   }

   public void entregarElementos (Gladiador gladiador) {
       while (!elementos.isEmpty()) {
           ElementosMapa elemento = elementos.poll();
           elemento.accionar(gladiador);
       }
   }
}

