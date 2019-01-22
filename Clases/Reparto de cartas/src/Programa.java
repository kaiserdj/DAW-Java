import java.util.Scanner;

public class Programa {
    public static void main(String[] arg){
        Scanner teclado = new Scanner(System.in);
        char let;
        Boolean con8y9;

        System.out.println("Inicializar la Baraja \n");
        do {
            System.out.print("Quieres que la baraja contenga 8 y 9 (S/N): ");
            let = teclado.next().charAt(0);
            if (Character.toUpperCase(let) != 'S' && Character.toUpperCase(let) != 'N') {
                System.out.println("Por favor, introduzca S o N.");
            }
        }while(Character.toUpperCase(let)!='S'&&Character.toUpperCase(let)!='N');

    }
}
