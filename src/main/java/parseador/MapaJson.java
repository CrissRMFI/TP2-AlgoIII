package parseador;

public class MapaJson {
    private InfoMapa infoMapa;
    private Camino camino;

    public MapaJson(InfoMapa infoMapa, Camino camino) {
        this.infoMapa = infoMapa;
        this.camino = camino;
    }

    public InfoMapa getInfoMapa() {
        return this.infoMapa;
    }

    public Camino getCamino() {
        return this.camino;
    }
}
