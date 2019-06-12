package pctr_2c_2019;

import java.util.ArrayList;

/**
 *
 * CLASE SIMULADOR.
 *
 * Clase que se encarga de configurar y ejecutar el sistema.
 *
 * Creará los elementos que lo constituyen: jugadores, club y material disponible.
 *
 * @author Roberto Sueiro Ventoso
 *
 */

public class Simulador {

    // DEFINICIÓN DE VARIABLES

    public static final int NUM_EXPERTOS = 7;													// Número máximo de jugadores expertos.

    public static final int NUM_NOVATOS = 7;													// Número máximo de jugadores novatos.

    public static final int NUM_PELOTAS = 20;													// Material disponible (máximo de pelotas).

    public static final int NUM_PALOS = 20;														// Material disponible (máximo de palos).

    public static final int NUM_VUELTAS = 5;													// Número de veces máximo que se repite el comportamiento.

    // MÉTODO MAIN

    public static void main (String[] args) {

        // INSTANCIA DE LA CLASE CLUB

        Club club = Club.getSingletonClub(NUM_PELOTAS, NUM_PALOS);								// Instancia de la clase Club.

        club.setJugadores(NUM_EXPERTOS, NUM_NOVATOS, NUM_VUELTAS);								//

        // CREACIÓN DE HILOS

        /**
         *
         * ArrayList VS Array.
         *
         * El ArrayList tiene la ventaja de tener un tamaño dinámico, mientras que el de un Array es definido en su creación.
         *
         * Un ArrayList no puede contener datos primitivos, sólo Objetos.
         *
         * El ArrayList permite comprobar que los datos que se añaden a la colección son del tipo correcto en tiempo de compilación.
         *
         */

        ArrayList<Thread> hilos = new ArrayList<Thread>();										// ArrayList de hilos.

        ArrayList<Jugador> jugadores = club.getJugadores();										// ArrayList de jugadores.

        // ADICIÓN DE UN HILO POR CADA JUGADOR

        for (Jugador j : jugadores) {

            hilos.add(new Thread(j));

        }

        // INICIALIZACIÓN DE LOS HILOS DE LOS JUGADORES

        for (Thread h : hilos) {

            h.start();                                                                          // Inicio.

        }

    }

}
