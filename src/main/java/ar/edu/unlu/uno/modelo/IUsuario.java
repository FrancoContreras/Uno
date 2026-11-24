package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

import java.util.Collection;
import java.util.List;

public interface IUsuario {
    String getNombre();
    int getId();
    void formarMano(List<ICarta> iCartas);
    int cantidadDeCartasEnMano();
    List<ICarta> getMano();
    void agregarCarta(ICarta tope);
    ICarta tiraCarta(int opcion);
    boolean opcionPuedeJugarse(int opcion, ICarta carta);
    boolean opcionPuedeJugarse(int opcion, Color color);
}
