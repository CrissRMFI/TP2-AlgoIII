package Datos;

public class MensajesErrores {
    public String CantidadMinimaJugadores () {
        return "No hay suficientes jugadorfes para iniciar partida";
    }
    public String PartidaFinalizada () {
        return "No hay mas turnos disponibles, la partida finalizo";
    }
    public String PartidaNoFinalizada () {
        return "La partida aun no finalizo";
    }
    public String Minimo4Caracteres () {return "El nombre debe contener un minimo de cuatro caracteres";}

    public String ErrorAlCargarElMapa () {return "Error: Es posible que no sea una extensión válida";}

    public String ErrorAlIniciarElJuego () {return "Error al iniciar el juego";}
}
