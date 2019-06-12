package pctr_2c_2019;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * CLASE JUGADOR.
 *
 * Hilo que implementa la interfaz Runnable.
 *
 * @author Roberto Sueiro Ventoso
 *
 */

public class Jugador {

    // DEFINICIÓN DE CONSTANTES PARA CONTROL DE INVARIANTES

    public static final int MIN_PELOTAS_NOVATOS = 2;			// Constante para el control de pelotas mínimas para jugadores novatos.

    public static final int MAX_PELOTAS_NOVATOS = 5;			// Constante para el control de pelotas máximas para jugadores novatos.

    public static final int MAX_PALOS_NOVATOS = 2;				// Constante para el control de palos máximos para jugadores novatos.

    public static final int MAX_PELOTAS_EXPERTOS = 1;			// Constante para el control de pelotas máximas para jugadores expertos.

    public static final int MIN_PALOS_EXPERTOS = 2;				// Constante para el control de palos mínimos para jugadores expertos.

    public static final int MAX_PALOS_EXPERTOS = 5;				// Constante para el control de palos máximas para jugadores expertos.

    // DEFINICIÓN DE VARIABLES

    private int id;																	// Atributo de tipo int.

    private boolean experto;														// Atributo de tipo boolean.

    private int numVueltas;															// Atributo de tipo int.

    private Club elClub;															// Objeto de tipo Club.

    int tiempo = ThreadLocalRandom.current().nextInt(0, 999);			// Atributo de tipo int.

    int pelotasActuales;															// Atributo de tipo int.

    int palosActuales;																// Atributo de tipo int.

    String ident;																	// Atributo de tipo string.

    // DEFINICIÓN DE CONSTRUCTOR

    /**
     *
     * DEFINICIÓN DE CONSTRUCTOR
     *
     * @param id - int
     *
     * @param experto - boolean
     *
     * @param numVueltas - int
     *
     * @param elClub - Club
     *
     */

    public Jugador (int id, boolean experto, int numVueltas, Club elClub) {

        ident = "";

        ident += id;

        this.id = id;

        this.experto = experto;

        this.numVueltas = numVueltas;

        this.elClub = elClub;

        this.palosActuales = 0;

        this.pelotasActuales = 0;

        // ASIGNACIÓN DE ATRIBUTO DE DIFERENCIACIÓN PARA NOVATO Y EXPERTO

        if (experto) {

            ident += "+";

        } else {

            ident += "-";

        }

    }

    // MÉTODO RUN PARA LOS HILOS

    @Override
    public void run() {

        int pelotas, palos, i;

        if (experto) {

            pelotas = MAX_PELOTAS_EXPERTOS;

            palos = ThreadLocalRandom.current().nextInt(MIN_PALOS_EXPERTOS, MAX_PALOS_EXPERTOS);

        } else {

            pelotas = ThreadLocalRandom.current().nextInt(MIN_PELOTAS_NOVATOS, MAX_PELOTAS_NOVATOS);

            palos = MAX_PALOS_NOVATOS;

        }

        for (i = 0; i < numVueltas; i++) {

            System.out.println(this.ident + "[" + pelotas + "," + palos + "] reservar");

            try {

                elClub.reservar(pelotas, palos);

                pelotasActuales += pelotas;

                palosActuales += palos;

            } catch (InterruptedException e1) {

                e1.printStackTrace();

            }

            System.out.println(this.ident + "[" + pelotasActuales + "," + palosActuales + "] jugar");

            try {

                Thread.sleep(tiempo);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            System.out.println(this.ident + "[" + pelotasActuales + "," + palosActuales + "] devolver");

            try {

                elClub.devolver(pelotasActuales, palosActuales);

                pelotasActuales -= pelotasActuales;

                palosActuales -= palosActuales;

            } catch (InterruptedException e1) {

                e1.printStackTrace();

            }

            System.out.println(this.ident + "[" + pelotas + "," + palos + "] descansar");

            try {

                Thread.sleep(tiempo);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }

    }

}
