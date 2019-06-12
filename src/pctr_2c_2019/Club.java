package pctr_2c_2019;

import java.util.ArrayList;

/**
 *
 * CLASE CLUB.
 *
 * Clase que se encarga de configurar y ejecutar el sistema.
 *
 * Creará los elementos que lo constituyen: jugadores, club y material
 *
 * @author Roberto Sueiro Ventoso
 *
 */

public class Club {

    private boolean acceso;															//

    // DEFINICIÓN DE ARRAYS PARA GESTIÓN DE JUGADORES

    public static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();			// Array de jugadores novatos.

    // DEFINICIÓN DE MATERIAL DISPONIBLE.

    private int pelotasActuales;												    // Número de pelotas iniciales disponibles.

    private int palosActuales;													    // Número de palos iniciales disponibles.

    //

    private static final Object Lock = Club.class;									//

    private static Club club;														//

    /**
     *
     * CONSTRUCTOR PRIVADO.
     *
     * El contructor privado evita que se cree un constructor por defecto.
     *
     * En el inicializamos las variables.
     *
     */

    private Club (int numPelotasIniciales, int numPalosIniciales) {

        this.pelotasActuales = numPelotasIniciales;

        this.palosActuales = numPalosIniciales;

        this.acceso = false;

    }

    /**
     *
     * INSTANCIA: Singleton.
     *
     * Se garantiza que solo tenga una instancia y asi evitar la inicializacion retardada.
     *
     */

    public static Club getSingletonClub(int pelotas, int palos) {

        synchronized (Lock) {

            if (club == null) {

                club = new Club(pelotas, palos);

            }

            return club;
        }

    }

    // MÉTODOS SYNCHRONIZED

    /**
     *
     * Método sincronizado reservar.
     *
     * @param pelotas
     *
     * @param palos
     *
     * @throws InterruptedException
     *
     * @return void
     *
     */

    public synchronized void reservar (int pelotas, int palos) throws InterruptedException {

        while (acceso) {

            wait();

        }

        acceso = true;

        while (pelotas > pelotasActuales || palos > palosActuales) {

            acceso = false;

            wait();

            acceso = true;

        }

        pelotasActuales = pelotasActuales - pelotas;

        palosActuales = palosActuales - palos;

        acceso = false;

        notifyAll();

        invariantePalos(palos);

        invariantePelotas(pelotas);


    }

    /**
     *
     * Método sincronizado devolver.
     *
     * @param pelotas
     *
     * @param palos
     *
     * @throws InterruptedException
     *
     * @return void
     *
     */

    public synchronized void devolver (int pelotas, int palos) throws InterruptedException {

        while (acceso) {

            wait();

        }

        acceso = true;

        pelotasActuales = pelotasActuales + pelotas;

        palosActuales = palosActuales + palos;

        acceso = false;

        notifyAll();

        invariantePalos(palos);

        invariantePelotas(pelotas);

    }

    

}
