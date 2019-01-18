//Francisco Jesús González Fernández

import java.util.*;

public class Array04 {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce 10 numeros");
		
		for(int i=0;i<numeros.length;i++) {
			System.out.print((i+1)+"º: ");
			numeros[i]=teclado.nextInt();
		}
		teclado.close();
		
		for(int i=0;i<numeros.length;i++) {
			System.out.print(numeros[i] + " ");
		}
		
		System.out.print("\n");
		
		for(int i=(numeros.length-1);i>0;i--) {
			System.out.print(numeros[i] + " ");
		}
	}

}
