//Francisco Jesús González Fernández

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner teclado = new Scanner(System.in);
        Baraja Baraja = new Baraja(false);
        Jugadores jugadores = new Jugadores(2);
        char opcion = '#';
        int x = 0;

        System.out.println("El juego de las siete y media comienza");
        System.out.println("Juegas tu:");
        System.out.println("-----------------------------------------------------------");

        for (int B = 0; B <= 1; ) {
            jugadores.añadir(0, Baraja.Random(), false);
            x++;
            System.out.println("        " + jugadores.getCartaJugador(0, (x-1)).toString());

            if (jugadores.getPuntosJugador(0) < 7.5f) {
                do {
                    System.out.print("¿Deseas ocultar esta carta (s/n)?: ");
                    opcion = teclado.next().charAt(0);
                    opcion = Character.toUpperCase(opcion);
                    if (opcion != 'S' && opcion != 'N') {
                        System.out.print("Porfavor introduzca s/n");
                    }
                } while (opcion != 'S' && opcion != 'N');
                if (opcion == 'S') {
                    if (x == 1) {
                        jugadores.setOcultas(0, 0, true);
                    } else {
                        for (int Q = 0; Q < jugadores.getNumCartasJugador(0); Q++) {
                            jugadores.setOcultas(0, Q, false);
                        }
                        jugadores.setOcultas(0, (x - 1), true);
                    }
                } else {
                    jugadores.setOcultas(0, (x - 1), false);
                }
                System.out.println("Tu puntuación a la vista es " + jugadores.getPuntosVisibleJugador(0));
                do {
                    System.out.print("Tu puntuación es " + jugadores.getPuntosJugador(0)+ " ¿Te plantas (s/n)?: ");
                    opcion = teclado.next().charAt(0);
                    opcion = Character.toUpperCase(opcion);
                    if (opcion != 'S' && opcion != 'N') {
                        System.out.print("Porfavor introduzca s/n");
                    }
                } while (opcion != 'S' && opcion != 'N');
                if(opcion=='S'){
                    System.out.println("Tu puntuación obtenida es " + jugadores.getPuntosJugador(0));
                    B=2;
                }
            } else if (jugadores.getPuntosJugador(0) == 7.5f) {
                System.out.println("------------------------------");
                System.out.println("--        Has ganado        --");
                System.out.println("------------------------------");
                System.exit(0);
            } else {
                System.out.println("------------------------------");
                System.out.println("--       Has perdido        --");
                System.out.println("------------------------------");
                System.exit(0);
            }
        }

        System.out.println("\nJuega la banca:");
        System.out.println("-----------------------------------------------------------");
        x=0;
        for(;;){
            jugadores.añadir(1, Baraja.Random(), false);
            x++;
            System.out.println("        " + jugadores.getCartaJugador(1, (x-1)).toString());

            if(jugadores.getPuntosJugador(1) < 7.5f){
                if((jugadores.getPuntosVisibleJugador(0)<6 && jugadores.getPuntosJugador(1)>=6)|| (jugadores.getPuntosVisibleJugador(0)>=6 && jugadores.getPuntosJugador(1)>=(jugadores.getPuntosVisibleJugador(0)+0.5f))){
                    if(jugadores.getPuntosJugador(0)>jugadores.getPuntosJugador(1)){
                        System.out.println("------------------------------");
                        System.out.println("--      La banca pierde     --");
                        System.out.println("--         Has ganado       --");
                        System.out.println("------------------------------");
                        System.exit(0);
                    }else {
                        System.out.println("------------------------------");
                        System.out.println("--       La banca gana      --");
                        System.out.println("--        Has perdido       --");
                        System.out.println("------------------------------");
                        System.exit(0);
                    }
                }
            }else if(jugadores.getPuntosJugador(1) == 7.5f){
                System.out.println("------------------------------");
                System.out.println("--       La banca gana      --");
                System.out.println("--        Has perdido       --");
                System.out.println("------------------------------");
                System.exit(0);
            }else{
                System.out.println("------------------------------");
                System.out.println("--      La banca pierde     --");
                System.out.println("--         Has ganado       --");
                System.out.println("------------------------------");
                System.exit(0);
            }
        }
    }
}
