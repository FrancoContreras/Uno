package ar.edu.unlu.uno.vista;

import ar.edu.unlu.uno.modelo.IUsuario;
import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

public interface IVista {
    void mostrarListaUsuarios(IUsuario[] usuarios);
    void mostrarMensajeDelSistema(String mensaje);
    //void mostrarJuego();
    void iniciar();
    void mostrarManoJugador(ICarta[] manoDelJugador);

    Color solicitarColor();
    void mostrarListaDeColores(Color[] coloresParaElegir);
    public void setEjecutando(boolean ejecutando);

    void mostrarPozo(ICarta Carta, Color color);

    void mostrarMazo(int i);
}
