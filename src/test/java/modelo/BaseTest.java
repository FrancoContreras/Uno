package modelo;

import ar.edu.unlu.uno.modelo.Mazo;
import ar.edu.unlu.uno.modelo.Pozo;
import ar.edu.unlu.uno.modelo.carta.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public abstract class BaseTest {
    protected Mazo mazoConUnaMenos;
    protected Mazo mazo;
    protected Mazo mazo2;
    protected Mazo mazoVacio;
    protected Mazo mazoVacio2;
    protected Pozo pozo;
    protected Pozo pozo2;

    @BeforeEach
    void setUpBase() {
        mazo = new Mazo();
        mazo2 = new Mazo();
        mazoVacio = new Mazo(new ArrayList<>());
        mazoVacio2 = new Mazo(new ArrayList<>());
        mazoConUnaMenos = new Mazo();
        ICarta carta = mazoConUnaMenos.getTope();
        pozo = new Pozo(carta);
        pozo2 = new Pozo(carta);
    }
}
