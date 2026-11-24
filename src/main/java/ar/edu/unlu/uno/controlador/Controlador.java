package ar.edu.unlu.uno.controlador;

import ar.edu.unlu.uno.modelo.IUsuario;
import ar.edu.unlu.uno.modelo.Juego;
import ar.edu.unlu.uno.modelo.Eventos;
import ar.edu.unlu.uno.observer.IObservable;
import ar.edu.unlu.uno.observer.IObservador;
import ar.edu.unlu.uno.vista.IVista;

public class Controlador implements IObservador {
    private IVista vista;
    private final Juego juego;
    private IUsuario usuario;

    public Controlador(Juego juego) {
        // programcion defensiva
        this.juego = juego;
        this.juego.agregarObservador(this);
    }

    @Override
    public void actualizar(IObservable observable, Object e) {
        Eventos evento = (Eventos) e;
        switch (evento) {
            case CAMBIO_ESTADO_JUEGO:
                if(this.usuario != null){
                    this.solicitarEstadoDelJuego();
                }
                break;
            case CAMBIO_LISTA_USUARIOS:
                this.vista.mostrarListaUsuarios(this.juego.getUsuarios());
                break;
            case NUEVO_MENSAJE:
                this.vista.mostrarMensajeDelSistema(this.juego.getMensaje());
                break;
            case JUGADA_FALLIDA:
                this.vista.mostrarMensajeDelSistema(this.juego.getMensaje());
                break;
            case ESPERANDO_COLOR:
                this.vista.mostrarMensajeDelSistema(this.juego.getMensaje());
                this.vista.mostrarListaDeColores(this.juego.getColoresParaElegir());
                this.juego.cambiarColorDelPozo(this.vista.solicitarColor());
                break;
        }
    }

    public void setVista(IVista vista) {
        this.vista = vista;
    }

    public IUsuario conectarUsuario(String username) {
        this.usuario = this.juego.conectarUsuario(username);
        return usuario;
    }

    public void desconectarUsuario() {
        this.juego.desconectarUsuario(usuario.getId());
        this.usuario = null;
    }

    public IUsuario getUsuario() {
        return usuario;
    }

    public void solicitarListaUsuarios() {
        if (this.vista != null) {
            this.vista.mostrarListaUsuarios(this.juego.getUsuarios());
        }
    }

    public void jugadorTomaCartaDelMazo() {
        if (this.vista != null) {
            this.juego.jugadorAgarraDelMazo(this.usuario.getId());
        }
    }

    public void jugadorTomaCartaDelPozo() {
        if (this.vista != null) {
            this.juego.jugadorAgarraDelPozo(this.usuario.getId());
        }
    }

    public void jugadorTiraCarta(int opcion) {
        if (this.vista != null) {
            this.juego.jugadorTiraCarta(opcion, this.usuario.getId());
        }
    }

    public void repartirCartas() {
        this.juego.repartir7Cartas(this.usuario.getId());
    }

    public void solicitarEstadoDelJuego() {
        this.vista.mostrarManoJugador(this.juego.getManoDelJugador(this.usuario.getId()));
        this.vista.mostrarMazo(this.juego.cantidadDelMazo());
        this.vista.mostrarPozo(this.juego.topeDelPozo(), this.juego.colorActivoDelPozo());
    }
}
