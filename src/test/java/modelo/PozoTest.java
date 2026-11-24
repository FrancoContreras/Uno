package modelo;

import ar.edu.unlu.uno.modelo.Mazo;
import ar.edu.unlu.uno.modelo.Pozo;
import ar.edu.unlu.uno.modelo.carta.CartaCambiaColor;
import ar.edu.unlu.uno.modelo.carta.ICarta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PozoTest{
    private Mazo mazo;
    private Pozo pozo;
    private Pozo pozo2;

    @BeforeEach
    void setUp(){
        mazo = new Mazo();
        ICarta carta = mazo.getTope();
        pozo = new Pozo(carta);
        pozo2 = new Pozo(carta);
    }

    @Test
    void agregarCartaAlTopeAgregaNuevaCarta(){
        assertEquals(1, pozo.cantidadDeCartas());
        pozo.agregarCarta(new CartaCambiaColor());
        assertEquals(2, pozo.cantidadDeCartas());
    }

    @Test
    void agregarCartaAlTopeCambiaColorActivo(){
        assertEquals(pozo2.getColorActivo(), pozo.getColorActivo());
        pozo.agregarCarta(new CartaCambiaColor());
        assertNotEquals(pozo2.getColorActivo(), pozo.getColorActivo());
    }

    @Test
    public void getTopeEntregaElTope(){
        ICarta carta = pozo.getTope();

        assertNotEquals(pozo,pozo2);
        assertEquals(pozo2.getTope(), carta);
    }

    @Test
    public void reciclarRecargaMazoVacio(){
        Mazo mazoVacio = new Mazo(new ArrayList<>());
        Mazo mazoRecargado = new Mazo(new ArrayList<>());

        assertEquals(mazoVacio,mazoRecargado);

        pozo.agregarCarta(mazo.getTope());
        pozo.agregarCarta(mazo.getTope());
        mazoRecargado.recargar(pozo.reciclar());

        assertNotEquals(mazoVacio,mazoRecargado);
    }
}
