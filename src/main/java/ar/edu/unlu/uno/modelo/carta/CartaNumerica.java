package ar.edu.unlu.uno.modelo.carta;

import java.util.Objects;

public class CartaNumerica extends Carta{
    private final Numero numero;

    public CartaNumerica(Color color, Numero numero) {
        super(color);
        this.numero = numero;
    }

    @Override
    public String getNombre() {
        return "Carta numérica";
    }

    @Override
    public String informarDatos() {
        return super.informarDatos() + " - Numero: " + this.numero;
    }

    @Override
    public boolean esJugableSobre(ICarta carta) {
        return carta.aceptaEncima(this);
    }

    @Override
    public boolean aceptaEncima(CartaNumerica carta) {
        return super.aceptaEncima(carta) || this.numero == carta.numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaNumerica that = (CartaNumerica) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }

    @Override
    public String toString() {
        return "CartaNumerica{" +
                "numero=" + numero +
                '}';
    }
}
