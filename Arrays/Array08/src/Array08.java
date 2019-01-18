//Francisco Jes�s Gonz�lez Fern�ndez

import java.util.*;

public class Array08 {

	public static void main(String[] args) {
		int num = 1;
		int[] numeros = {0,0,0,0,0};
		int[] numeros2 = new int[5];
		int suma = 0;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Teclee un n� del 1 al 5 (0=FIN): ");
			num = teclado.nextInt();
			
			if(num!=0) {
				if(num>=1 && num<=5) {
					numeros[(num-1)]++;
				}else {
					System.out.println("Error, n�mero fuera del intervalo permitido");
				}
			}
		}while(num!=0);
		
		System.out.println("Frecuencia de los n�meros tecleados:");
		for(int i=0;i<numeros.length;i++) {
			System.out.printf("%-3d %-3d \n", i+1, numeros[i]);
		}
		
		for(int i=0;i<numeros.length;i++) {
			suma=suma+numeros[i];
		}
		System.out.println("Total de n�meros telceados " + suma);
		
		numeros2=Arrays.copyOf(numeros, numeros.length);
		Arrays.sort(numeros);
		System.out.println("Los n�meros m�s repetidos lo han sido " + numeros[4] + " veces y son los n�meros: ");
		for(int i=0;i<numeros.length;i++) {
			if(numeros2[i]==numeros[4]) {
				System.out.println(i+1);
			}
		}
		teclado.close();
	}

}
