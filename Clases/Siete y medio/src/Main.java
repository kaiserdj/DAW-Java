//Francisco Jesús González Fernández

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner teclado = new Scanner(System.in);
        Baraja Baraja = new Baraja();
        char opcion = '#';
        float apuesta = 0;
        Boolean ronda = true;
        int jug = 0, x = 0, banca = 0;

        System.out.println("Configuración inicial");
        do {
            System.out.print("Con cuanto dinero desea jugar (Si desea añadir centimos pon  el numero con , ): ");
            apuesta = teclado.nextFloat();
            if (apuesta <= 0) {
                System.out.println("Porfavor introducta una catindad mayor a cero");
            }
        } while (apuesta <= 0);
        do {
            System.out.print("Cuantos jugadores jugaran maximo 7 (sin incluir la banca): ");
            jug = teclado.nextInt();
            if (jug <= 0 || jug > 7) {
                System.out.println("Porfavor introducta un numero entre 1-7");
            }
        } while (jug <= 0 || jug > 7);
        Jugadores jugadores = new Jugadores((jug + 1), apuesta);
        banca = jugadores.getJugadores();

        limpiar();

        System.out.println("El juego de las siete y media comienza");
        for (; ; ) {
            int sin_dinero=0;
            for (int i = 0; i < jugadores.getJugadores(); i++) {
                if(jugadores.getDineroJugador(i)==0){
                    sin_dinero++;
                }
                if(sin_dinero==jugadores.getJugadores()){
                    System.out.println("Todos los jugadores se han arruindado.");
                    System.out.print("Se acabo el juego.");
                    System.exit(0);
                }
            }
            for (int i = 0; i < jugadores.getJugadores(); i++) {
                if (jugadores.getDineroJugador(i) > 0) {
                    x = 0;
                    System.out.println("Juegas el jugador " + (i+1) + ":");
                    System.out.println("Tienes " + jugadores.getDineroJugador(i) + "€");
                    System.out.println("-----------------------------------------------------------");

                    for (int B = 0; B <= 1; ) {
                        jugadores.añadir(i, Baraja.Random(), false);
                        if (x == 0) {
                            x++;
                            System.out.println("        " + jugadores.getCartaJugador(i, (0)).toString());
                            do {
                                System.out.print("Cuanto dinero deseas apostar (Si desea añadir centimos pon  el numero con , ): ");
                                apuesta = teclado.nextFloat();
                                jugadores.setApuesta(i, apuesta);
                                if (apuesta <= 0 || jugadores.getDineroJugador(i) < apuesta) {
                                    System.out.println("Porfavor introducta una catindad que tenga y mayor que 0");
                                }
                            } while (apuesta <= 0 || jugadores.getDineroJugador(i) < apuesta);
                        } else {
                            x++;
                            System.out.println("        " + jugadores.getCartaJugador(i, (x - 1)).toString());
                        }
                        if (jugadores.getPuntosJugador(i) < 7.5f) {
                            do {
                                System.out.print("¿Deseas ocultar esta carta (s/n)?: ");
                                opcion = teclado.next().charAt(0);
                                opcion = Character.toUpperCase(opcion);
                                if (opcion != 'S' && opcion != 'N') {
                                    System.out.println("Porfavor introduzca s/n");
                                }
                            } while (opcion != 'S' && opcion != 'N');
                            if (opcion == 'S') {
                                if (x == 1) {
                                    jugadores.setOcultas(i, 0, true);
                                } else {
                                    for (int Q = 0; Q < jugadores.getNumCartasJugador(i); Q++) {
                                        jugadores.setOcultas(i, Q, false);
                                    }
                                    jugadores.setOcultas(i, (x - 1), true);
                                }
                            } else {
                                jugadores.setOcultas(i, (x - 1), false);
                            }
                            System.out.println("Tu puntuación a la vista es " + jugadores.getPuntosVisibleJugador(i));
                            do {
                                System.out.print("Tu puntuación es " + jugadores.getPuntosJugador(i) + " ¿Te plantas (s/n)?: ");
                                opcion = teclado.next().charAt(0);
                                opcion = Character.toUpperCase(opcion);
                                if (opcion != 'S' && opcion != 'N') {
                                    System.out.println("Porfavor introduzca s/n");
                                }
                            } while (opcion != 'S' && opcion != 'N');
                            if (opcion == 'S') {
                                System.out.println("Tu puntuación obtenida es " + jugadores.getPuntosJugador(i));
                                B = 2;
                                System.out.println("Pulse enter para pasar al siguiente jugador");
                                teclado.nextLine();
                                String wait = teclado.nextLine();
                                limpiar();
                            }
                        } else if (jugadores.getPuntosJugador(i) < 7.5f) {
                            System.out.println("Has conseguido una puntuación de 7.5");
                            System.out.println("Porfavor, espere a que terminen los demas jugadores.");
                            B = 2;
                            System.out.println("Pulse enter para pasar al siguiente jugador");
                            teclado.nextLine();
                            String wait = teclado.nextLine();
                            limpiar();
                        } else {
                            System.out.println("Vaya a perdido, se paso de 7.5");
                            System.out.println("Porfavor, espere a que terminen los demas jugadores.");
                            B = 2;
                            System.out.println("Pulse enter para pasar al siguiente jugador");
                            teclado.nextLine();
                            String wait = teclado.nextLine();
                            limpiar();
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("\nJuega la banca:");
            System.out.println("-----------------------------------------------------------");
            x = 0;
            for (int B = 0; B <= 1; ) {
                jugadores.añadir(banca, Baraja.Random(), false);
                System.out.println("        " + jugadores.getCartaJugador(banca, x).toString());
                x++;
                if (jugadores.getPuntosJugador(banca) < 7.5f) {
                    int apuesta_favor = 0;
                    int apuesta_contra = 0;
                    for (int i = 0; i < jugadores.getJugadores(); i++) {
                        if ((jugadores.getPuntosVisibleJugador(i) < 6 && jugadores.getPuntosJugador(banca) >= 6) || (jugadores.getPuntosVisibleJugador(i) >= 6 && jugadores.getPuntosJugador(banca) >= (jugadores.getPuntosVisibleJugador(i) + 0.5f))) {
                            apuesta_contra++;
                        } else {
                            apuesta_favor++;
                        }
                    }
                    if (apuesta_favor < apuesta_contra) {
                        System.out.println("\n-----------------------------------------------------------");
                        System.out.println("Resultados: \n");
                        for (int i = 0; i < jugadores.getJugadores(); i++) {
                            if(jugadores.getDineroJugador(i)!=0) {
                                if (jugadores.getPuntosJugador(i) <= 7.5f) {
                                    if (jugadores.getPuntosJugador(i) > jugadores.getPuntosJugador(banca)) {
                                        jugadores.añadirDineroJugador(i, jugadores.getApuesta(i));
                                        System.out.println("El jugador " + (i + 1) + " - Gana a la banca");
                                        System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                                    } else {
                                        jugadores.quitarDineroJugador(i, jugadores.getApuesta(i));
                                        System.out.println("El jugador " + (i + 1) + " - Pierde contra la banca");
                                        if (jugadores.getDineroJugador(i) != 0) {
                                            System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                                        } else {
                                            System.out.println("    Ohhh no, te has arruinado.");
                                        }
                                    }
                                } else {
                                    jugadores.quitarDineroJugador(i, jugadores.getApuesta(i));
                                    System.out.println("El jugador " + (i + 1) + " - Pierde, se paso de 7,5");
                                    if (jugadores.getDineroJugador(i) != 0) {
                                        System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                                    } else {
                                        System.out.println("    Ohhh no, te has arruinado.");
                                    }
                                }
                            }else{
                                System.out.println("El jugador " + (i + 1) + " - Esta arruinado");
                            }
                        }
                        do {
                            System.out.print("¿Desean seguir jugando (s/n)?: ");
                            opcion = teclado.next().charAt(0);
                            opcion = Character.toUpperCase(opcion);
                            if (opcion != 'S' && opcion != 'N') {
                                System.out.print("Porfavor introduzca s/n");
                            }
                        } while (opcion != 'S' && opcion != 'N');
                        if (opcion == 'S') {
                            B = 2;
                        } else {
                            System.exit(0);
                        }
                    }
                } else if (jugadores.getPuntosJugador(banca) == 7.5f) {
                    System.out.println("------------------------------");
                    System.out.println("--       La banca gana      --");
                    System.out.println("--       Consiguio 7.5      --");
                    System.out.println("--        Han perdido       --");
                    System.out.println("------------------------------");
                    for (int i = 0; i < jugadores.getJugadores(); i++) {
                        if(jugadores.getDineroJugador(i)!=0) {
                            jugadores.quitarDineroJugador(i, jugadores.getApuesta(i));
                            System.out.println("El jugador " + (i + 1) + " - Pierde contra la banca");
                            if (jugadores.getDineroJugador(i) != 0) {
                                System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                            } else {
                                System.out.println("    Ohhh no, te has arruinado.");
                            }
                        }else{
                            System.out.println("El jugador " + (i + 1) + " - Esta arruinado");
                        }
                    }
                    do {
                        System.out.print("¿Desean seguir jugando (s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'S') {
                        B = 2;
                    } else {
                        System.exit(0);
                    }
                } else {
                    System.out.println("------------------------------");
                    System.out.println("--      La banca pierde     --");
                    System.out.println("--      Se paso de 7.5      --");
                    System.out.println("--         Han ganado       --");
                    System.out.println("------------------------------");
                    for (int i = 0; i < jugadores.getJugadores(); i++) {
                        if(jugadores.getDineroJugador(i)!=0) {
                            if (jugadores.getApuesta(i) > 7.5f) {
                                jugadores.añadirDineroJugador(i, jugadores.getApuesta(i));
                                System.out.println("El jugador " + (i + 1) + " - Gana a la banca");
                                System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                            } else {
                                jugadores.quitarDineroJugador(i, jugadores.getApuesta(i));
                                System.out.println("El jugador " + (i + 1) + " - Pierde, se paso de 7,5");
                                if (jugadores.getDineroJugador(i) != 0) {
                                    System.out.println("    Tiene " + jugadores.getDineroJugador(i) + "€");
                                } else {
                                    System.out.println("    Ohhh no, te has arruinado.");
                                }
                            }
                        }else{
                            System.out.println("El jugador " + (i + 1) + " - Esta arruinado");
                        }
                    }
                    do {
                        System.out.print("¿Desean seguir jugando (s/n)?: ");
                        opcion = teclado.next().charAt(0);
                        opcion = Character.toUpperCase(opcion);
                        if (opcion != 'S' && opcion != 'N') {
                            System.out.print("Porfavor introduzca s/n");
                        }
                    } while (opcion != 'S' && opcion != 'N');
                    if (opcion == 'S') {
                        B = 2;
                    } else {
                        System.exit(0);
                    }
                }
            }
            x = 0;
            Baraja = new Baraja();
            jugadores.quitarCartas();
            limpiar();
        }
    }

    public static void limpiar() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }
}
