package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.*;

import java.util.*;

public class Mazo {
    private List<ICarta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        inicializarCartas();
        mezclar();
    }

    public Mazo(List<ICarta> cartasIniciales) {
        this.cartas = new ArrayList<>(cartasIniciales);
    }

    public String informarCantidad(){
        return "Cantidad de cartas en el mazo: " + cartas.size();
    }

    public ICarta getTope() {
        if(this.estaVacio()){
            throw new NoSuchElementException("No se puede obtener el tope porque la lista está vacía");
        }
        return cartas.remove(cartas.size()-1);
    }

    public void mezclar() {
        Collections.shuffle(cartas);
    }

    public void recargar(List<ICarta> cartasDelPozo) {
        cartas = new ArrayList<>(cartasDelPozo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mazo mazo = (Mazo) o;
        return Objects.equals(cartas, mazo.cartas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cartas);
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }

    private void inicializarCartas() {
        for(int i = 0; i < 4; i++){
            cartas.add(new CartaRobaCuatro());
            cartas.add(new CartaCambiaColor());
        }
        for(int i = 0; i < 2; i++){
            for(Color color : Color.values()){
                if (color == Color.NEGRO) continue;
                cartas.add(new CartaRobaDos(color));
                cartas.add(new CartaReversa(color));
                cartas.add(new CartaSalteaTurno(color));
                cartas.add(new CartaNumerica(color, Numero.UNO));
                cartas.add(new CartaNumerica(color, Numero.DOS));
                cartas.add(new CartaNumerica(color, Numero.TRES));
                cartas.add(new CartaNumerica(color, Numero.CUATRO));
                cartas.add(new CartaNumerica(color, Numero.CINCO));
                cartas.add(new CartaNumerica(color, Numero.SEIS));
                cartas.add(new CartaNumerica(color, Numero.SIETE));
                cartas.add(new CartaNumerica(color, Numero.OCHO));
                cartas.add(new CartaNumerica(color, Numero.NUEVE));
            }
        }
        for(Color color : Color.values()) {
            if (color == Color.NEGRO) continue;
            cartas.add(new CartaNumerica(color, Numero.CERO));
        }
    }

    public int getCantidadDeCartas() {
        return cartas.size();
    }

    public List<ICarta> sacarPrimerasSiete() {
        List<ICarta> sieteCartas = new ArrayList<>();
        for (int i = 0; i < 7; i++){
            sieteCartas.add(this.getTope());
        }
        return sieteCartas;
    }

    public ICarta getTopeSinRemover() {
        return cartas.get(cartas.size()-1);
    }
}
