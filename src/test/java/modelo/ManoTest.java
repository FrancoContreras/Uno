package modelo;

import ar.edu.unlu.uno.modelo.Mano;
import ar.edu.unlu.uno.modelo.Mazo;
import ar.edu.unlu.uno.modelo.carta.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManoTest {
    @Test
    void cargarCartasAgregaCartas(){
        Mano mano = new Mano();
        Mazo mazo = new Mazo();

        mano.cargarCartas(mazo.sacarPrimerasSiete());

        assertEquals(7, mano.getCantidadDeCartas());
    }
}
