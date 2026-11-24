package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Mano {
    private List<ICarta> cartas;

    public Mano() {
        this.cartas = new ArrayList<>();
    }

    public void cargarCartas(List<ICarta> cartas) {
        this.cartas.addAll(cartas);
    }

    public int getCantidadDeCartas() {
        return cartas.size();
    }

    public List<ICarta> getCartas() {
        return List.copyOf(cartas);
    }

    public void agregarCarta(ICarta carta) {cartas.add(carta);}

    public ICarta tiraCarta(int opcion) {return cartas.remove(opcion-1);}

    public boolean cartaPuedeJugarse(int opcion, ICarta carta) {
        if (carta == null || this.cartas == null) {
            return false;
        }

        int indice = opcion - 1;
        if (indice < 0 || indice >= this.cartas.size()) {
            return false;
        }

        ICarta cartaElegida = this.cartas.get(indice);
        if (cartaElegida == null) {
            return false;
        }

        return cartaElegida.esJugableSobre(carta);
    }

    public boolean cartaPuedeJugarse(int opcion, Color color) {
        if (this.cartas == null) {
            return false;
        }

        int indice = opcion - 1;
        if (indice < 0 || indice >= this.cartas.size()) {
            return false;
        }

        ICarta cartaElegida = this.cartas.get(indice);

        if (cartaElegida == null) {
            return false;
        }
        return cartaElegida.getColor() == color;
    }
}
