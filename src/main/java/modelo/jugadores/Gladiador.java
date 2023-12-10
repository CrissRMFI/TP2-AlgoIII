package modelo.jugadores;


import modelo.elementos.DispositivoDeAzar;
import modelo.energia.Energia;
import modelo.premios.Equipo;
import modelo.premios.EquipoBase;
import modelo.premios.JerarquiaEquipos;
import modelo.tablero.Mapa;

public class Gladiador extends Jugador {
    private Seniority seniority;
    private Equipo equipamiento;

    public Gladiador(String nombre, DispositivoDeAzar dispositivoDeAzar) {
        super(nombre, dispositivoDeAzar);
        this.seniority = new Novato();
        this.equipamiento = new EquipoBase();
    }

    private void ascenderSeniority() {
        this.seniority = this.seniority.ascenderSeniority(this.turnos);
    }

    @Override
    public void moverse(Mapa mapa) {
        this.casillero = this.estado.mover(mapa, this.casillero);
        this.turnos++;
        this.seniority.aumentarEnergia(this.energia);
        this.ascenderSeniority();
    }

    /*
    public void obtenerElementos() {
        this.casillero.entregarElementos(this);
    }

    */

    @Override
    public void recibirDanio(Energia energia) {
        this.energia.afectarEnergia(energia);
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
