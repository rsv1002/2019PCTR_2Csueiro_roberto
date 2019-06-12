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

    public static final int MIN_PELOTAS_NOVATOS = 2;			// Número

    public static final int MAX_PELOTAS_NOVATOS = 5;			// Número

    public static final int MAX_PALOS_NOVATOS = 2;				// Número

    public static final int MAX_PELOTAS_EXPERTOS = 1;			// Número

    public static final int MIN_PALOS_EXPERTOS = 2;				// Número

    public static final int MAX_PALOS_EXPERTOS = 5;				// Número

    // DEFINICIÓN DE VARIABLES

    private int id;																	// Atributo de tipo int.

    private boolean experto;														// Atributo de tipo boolean.

    private int numVueltas;															// Atributo de tipo int.

    private Club elClub;															// Objeto de tipo Club.

    int tiempo = ThreadLocalRandom.current().nextInt(0, 999);				// Atributo de tipo int.

    int pelotasActuales;															//

    int palosActuales;																//

    String ident;																	// Atributo de tipo string.

}
