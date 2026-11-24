package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

import java.util.List;

public class Usuario implements IUsuario {
    private static int ID = 0;
    private String nombre;
    private int id;
    private Mano mano;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.id = Usuario.ID++;
        mano = new Mano();
    }

    public void formarMano(List<ICarta> cartas){
        mano.cargarCartas(cartas);
    }

    @Override
    public void agregarCarta(ICarta carta) {
        mano.agregarCarta(carta);
    }

    @Override
    public ICarta tiraCarta(int opcion) {
        return mano.tiraCarta(opcion);
    }

    @Override
    public boolean opcionPuedeJugarse(int opcion, ICarta carta) {
        return mano.cartaPuedeJugarse(opcion, carta);
    }

    public boolean opcionPuedeJugarse(int opcion, Color color) {
        return mano.cartaPuedeJugarse(opcion, color);
    }

    @Override
    public int cantidadDeCartasEnMano() {
        return mano.getCantidadDeCartas();
    }

    public List<ICarta> getMano() {
        return mano.getCartas();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getId() {
        return id;
    }
}
