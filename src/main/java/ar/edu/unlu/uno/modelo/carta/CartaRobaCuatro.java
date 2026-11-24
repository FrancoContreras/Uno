package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

import java.util.Objects;

public class CartaRobaCuatro extends Carta{
    private final AccionEspecial accionEspecial = AccionEspecial.ROBAR_CUATRO;

    public CartaRobaCuatro() {
        super(Color.NEGRO);
    }

    @Override
    public String getNombre() {
        return "Carta roba cuatro";
    }

    @Override
    public void jugarseEn(Juego juego) {
        super.jugarseEn(juego);
        juego.repartirCartas(4);
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
        CartaRobaCuatro that = (CartaRobaCuatro) o;
        return accionEspecial == that.accionEspecial;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accionEspecial);
    }

    @Override
    public String toString() {
        return "CartaRobaCuatro{" +
                "accionEspecial=" + accionEspecial +
                '}';
    }
}
