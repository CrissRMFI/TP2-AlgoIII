package Entidades.Energia;

public class Energia {
    private int disponible;

    public Energia () {
        this.disponible = 20;
    }

    public Energia (int disponible) {
        this.disponible = disponible;
    }

    protected int cantidadDeEnergia() {
        return this.disponible;
    }

    public void afectarEnergia (Energia energia) {
        this.disponible += energia.cantidadDeEnergia();
    }

    public boolean tengoEnergia () {
        return this.disponible > 0;
    }

    public boolean comparar (Energia energia) {
        return this.disponible == energia.cantidadDeEnergia();
    }

    public String descripcion () {
        return "" + this.disponible;
    }
}