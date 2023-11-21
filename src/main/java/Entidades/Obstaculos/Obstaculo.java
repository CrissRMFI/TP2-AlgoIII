package Entidades.Obstaculos;

import Entidades.Elementos.Interactuable;

public abstract class Obstaculo implements Interactuable {
    protected boolean interactuo = false;
    @Override
    public boolean esPremio() {
        return false;
    }

    @Override
    public boolean interactuo() {
        return this.interactuo;
    }

    public void setInteractuo () {
        this.interactuo = true;
    }
}