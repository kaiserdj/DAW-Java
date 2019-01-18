//Francisco Jesús González Fernández

import java.util.Scanner;

public class Array01 {

	public static void main(String[] args) {
		int array1[] = {0,1,2,3,4,5,6,7,8,9};
		int[] array2 = new int[10];
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce los valores que quieras guardar en el array: \n");
		for(int i=0;i<array2.length;i++) {
			System.out.print((i+1)+"º: ");
			array2[i]=teclado.nextInt();
		}
		teclado.close();
			
		System.out.println("\nEste es el array1: ");
		for (int num : array1){
			if(!(num==9)) {
				System.out.print(num + ", ");
			}else {
				System.out.print(num);
			}			
		}
		System.out.println("\nEste es el array2:");
		for (int num : array2){
			if(!(num==9)) {
				System.out.print(num + ", ");
			}else {
				System.out.print(num);
			}			
		}
	}

}
