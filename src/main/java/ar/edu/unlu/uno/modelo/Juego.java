package ar.edu.unlu.uno.modelo;

import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;
import ar.edu.unlu.uno.observer.Observable;

import java.util.*;

public class Juego extends Observable {
    private HashMap<Integer, IUsuario> usuarios;
    private Mazo mazo;
    private Pozo pozo;
    private String mensaje;

    public Juego() {
        this.usuarios = new HashMap<>();
        this.mazo = new Mazo();
        this.pozo = new Pozo(mazo.getTope());
    }

    public void jugadorTiraCarta(int opcion, int usuarioId){
        if(usuarios.get(usuarioId).opcionPuedeJugarse(opcion, pozo.getTopeSinRemover())){
            usuarios.get(usuarioId).tiraCarta(opcion).jugarseEn(this);
            this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
        }
        else{
            if(pozo.getTopeSinRemover().getColor() == Color.NEGRO
                    && usuarios.get(usuarioId).opcionPuedeJugarse(opcion, pozo.getColorActivo())){

                usuarios.get(usuarioId).tiraCarta(opcion).jugarseEn(this);
                this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
            }
            else{
                mensaje = "Jugada errónea";
                this.notificarObservadores(Eventos.JUGADA_FALLIDA);
            }
        }
    }

    public void jugadorAgarraDelPozo(int usuarioId){
        try {
            usuarios.get(usuarioId).agregarCarta(pozo.getTope());
        } catch (IllegalStateException e) {
            mensaje = "Jugada errónea";
            this.notificarObservadores(Eventos.JUGADA_FALLIDA);
        }
        this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
    }

    public void jugadorAgarraDelMazo(int usuarioId){
        usuarios.get(usuarioId).agregarCarta(mazo.getTope());
        this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
    }

    public void repartir7Cartas(int usuarioId){
        usuarios.get(usuarioId).formarMano(mazo.sacarPrimerasSiete());
        this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
    }

    public void repartirCartas(int n) {
        mensaje = "El siguiente jugador deberá tomar " + n + " cartas";
        this.notificarObservadores(Eventos.NUEVO_MENSAJE);
    }

    public void saltearTurno(){
        mensaje = "\nTURNO SALTEADO\n";
        this.notificarObservadores(Eventos.NUEVO_MENSAJE);
    }

    public void notificarEsperandoColor(){
        this.notificarObservadores(Eventos.ESPERANDO_COLOR);
    }

    public void invertirRonda() {
        mensaje = "\nRONDA INVERTIDA\n";
        this.notificarObservadores(Eventos.NUEVO_MENSAJE);
    }

    public void cambiarColorDelPozo(Color colorElegido){
        mensaje = "\nCAMBIO COLOR\n";
        pozo.setColorActivo(colorElegido);
        this.notificarObservadores(Eventos.CAMBIO_ESTADO_JUEGO);
    }

    public Color[] getColoresParaElegir(){
        return new Color[]{ Color.ROJO, Color.AZUL, Color.VERDE, Color.AMARILLO };
    }

    public ICarta[] getManoDelJugador(int usuarioId) {
        ICarta[] resultado = new ICarta[usuarios.get(usuarioId).cantidadDeCartasEnMano()];
        return usuarios.get(usuarioId).getMano().toArray(resultado);
    }

    public ICarta topeDelPozo(){
        return pozo.getTopeSinRemover();
    }

    public Color colorActivoDelPozo(){
        return pozo.getColorActivo();
    }

    public int cantidadDelMazo(){
        return mazo.getCantidadDeCartas();
    }

    public void cambiarTopeDelPozo(ICarta carta) {pozo.agregarCarta(carta);}

    public IUsuario conectarUsuario(String nombre) {
        IUsuario u = new Usuario(nombre);
        this.usuarios.put(u.getId(), u);
        this.enviarMensajeDelSistema("Usuario " + nombre + " conectado");
        this.notificarObservadores(Eventos.CAMBIO_LISTA_USUARIOS);
        return u;
    }

    public void desconectarUsuario(int usuarioId) {
        IUsuario iUsuario = this.usuarios.get(usuarioId);
        if (iUsuario != null) {
            this.usuarios.remove(usuarioId);
            this.enviarMensajeDelSistema("Usuario " + iUsuario.getNombre() + " desconectado");
            this.notificarObservadores(Eventos.CAMBIO_LISTA_USUARIOS);
        }
    }

    public IUsuario[] getUsuarios() {
        IUsuario[] resultado = new IUsuario[this.usuarios.size()];
        return this.usuarios.values().toArray(resultado);
    }

    public void enviarMensajeDelSistema(String texto) {
        mensaje = texto;
        this.notificarObservadores(Eventos.NUEVO_MENSAJE);
    }

    public String getMensaje() {
        return mensaje;
    }
}
