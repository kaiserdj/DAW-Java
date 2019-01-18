//Francisco Jesús González Fernández

import java.util.Scanner;

public class Array02_v2 {

	public static void main(String[] args) {
		int[] numeros = new int[10];
		int media = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce los valores que quieras guardar en el array: \n");
		for(int i=0;i<numeros.length;i++) {
			System.out.print((i+1)+"º: ");
			numeros[i]=teclado.nextInt();
		}
		teclado.close();
		
		for(int i=0;i<numeros.length;i++) {
			media = media + numeros[i];
		}
		media=media/numeros.length;
		System.out.println("La media es: " + media);
		
		System.out.print("Los numeros mayores a la media son: ");
		for(int i=0;i<numeros.length;i++) {
			if(numeros[i]>media) {
				System.out.print(numeros[i]+ " ");
			}
		}
	}

}
