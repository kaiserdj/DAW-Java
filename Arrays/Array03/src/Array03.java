//Francisco Jesús González Fernández

import java.util.*;

public class Array03 {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce los valores que quieras guardar en el array: \n");
		for(int i=0;i<numeros.length;i++) {
			System.out.print((i+1)+"º: ");
			numeros[i]=teclado.nextInt();
		}
		teclado.close();
		
		for(int i=0;i<numeros.length;i++) {
			System.out.print(numeros[i] + " ");
		}
		
		Arrays.sort(numeros);
		
		System.out.print("\n");
		
		for(int i=0;i<numeros.length;i++) {
			System.out.print(numeros[i] + " ");
		}
	}

}
