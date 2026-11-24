package modelo;

import ar.edu.unlu.uno.modelo.carta.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MazoTest extends BaseTest{

    @Test
    public void getTopeEntregaElTope(){
        ICarta carta = mazo.getTope();

        assertNotEquals(mazo,mazo2);
        assertEquals(mazo2.getTope(), carta);
    }

    @Test
    public void sacarPrimeras7Entrega7Cartas(){
        List<ICarta> sieteCartas = mazo.sacarPrimerasSiete();

        assertNotEquals(mazo2.getCantidadDeCartas(),mazo.getCantidadDeCartas());
        assertEquals(7, sieteCartas.size());
    }

    @Test
    public void mezclarCambiaElOrdenDeLasCartas() {
        mazo.mezclar();

        assertNotEquals(mazo,mazo2);
    }

    @Test
    public void estaVacioEsVerdaderoCuandoNoTieneCartas(){
        assertTrue(mazoVacio.estaVacio());
    }

    @Test
    public void estaVacioEsFalsoCuandoTieneCartas() {
        assertFalse(mazo.estaVacio());
    }
}
