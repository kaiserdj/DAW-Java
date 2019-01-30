//Francisco Jesús González Fernández

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner teclado = new Scanner(System.in);
        Baraja Baraja = new Baraja();
        char opcion = '#';
        float apuesta = 0;
        Boolean ronda = true;
        int x = 0;

        System.out.println("Configuración inicial");
        do {
            System.out.print("Con cuanto dinero desea jugar (Si desea añadir centimos pon  el numero con , ): ");
            apuesta = teclado.nextFloat();
            if (apuesta <= 0) {
                System.out.print("Porfavor introducta una catindad mayor a cero");
            }
        } while (apuesta <= 0);
        Jugadores jugadores = new Jugadores(2, apuesta);

        limpiar();

        System.out.println("El juego de las siete y media comienza");
        for(;;) {
            System.out.println("Juegas tu:");
            System.out.println("Tienes " + jugadores.getDineroJugador(0) + "€");
            System.out.println("-----------------------------------------------------------");

            for (int B = 0; B <= 1; ) {
                jugadores.añadir(0, Baraja.Random(), false);
                if(x==0){
                    x++;
                    System.out.println("        " + jugadores.getCartaJugador(0, (0)).toString());
                    do {
                        System.out.print("Cuanto dinero deseas apostar (Si desea añadir centimos pon  el numero con , ): ");
                        apuesta = teclado.nextFloat();
                        if (apuesta <= 0 || jugadores.getDineroJugador(0) < apuesta) {
                            System.out.print("Porfavor introducta una catindad que tenga y mayor que 0");
                        }
                    } while (apuesta <= 0 || jugadores.getDineroJugador(0) < apuesta);
                }else {
                    x++;
                    System.out.println("        " + jugadores.getCartaJugador(0, (x - 1)).toString());
                }
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
                        System.out.print("Tu puntuación es " + jugadores.getPuntosJugador(0) + " ¿Te plantas (s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'S') {
                        System.out.println("Tu puntuación obtenida es " + jugadores.getPuntosJugador(0));
                        B = 2;
                    }
                } else if (jugadores.getPuntosJugador(0) == 7.5f) {
                    System.out.println("------------------------------");
                    System.out.println("--        Has ganado        --");
                    System.out.println("------------------------------");
                    jugadores.añadirDineroJugador(0,apuesta);
                    do {
                        System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'S') {
                        System.exit(0);
                    }else{
                        ronda=false;
                        B=2;
                        x=0;
                        Baraja = new Baraja();
                        jugadores.quitarCartas();
                        limpiar();
                    }
                } else {
                    System.out.println("------------------------------");
                    System.out.println("--       Has perdido        --");
                    System.out.println("------------------------------");
                    jugadores.quitarDineroJugador(0,apuesta);
                    ronda=false;
                    if (jugadores.getDineroJugador(0) <= 0) {
                        System.out.println("Oh no, te arruinaste.");
                        System.exit(0);
                    }
                    do {
                        System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'S') {
                        System.exit(0);
                    }else{
                        ronda=false;
                        B=2;
                        x=0;
                        Baraja = new Baraja();
                        jugadores.quitarCartas();
                        limpiar();
                    }
                }
            }
            System.out.println();
            if(ronda==true) {
                System.out.println("\nJuega la banca:");
                System.out.println("-----------------------------------------------------------");
                x = 0;
                for (int B = 0; B <= 1; ) {
                    jugadores.añadir(1, Baraja.Random(), false);
                    x++;
                    System.out.println("        " + jugadores.getCartaJugador(1, (x - 1)).toString());
                    if (jugadores.getPuntosJugador(1) < 7.5f) {
                        if ((jugadores.getPuntosVisibleJugador(0) < 6 && jugadores.getPuntosJugador(1) >= 6) || (jugadores.getPuntosVisibleJugador(0) >= 6 && jugadores.getPuntosJugador(1) >= (jugadores.getPuntosVisibleJugador(0) + 0.5f))) {
                            if (jugadores.getPuntosJugador(0) > jugadores.getPuntosJugador(1)) {
                                System.out.println("------------------------------");
                                System.out.println("--      La banca pierde     --");
                                System.out.println("--         Has ganado       --");
                                System.out.println("------------------------------");
                                jugadores.añadirDineroJugador(0,apuesta);
                                do {
                                    System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                                    opcion = teclado.next().charAt(0);
                                    opcion = Character.toUpperCase(opcion);
                                    if (opcion != 'S' && opcion != 'N') {
                                        System.out.print("Porfavor introduzca s/n");
                                    }
                                } while (opcion != 'S' && opcion != 'N');
                                if (opcion == 'S') {
                                    System.exit(0);
                                }else{
                                    B=2;
                                }
                            } else {
                                System.out.println("------------------------------");
                                System.out.println("--       La banca gana      --");
                                System.out.println("--        Has perdido       --");
                                System.out.println("------------------------------");
                                jugadores.quitarDineroJugador(0,apuesta);
                                if (jugadores.getDineroJugador(0) <= 0) {
                                    System.out.println("Oh no, te arruinaste.");
                                    System.exit(0);
                                }
                                do {
                                    System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                                    opcion = teclado.next().charAt(0);
                                    opcion = Character.toUpperCase(opcion);
                                    if (opcion != 'S' && opcion != 'N') {
                                        System.out.print("Porfavor introduzca s/n");
                                    }
                                } while (opcion != 'S' && opcion != 'N');
                                if (opcion == 'S') {
                                    System.exit(0);
                                }else{
                                    B=2;
                                }
                            }
                        }
                    } else if (jugadores.getPuntosJugador(1) == 7.5f) {
                        System.out.println("------------------------------");
                        System.out.println("--       La banca gana      --");
                        System.out.println("--        Has perdido       --");
                        System.out.println("------------------------------");
                        jugadores.quitarDineroJugador(0,apuesta);
                        if (jugadores.getDineroJugador(0) <= 0) {
                            System.out.println("Oh no, te arruinaste.");
                            System.exit(0);
                        }
                        do {
                            System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                            opcion = teclado.next().charAt(0);
                            opcion = Character.toUpperCase(opcion);
                            if (opcion != 'S' && opcion != 'N') {
                                System.out.print("Porfavor introduzca s/n");
                            }
                        } while (opcion != 'S' && opcion != 'N');
                        if (opcion == 'S') {
                            System.exit(0);
                        }else{
                            B=2;
                        }
                    } else {
                        System.out.println("------------------------------");
                        System.out.println("--      La banca pierde     --");
                        System.out.println("--         Has ganado       --");
                        System.out.println("------------------------------");
                        jugadores.añadirDineroJugador(0,apuesta);
                        do {
                            System.out.print("Tienes " + jugadores.getDineroJugador(0) + "€. ¿Te plantas(s/n)?: ");
                            opcion = teclado.next().charAt(0);
                            opcion = Character.toUpperCase(opcion);
                            if (opcion != 'S' && opcion != 'N') {
                                System.out.print("Porfavor introduzca s/n");
                            }
                        } while (opcion != 'S' && opcion != 'N');
                        if (opcion == 'S') {
                            System.exit(0);
                        }else{
                            B=2;
                        }
                    }
                }
            }
            x=0;
            Baraja = new Baraja();
            jugadores.quitarCartas();
            limpiar();
        }
    }

    public static void limpiar(){
        for(int i=0;i<25;i++){
            System.out.println();
        }
    }
}
