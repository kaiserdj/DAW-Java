//Francisco Jesús González Fernández

import java.util.*;

public class Array05 {

	public static void main(String[] args) {
		int[] numeros = new int[8];
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce 8 numeros reales:");
		for(int i=0;i<numeros.length;i++) {
			System.out.print((i+1)+": ");
			numeros[i]=teclado.nextInt();
		}
		teclado.close();
		
		System.out.printf("%-10s %-10s \n","Numero","raiz");
		
		for(int i=0;i<numeros.length;i++) {
			if(numeros[i]<0) {
				System.out.printf("%-10d %-10s \n", numeros[i], "NO EXISTE");
			}else {
				System.out.printf("%-10d %-10f \n", numeros[i], Math.sqrt((float)numeros[i]));
			}
		}
	}

}
