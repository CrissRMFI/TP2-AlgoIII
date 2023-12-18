package entidades.jugadores;

import entidades.errores.NombreDeJugadorConMenosDe4CaracteresExcepcion;
import entidades.premios.Equipo;
import entidades.premios.EquipoBase;
import entidades.premios.JerarquiaEquipos;
import entidades.tablero.Mapa;

public class Gladiador extends Jugador {
    private Seniority seniority;
    private Equipo equipamiento;

    public Gladiador(String nombre) throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        super(nombre);
        this.seniority = new Novato();
        this.equipamiento = new EquipoBase();
    }

    @Override
    public void moverse(Mapa mapa) {
        this.seniority.aumentarEnergia(this.energia);
        this.casillero = this.estado.mover(mapa, this.casillero);
        this.turno.finalizarTurno();
        this.seniority = this.seniority.ascenderSeniority(this.turno);
    }

    @Override
    public void defenderse() {
        this.equipamiento.recibirDanio(this.energia);
    }

    @Override
    public void equipar() {
        this.equipamiento = this.equipamiento.mejorar();
    }

    @Override
    public boolean esEquipoMaximo() {
        return !this.equipamiento.sePuedeMejorar();
    }

    @Override
    public boolean compararEquipo(JerarquiaEquipos equipo) {
        return this.equipamiento.compararEquipo(equipo);
    }

    @Override
    public String miDescripcion() {
        String nombre = this.nombre;
        String seniority = this.seniority.descripcion();
        String equipo = this.equipamiento.descripcion();
        String energia = this.energia.descripcion();

        return "Nombre: " + nombre + " Seniority: " + seniority + " Equipamiento: " + equipo + " Energia: " + energia;
    }
}
