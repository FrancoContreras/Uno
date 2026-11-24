package ar.edu.unlu.uno.vista;

import ar.edu.unlu.uno.controlador.Controlador;
import ar.edu.unlu.uno.modelo.IUsuario;
import ar.edu.unlu.uno.modelo.carta.Color;
import ar.edu.unlu.uno.modelo.carta.ICarta;

import java.util.Scanner;

public class VistaConsola implements IVista{
    private final Controlador controlador;
    private final Scanner scanner;
    private boolean ejecutando = false;

    public VistaConsola(Controlador controlador) {
        // programación defensiva
        this.controlador = controlador;
        this.scanner = new Scanner(System.in); // es el teclado
        this.controlador.setVista(this);
    }

    @Override
    public void mostrarListaUsuarios(IUsuario[] usuarios) {
        System.out.println("===== Lista de usuarios: ");
        for (IUsuario u : usuarios) {
            System.out.println("  - " + u.getNombre() + " - ID: "+ u.getId());
        }
        System.out.println("==========================");
    }

    @Override
    public void mostrarMensajeDelSistema(String mensaje) {
        System.out.println("==========================");
        System.out.println("[SISTEMA] " + mensaje);
        System.out.println("==========================");
    }

    @Override
    public void iniciar() {
        this.ejecutando = true;
        System.out.println("===============================");
        System.out.println("        Sala de UNO");
        System.out.println("===============================");

        // 1. Registrarse de forma obligatoria
        while (this.controlador.getUsuario() == null && this.ejecutando) {
            System.out.print("Ingrese su nombre de usuario: ");
            String nombre = this.scanner.nextLine();
            try {
                this.controlador.conectarUsuario(nombre);
            } catch (IllegalArgumentException e) {
                this.mostrarError("Nombre invalido: " + e.getMessage());
            }
        }
        this.controlador.repartirCartas();

        // 2. Bucle iterativo de comandos
        while (this.ejecutando) {
            this.imprimirMenu();
            String opcion = this.scanner.nextLine().trim();
            this.procesarOpcion(opcion);
        }
    }

    @Override
    public void mostrarManoJugador(ICarta[] manoDelJugador) {
        int opcion = 1;
        System.out.println("===== Mano " + this.controlador.getUsuario().getNombre());
        for (ICarta c : manoDelJugador) {
            System.out.println(c.informarDatos() + " (" + opcion + ")");
            opcion++;
        }
        System.out.println("==========================");
    }

    @Override
    public Color solicitarColor() {
        int opcion = Integer.parseInt(this.scanner.nextLine().trim());
        Color color = Color.NEGRO;

        switch (opcion) {
            case 1:
                color = Color.ROJO;
                break;
            case 2:
                color = Color.AZUL;
                break;
            case 3:
                color = Color.VERDE;
                break;
            case 4:
                color = Color.AMARILLO;
                break;
        }
        return color;
    }

    @Override
    public void mostrarListaDeColores(Color[] coloresParaElegir) {
        int numeroOpcion = 1;
        System.out.println("\nElige un color:");

        for (Color color : coloresParaElegir) {
            if (color == Color.NEGRO) continue;
            System.out.println("(" + numeroOpcion + ") " + color);
            numeroOpcion++;
        }
    }

    private void procesarOpcion(String opcion) {
        switch (opcion) {
            case "1":
                this.controlador.solicitarEstadoDelJuego();
                break;
            case "2":
                this.controlador.jugadorTomaCartaDelMazo();
                break;
            case "3":
                this.controlador.jugadorTomaCartaDelPozo();
                break;
            case "4":
                this.controlador.solicitarEstadoDelJuego();
                System.out.println("Elija una carta para tirar: ");
                int carta = Integer.parseInt(this.scanner.nextLine().trim());
                this.controlador.jugadorTiraCarta(carta);
                break;
            case "5":
                this.controlador.solicitarListaUsuarios();
                break;
            case "0":
                this.controlador.desconectarUsuario();
                this.ejecutando = false;
                System.out.println(">>> Desconectando de la sala. Sesión de chat finalizada");
                break;
            default:
                this.mostrarError("Comando no reconocido. Ingrese una opción de menú.");
                break;
        }
    }

    private void imprimirMenu() {
        System.out.println("\n[1: Ver mano y meza | 2: Tomar carta del mazo |" +
                " 3: Tomar carta del pozo] | 4: Tirar una carta | 5: Ver Usuarios |" +
                " 0: Salir");
        System.out.println(this.getPrompt() + " Ingrese opción: ");
    }

    public void mostrarError(String mensajeError) {
        System.out.println(" [!] ERROR: " + mensajeError);
    }

    private String getPrompt() {
        IUsuario u = controlador.getUsuario();
        return (u != null) ? "[" + u.getNombre() + "]" : "[ANONIMO]";
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

    @Override
    public void mostrarPozo(ICarta carta, Color color) {
        System.out.println("Tope del pozo: " + carta.informarDatos());
        System.out.println("Color del pozo: " + color);
    }

    @Override
    public void mostrarMazo(int i) {
        System.out.println("Mazo: " + i + " cartas");
    }
}
