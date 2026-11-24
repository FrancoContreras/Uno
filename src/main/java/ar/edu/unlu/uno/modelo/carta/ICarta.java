package ar.edu.unlu.uno.modelo.carta;

import ar.edu.unlu.uno.modelo.Juego;

public interface ICarta {
    void jugarseEn(Juego juego);
    boolean esJugableSobre(ICarta cartaTope);
    Color getColor();
    void setColor(Color color);
    String informarDatos();
    String getNombre();

    //Double dispatch
    boolean aceptaEncima(CartaNumerica carta);
    boolean aceptaEncima(CartaRobaDos carta);
    boolean aceptaEncima(CartaReversa carta);
    boolean aceptaEncima(CartaSalteaTurno carta);
}
