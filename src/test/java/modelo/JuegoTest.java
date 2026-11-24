package modelo;

import ar.edu.unlu.uno.modelo.*;
import ar.edu.unlu.uno.modelo.carta.CartaCambiaColor;
import ar.edu.unlu.uno.modelo.carta.ICarta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JuegoTest {
    private Juego juego;
    private Mazo mazo;
    private Pozo pozo;

    @BeforeEach
    void setUp(){
        juego = new Juego();
        mazo = new Mazo();
        pozo = new Pozo(mazo.getTope());
        juego.conectarUsuario("Fran");
        juego.conectarUsuario("Leo");
    }

    @Test
    void conectarUsuarioConectaUsuarios(){
        assertEquals(2, juego.getUsuarios().length);
    }

//    @Test
//    void cambiarTopeDelPozoCambiaSuCartaTope(){
//        juego.cambiarTopeDelPozo(new CartaCambiaColor());
//    }

//    @Test
//    void repartirCartasReparte7ParaCadaJugador(){
//        juego.repartirCartas(juego.getUsuarios()[0]);
//
//        assertEquals(7, juego.getUsuarios()[0].cantidadDeCartasEnMano());
//    }

//    @Test
//    void jugadorTiraCartaModificaEstadoDelPozoYMano(){
//        ICarta carta = new CartaCambiaColor();
//        IUsuario usuario = juego.getUsuarios()[0];
//
//        juego.repartirCartas();
//        juego.jugadorTiraCarta(usuario, carta);
//
//        assertEquals(2, pozo.cantidadDeCartas());
//        assertEquals(6, usuario.cantidadDeCartasEnMano());
//    }
}
