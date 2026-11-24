package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

import java.util.Objects;

public class CartaSalteaTurno extends Carta {
    private final AccionEspecial accionEspecial = AccionEspecial.SALTEAR_TURNO;

    public CartaSalteaTurno(Color color) {
        super(color);
    }

    @Override
    public String getNombre() {
        return "Carta saltea turnos";
    }

    @Override
    public void jugarseEn(Juego juego) {
        super.jugarseEn(juego);
        juego.saltearTurno();
    }

    @Override
    public boolean esJugableSobre(ICarta carta) {
        return carta.aceptaEncima(this);
    }

    @Override
    public boolean aceptaEncima(CartaSalteaTurno carta) {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaSalteaTurno that = (CartaSalteaTurno) o;
        return accionEspecial == that.accionEspecial;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accionEspecial);
    }

    @Override
    public String toString() {
        return "CartaSalteaTurno{" +
                "accionEspecial=" + accionEspecial +
                '}';
    }
}
