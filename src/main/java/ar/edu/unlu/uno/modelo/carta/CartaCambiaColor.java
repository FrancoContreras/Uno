package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

import java.util.Objects;

public class CartaCambiaColor extends Carta {
    private final AccionEspecial accionEspecial = AccionEspecial.CAMBIAR_COLOR;

    public CartaCambiaColor() {
        super(Color.NEGRO);
    }


    @Override
    public String getNombre() {
        return "Carta cambia color";
    }

    @Override
    public void jugarseEn(Juego juego) {
        super.jugarseEn(juego);
        juego.notificarEsperandoColor();
    }

    @Override
    public boolean esJugableSobre(ICarta carta) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaCambiaColor that = (CartaCambiaColor) o;
        return accionEspecial == that.accionEspecial;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accionEspecial);
    }

    @Override
    public String toString() {
        return "CartaCambiaColor{" +
                "accionEspecial=" + accionEspecial +
                '}';
    }
}
