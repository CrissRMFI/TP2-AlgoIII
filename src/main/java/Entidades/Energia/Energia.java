package Entidades.Energia;

public class Energia {
    private int disponible;

    public  Energia () {
        this.disponible = 20;
    }

    public  Energia (int disponible) {
        this.disponible = disponible;
    }
    public void afectarEnergia (Energia energia) {
        this.disponible += energia.otorgarEnergia();
    }

    public int otorgarEnergia () {
        return this.disponible;
    }

    public boolean tengoEnergia () {
        return this.disponible > 0;
    }

    public boolean comparar (Energia energia) {
        return this.disponible == energia.cantidadeEnergia();
    }

    protected int cantidadeEnergia () {
        return this.disponible;
    }

    public String descripcion () {
        return "" + this.disponible;
    }
}