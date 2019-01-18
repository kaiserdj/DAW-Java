//Francisco Jesús González Fernández

import java.util.*;

public class Array06 {

	public static void main(String[] args) {
		int[] notas = new int[7];
		int alumno = 1;
		float media = 0;
		int aprovados = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce las notas de los alumnos");
		
		for(int i=0;i<notas.length;i++) {
			System.out.print("Alumno " + (i+1) + ": ");
			notas[i]=teclado.nextInt();			
		}
		
		for(int i=0;i<notas.length;i++) {
			media = media + notas[i];
		}
		media = media/notas.length;
		
		for(int i=0;i<notas.length;i++) {
			if(notas[i]>5) {
				aprovados++;
			}
		}
		
		System.out.println("ESTADISTICA");
		System.out.println("Nota media = " + media);
		System.out.println("Nº de alumnos aprobados: " + aprovados);
		
		do {
			System.out.print("Teclee el nº del alumno (0 para finalizar): ");
			alumno = teclado.nextInt();
			if(alumno!=0) {
				System.out.print("El alumno " + alumno + ", tubo un " + notas[alumno-1] + ". ");
				if(notas[alumno-1] > media) {
					System.out.print("Esta por encima de la media.");
				}else {
					System.out.print("Esta por debajo de la media.");
				}
				System.out.print("\n");
			}
		}while(alumno!=0);
		teclado.close();
	}
}