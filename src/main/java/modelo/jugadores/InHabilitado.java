package modelo.jugadores;

import modelo.energia.Energia;
import modelo.tablero.Casillero;
import modelo.tablero.Mapa;

public class InHabilitado extends Estado {

    private int turnosRestantes;
    private Energia energiaExtraAlSerHabilitado;

    public InHabilitado(Jugador jugador, int turnosRestantes) {
        super(jugador);
        this.turnosRestantes = turnosRestantes;
        this.energiaExtraAlSerHabilitado = new Energia(0);
    }

    public InHabilitado(Jugador jugador) {
        this(jugador, 1);
        this.energiaExtraAlSerHabilitado = new Energia(5);
    }

    @Override
    public Casillero mover(Mapa mapa, Casillero casillero) {
        turnosRestantes--;
        if (turnosRestantes == 0) {
            this.jugador.setEstado(new Habilitado(this.jugador));
            this.jugador.afectarEnergia(this.energiaExtraAlSerHabilitado);
        }
        return casillero;
    }
}
