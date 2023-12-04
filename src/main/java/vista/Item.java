package vista;

import datos.MensajesUsuario;

public class Item {
    private MensajesUsuario m = new MensajesUsuario();
    private final String jugadores;
    private final String turno;
    private final String lanzar;

    public Item(String jugadores, String turno, String lanzar) {
        this.jugadores = jugadores;
        this.turno = turno;
        this.lanzar = lanzar;
    }

    public String obtenerJugadores() {
        return this.jugadores;
    }

    public String obtenerTurn() {
        return this.turno;
    }

    public String obtenerLLanzar() {
        return this.lanzar;
    }

}