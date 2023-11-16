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
        this.disponible = this.disponible + energia.otorgarEnergia();
    }

    public int otorgarEnergia () {
        return this.disponible;
    }

    public int getEnergia () {
        return this.disponible;
    }
}
