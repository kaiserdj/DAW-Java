//Francisco jesús González Fernández

import java.util.Scanner;

public class Array02_v1 {

	public static void main(String[] args) {
		int num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
		float media;
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Escriba el numero 1: ");
		num1 = teclado.nextInt();
		System.out.print("Escriba el numero 2: ");
		num2 = teclado.nextInt();
		System.out.print("Escriba el numero 3: ");
		num3 = teclado.nextInt();
		System.out.print("Escriba el numero 4: ");
		num4 = teclado.nextInt();
		System.out.print("Escriba el numero 5: ");
		num5 = teclado.nextInt();
		System.out.print("Escriba el numero 6: ");
		num6 = teclado.nextInt();
		System.out.print("Escriba el numero 7: ");
		num7 = teclado.nextInt();
		System.out.print("Escriba el numero 8: ");
		num8 = teclado.nextInt();
		System.out.print("Escriba el numero 9: ");
		num9 = teclado.nextInt();
		System.out.print("Escriba el numero 10: ");
		num10 = teclado.nextInt();
		
		teclado.close();
		
		media =(num1+num2+num3+num4+num5+num6+num7+num8+num9+num10)/10;
		System.out.println("La media es: " + media);
		
		System.out.print("Los numeros mayores a la media son: ");
		if(num1>media) {
			System.out.print(num1 + " ");
		}
		if(num2>media) {
			System.out.print(num2 + " ");
		}
		if(num3>media) {
			System.out.print(num3 + " ");
		}
		if(num4>media) {
			System.out.print(num4 + " ");
		}
		if(num5>media) {
			System.out.print(num5 + " ");
		}
		if(num6>media) {
			System.out.print(num6 + " ");
		}
		if(num7>media) {
			System.out.print(num7 + " ");
		}
		if(num8>media) {
			System.out.print(num8 + " ");
		}
		if(num9>media) {
			System.out.print(num9 + " ");
		}
		if(num10>media) {
			System.out.print(num10 + " ");
		}
	}

}
