//Francisco Jesús González Fernández

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner teclado = new Scanner(System.in);
        Baraja Baraja = new Baraja(false);
        Jugadores jugadores = new Jugadores(2);
        String[] JUGADORES = {"Jugador", "Banca"};
        char opcion = '#';
        int repetir = 0;

        System.out.println("El juego de las siete y media comienza");
        for (int i = 0; i < JUGADORES.length; i++) {
            System.out.println("Juega " + JUGADORES[i]);
            System.out.println("-----------------------------------------------------------");
            NaipeEspañola carta = Baraja.Random();
            if (i != (JUGADORES.length - 1)) {
                jugadores.añadir(i, carta, true);
            } else {
                jugadores.añadir(i, carta, false);
            }

            for (int x = 0; x < jugadores.getNumCartasJugador(i); x++) {
                carta = jugadores.getCartaJugador(i, x);
                System.out.print("    " + (x + 1) + "º " + carta.toString() + " --> Carta: ");
                if (jugadores.getOcultas(i, x) == true) {
                    System.out.println("Oculta");
                } else {
                    System.out.println("No oculta");
                }
            }

            do {
                if (jugadores.getNumCartasJugador(i) == 1 && i != (JUGADORES.length - 1)) {
                    do {
                        System.out.print("Tu puntuación es " + jugadores.getPuntosJugador(i) + ". ¿Te plantas (s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'N') {
                        repetir = 1;
                    } else {
                        System.out.println("La puntuación obtenida es " + jugadores.getPuntosJugador(i));
                    }
                } else if (i != (JUGADORES.length - 1)) {
                    do {
                        System.out.print("Desea ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.println("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    do {
                        System.out.print("Tu puntuación es " + jugadores.getPuntosJugador(i) + ". ¿Te plantas (s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.println("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'N') {
                        repetir = 1;
                    } else {
                        System.out.println("La puntuación obtenida es " + jugadores.getPuntosJugador(i));
                    }
                } else {
                    if ((jugadores.getPuntosVisibleJugador(0) < 6 && jugadores.getPuntosJugador(i) >= 6) || (jugadores.getPuntosVisibleJugador(0) >= 6 || jugadores.getPuntosJugador(i) >= (jugadores.getPuntosVisibleJugador(0) + 0.5f))) {
                        System.out.println("La banca se planta y ga");
                    }
                }
            } while (repetir == 1);
        }
    }
}
