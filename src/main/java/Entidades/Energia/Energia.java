package Entidades.Energia;

public class Energia{
    private int disponible;
    public Energia(int disponible){
        this.disponible = disponible;
    }

    public int getEnergia(){
        return this.disponible;
    }

    public void perderEnergia(int cantidadAPerder){
        this.disponible = this.disponible - cantidadAPerder;
    }

    public void ganarEnergia(int cantidadAGanar){
        this.disponible = this.disponible + cantidadAGanar;
    }
}





/*public class Energia {
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
    public int getEnergia () {
        return this.disponible;
    } // TODO: Este metodo luego hayyque elimiarlo, es un hack para ver pruebascoo facilidad mientras desarrollo las clases
}
*/