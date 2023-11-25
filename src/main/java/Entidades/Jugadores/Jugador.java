package Entidades.Jugadores;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.Turno;
import Entidades.Elementos.ValorAzar;
import Entidades.Energia.Energia;
import Entidades.Equipo.Equipamiento;
import Entidades.Equipo.Equipo;
import Entidades.Sistemas.SistemaDefensa;
import Entidades.Sistemas.SistemaPosicionamiento;
import Entidades.Sistemas.SistemaTurnos;
import Entidades.Tablero.CasilleroMapa;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public abstract class Jugador implements SistemaDefensa, SistemaPosicionamiento, SistemaTurnos {

    protected Energia energia;
    protected Posicion posicion;
    protected Equipo equipo;
    protected DispositivoDeAzar dispositivoDeAzar;
    protected Turno turno;
    protected String nombre;


    public void afectarEnergia (Energia energia) {
        this.energia.afectarEnergia(energia);
    }
    public boolean compararSalud(Energia energia) {
        return this.energia.comparar(energia);
    }


    @Override
    public boolean compararEquipo(Equipamiento equipamiento) {
        return this.equipo.comparar(equipamiento);

    }

    @Override
    public void modificarEquipo(Equipo equipo) {
        if (this.equipo.puedoEquipar(equipo)) {
            equipo.equipoEsEquipado();
            this.equipo = equipo;
        }
    }

    @Override
    public void posicionar(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void perderTurnos (Turno turnos);


    @Override
    public Posicion miPosicion () {
        return this.posicion;
    }

    @Override
    public void habilitar () {
        this.turno.habilitar();
    }

    @Override
    public boolean estaHabilitado () {
        return this.turno.estaHabilitado();
    }

    @Override
    public void deshabilitar () {
        this.turno.deshabilitar();
    }

    public void agregarDispositivoAzar (DispositivoDeAzar dispositivoDeAzar) {
        this.dispositivoDeAzar = dispositivoDeAzar;
    }

    public ValorAzar lanzar () {
        return this.dispositivoDeAzar.lanzar();
    }



}