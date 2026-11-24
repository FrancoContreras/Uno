package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

import java.util.Objects;

public class CartaRobaDos extends Carta{
    private final AccionEspecial accionEspecial = AccionEspecial.ROBAR_DOS;

    public CartaRobaDos(Color color) {
        super(color);
    }

    @Override
    public String getNombre() {
        return "Carta roba dos";
    }

    @Override
    public boolean esJugableSobre(ICarta carta) {
        return carta.aceptaEncima(this);
    }

    @Override
    public void jugarseEn(Juego juego) {
        super.jugarseEn(juego);
        juego.repartirCartas(2);
    }

    @Override
    public boolean aceptaEncima(CartaRobaDos carta) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaRobaDos that = (CartaRobaDos) o;
        return accionEspecial == that.accionEspecial;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accionEspecial);
    }

    @Override
    public String toString() {
        return "CartaRobaDos{" +
                "accionEspecial=" + accionEspecial +
                '}';
    }
}
