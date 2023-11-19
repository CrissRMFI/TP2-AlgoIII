package Entidades.Elementos;

import java.util.ArrayList;
import java.util.Random;

public class Dado{
    private int caras;
    private Random random = new Random();
    private ArrayList<Integer> valoresDelDado = new ArrayList<>();
    public Dado (int caras) {
        this.caras = caras;
        for(int i=1; i<this.caras+1; i++){
            this.valoresDelDado.add(i);
        }
    }
    public int lanzar() {
        return (this.valoresDelDado.get(random.nextInt(this.caras)));
    }
}

/*
import Entidades.ListaCircular;

public class Dado implements DispositivoDeAzar{
    private ListaCircular<CaraDado> caras;

    public Dado () {
        this.caras = new ListaCircular<CaraDado>();
        this.caras.agregarElemento(new CaraDado(1));
        this.caras.agregarElemento(new CaraDado(2));
        this.caras.agregarElemento(new CaraDado(3));
        this.caras.agregarElemento(new CaraDado(4));
        this.caras.agregarElemento(new CaraDado(5));
        this.caras.agregarElemento(new CaraDado(6));


    }
    @Override
    public CaraDado lanzar() {
        return this.caras.seleccionAleatoria();
    }
}
*/