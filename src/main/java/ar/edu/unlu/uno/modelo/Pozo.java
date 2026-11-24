package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

import java.util.ArrayList;
import java.util.List;

public class Pozo {
    private List<ICarta> cartas;
    private ICarta cartaTope;
    private Color colorActivo;


    public Pozo(ICarta primera) {
        cartas = new ArrayList<>();
        cartas.add(primera);
        this.cartaTope = primera;
        colorActivo = primera.getColor();
    }

    public String informarTope(){
        return "Tope del pozo: " + getTopeSinRemover().informarDatos();
    }

    public ICarta getTope() {
        if (cartas.size() <= 1) {
            throw new IllegalStateException("No se puede sacar la última carta del pozo");
        }
        return cartas.remove(cartas.size()-1);
    }

    public List<ICarta> reciclar() {
        this.cartaTope = cartas.remove(cartas.size()-1);
        List<ICarta> temporal = new ArrayList<>(this.cartas);
        cartas.clear();
        cartas.add(cartaTope);
        return temporal;
    }

    public void agregarCarta(ICarta carta) {
        cartas.add(carta);
        colorActivo = carta.getColor();
    }

    public int cantidadDeCartas() {
        return cartas.size();
    }

    public void setColorActivo(Color colorActivo) {
            this.colorActivo = colorActivo;
    }

    public Color getColorActivo() {
        return colorActivo;
    }

    public ICarta getTopeSinRemover() {
        return cartas.get(cartas.size()-1);
    }
}
