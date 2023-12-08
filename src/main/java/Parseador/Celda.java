package Parseador;

public class Celda {
    private int x;
    private int y;
    private String tipo;
    private String obstaculo;
    private String premio;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setObstaculo(String obstaculo) {
        this.obstaculo = obstaculo;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public int getX() {return this.x;}
    public int getY() {return this.y;}
}
