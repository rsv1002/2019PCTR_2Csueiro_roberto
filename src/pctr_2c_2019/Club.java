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

}
