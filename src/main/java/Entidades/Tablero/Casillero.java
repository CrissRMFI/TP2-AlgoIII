package Entidades.Tablero;

public class Casillero{
    int x; int y;
    public Casillero(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}



/*
import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;

import java.util.LinkedList;

public class Casillero {
   private LinkedList<ElementosMapa> elementos;
   private PosicionLineal posicionLineal;

   public Casillero (PosicionLineal posicionLineal) {
       this.posicionLineal = posicionLineal;
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


 */
