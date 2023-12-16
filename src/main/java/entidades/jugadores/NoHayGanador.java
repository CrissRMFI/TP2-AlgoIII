package entidades.jugadores;

public class NoHayGanador implements JugadorGanador {
    @Override
    public String yoSoy() {
        return "No hay ganador";
    }
}
