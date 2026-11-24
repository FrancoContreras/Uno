package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

import java.util.Objects;

public class CartaReversa extends Carta {
    private final AccionEspecial accionEspecial = AccionEspecial.CAMBIAR_SENTIDO;

    public CartaReversa(Color color) {
        super(color);
    }

    @Override
    public String getNombre() {
        return "Carta reversa";
    }

    @Override
    public void jugarseEn(Juego juego) {
        super.jugarseEn(juego);
        juego.invertirRonda();
    }

    @Override
    public boolean esJugableSobre(ICarta carta) {
        return carta.aceptaEncima(this);
    }

    @Override
    public boolean aceptaEncima(CartaReversa carta) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaReversa that = (CartaReversa) o;
        return accionEspecial == that.accionEspecial;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accionEspecial);
    }
}
