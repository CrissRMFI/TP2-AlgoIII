package Entidades.Energia;

public class Energia {
    private int disponible;

    public  Energia (int disponible) {
        this.disponible = disponible;
    }
    public void afectarEnergia (Energia energia) {
        this.disponible += energia.cantidadDeEnergia();
    }

    public void afectarEnergia(int cantidadEnergia){
        this.disponible += cantidadEnergia;
    }

    public int cantidadDeEnergia() {
        return this.disponible;
    }

    /*
    public boolean tengoEnergia () {
        return this.disponible > 0;
    }
     */
    public int getEnergia () {
        return this.disponible;
    } // TODO: Este metodo luego hayyque elimiarlo, es un hack para ver pruebascoo facilidad mientras desarrollo las clases
}