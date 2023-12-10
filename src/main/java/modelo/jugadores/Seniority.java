package modelo.jugadores;


import modelo.energia.Energia;

public interface Seniority {
    public abstract Seniority ascenderSeniority(int turnos);

    public abstract void aumentarEnergia(Energia energia);

    public abstract String descripcion();
}
