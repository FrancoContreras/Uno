package modelo;

import ar.edu.unlu.uno.modelo.carta.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartaTest {
    private ICarta cartaNumerica;
    private ICarta cartaRobaDos;
    private ICarta cartaRobaCuatro;
    private ICarta cartaReversa;
    private ICarta cartaSalteaTurno;
    private ICarta cartaCambiaColor;

    @BeforeEach
    public void setUp() {
        cartaNumerica = new CartaNumerica(Color.ROJO, Numero.DOS);
        cartaRobaDos = new CartaRobaDos(Color.AZUL);
        cartaRobaCuatro = new CartaRobaCuatro();
        cartaReversa = new CartaReversa(Color.AMARILLO);
        cartaSalteaTurno = new CartaSalteaTurno(Color.VERDE);
        cartaCambiaColor = new CartaCambiaColor();
    }
}
