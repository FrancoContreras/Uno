package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

public abstract class Carta implements ICarta{
    private Color color;

    public Carta(Color color) {
        this.color = color;
    }

    @Override
    public abstract String getNombre();

    @Override
    public String informarDatos() {
        return getNombre() + " - Color: " + this.getColor();
    }

    @Override
    public void jugarseEn(Juego juego) {
        juego.cambiarTopeDelPozo(this);
    }

    @Override
    public abstract boolean esJugableSobre(ICarta carta);

    @Override
    public boolean aceptaEncima(CartaNumerica carta) {
        return this.getColor() == carta.getColor();
    }

    @Override
    public boolean aceptaEncima(CartaRobaDos carta) {
        return this.getColor() == carta.getColor();
    }

    @Override
    public boolean aceptaEncima(CartaReversa carta) {
        return this.getColor() == carta.getColor();
    }

    @Override
    public boolean aceptaEncima(CartaSalteaTurno carta) {
        return this.getColor() == carta.getColor();
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if(this.color == Color.NEGRO){
            this.color = color;
        }
    }
}
