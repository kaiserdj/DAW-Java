//Francisco Jes�s Gonz�lez Fern�ndez

import java.util.*;

public class Array08_POO {

	public static void main(String[] args) {
		int num = 1;
		Scanner teclado = new Scanner(System.in);
		
		ArrayContador numeros = new ArrayContador(5);
		do {
			System.out.print("Teclee un n� del 1 al 5 (0=FIN): ");
			num = teclado.nextInt();
			
			if(num!=0) {
				if(num>=1 && num<=5) {
					numeros.contar(num-1);
				}else {
					System.out.println("Error, n�mero fuera del intervalo permitido");
				}
			}
		}while(num!=0);
		
		System.out.println("Frecuencia de los n�meros tecleados:");
		for(int i=0;i<5;i++) {
			System.out.printf("%-3d %-3d \n", i+1, numeros.getContador(i));
		}
		
		System.out.println("Total de n�meros tecleados " + numeros.getTotal());
		
		System.out.println("Los n�meros m�s repetidos lo han sido " + numeros.maxContador() + " veces y son los n�meros: ");
		
		int[] listaMasRepetidos = numeros.listaMasRepetidos();
		for(int i=0;i<listaMasRepetidos.length;i++) {
			System.out.println(listaMasRepetidos[i]);
		}
		teclado.close();
		
	}
	
}
