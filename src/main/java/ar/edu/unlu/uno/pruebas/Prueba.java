package ar.edu.unlu.uno.pruebas;

import ar.edu.unlu.uno.controlador.Controlador;
import ar.edu.unlu.uno.modelo.Juego;
import ar.edu.unlu.uno.vista.VistaConsola;
import ar.edu.unlu.uno.vista.IVista;

public class Prueba {

    public static void main(String[] args) {

        // 1 instancia compartida por los controllers / vista
        Juego juego = new Juego();

        // 2 Controlador + Vista de Cliente 1
        Controlador ctrlJugador1 = new Controlador(juego);
        IVista vistaJugador1 = new VistaConsola(ctrlJugador1);

        // 3 Controlador + Vista de Cliente 2
//        Controlador ctrlJugador2 = new Controlador(juego);
//        IVista vistaJugador2 = new VistaConsola(ctrlJugador2);

//        ctrlJugador1.conectarUsuario("Jugador 1");
//        ctrlJugador2.conectarUsuario("Jugador 2");

        vistaJugador1.iniciar();
//        vistaJugador2.iniciar();


//        while(ctrlJugador1.getUsuario() != null && ctrlJugador2.getUsuario() != null){
//            vistaJugador1.iniciar();
//            vistaJugador2.iniciar();
//        }

//        while(true){
//            if(ctrlJugador1.getUsuario() == null){
//                break;
//            }
//            vistaJugador1.iniciar();
//            if(ctrlJugador2.getUsuario() == null){
//                break;
//            }
//            vistaJugador2.iniciar();
//        }
    }
}
