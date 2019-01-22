import java.util.Scanner;

public class Programa {
    public static void main(String[] arg){
        Scanner teclado = new Scanner(System.in);
        char let;
        Boolean con8y9;
        int cartas;

        System.out.println("Inicializar la Baraja \n");
        do {
            System.out.print("Quieres que la baraja contenga 8 y 9 (S/N): ");
            let = teclado.next().charAt(0);
            if (Character.toUpperCase(let) != 'S' && Character.toUpperCase(let) != 'N') {
                System.out.println("Por favor, introduzca S o N.");
            }
        }while(Character.toUpperCase(let)!='S'&&Character.toUpperCase(let)!='N');
        if(Character.toUpperCase(let)=='S'){
            con8y9 = true;
            cartas = 48;
        }else{
            con8y9 = false;
            cartas = 40;
        }

        Baraja Baraja = new Baraja(cartas, con8y9);
        Baraja.Generar();

        if(con8y9==true){
            System.out.println("\nBaraja con 8 y 9");
        }else{
            System.out.println("\nBaraja sin 8 y 9");
        }
        System.out.println("----------------\n");
        for(int i=0;i<4;i++){
            System.out.println("Jugador nº" + (i+1));
            System.out.println("-----------");
            if(con8y9==true) {
                for (int x=0;x<12;x++) {
                    System.out.println(Baraja.Random());
                }
            }else {
                for (int x=0;x<10;x++) {
                    System.out.println(Baraja.Random());
                }
            }
            System.out.println("");
        }
        teclado.close();
    }
}
