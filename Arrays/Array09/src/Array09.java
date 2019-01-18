//Francisco Jesús González Fernández

import java.util.Scanner;

public class Array09 {

	public static void main(String[] args) {
		int num = 1;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Teclee un nº de lanzamientos (0=FIN): ");
			num = teclado.nextInt();
			
			if(num!=0) {			
				System.out.printf("%5s %5s \n", "Lanz.", "Dado");
				int[] dado = lanzamientos(num);
				verPorcentajes(dado);
			}
		}while(num!=0);
		teclado.close();
	}
	
	public static int[] lanzamientos(int nLanz) {
		int[] dado = new int[6];
		
		for(int i=1;i<=nLanz;i++) {
			int random = (int)((Math.random()*6));
			dado[random]++;
			System.out.printf("%5d %5d \n", i, random+1);
		}
		return dado;
	}
	
	public static void verPorcentajes(int[] frecuencias) {
		float[] dados = new float[6];
		int suma = 0;
		
		for (int i = 0; i < frecuencias.length; i++) {
			suma = suma + frecuencias[i];
		}
		
		for (int i = 0; i < dados.length; i++) {
			dados[i] = (float) frecuencias[i] / suma * 100;
			dados[i] = Math.round(frecuencias[i] * 100) / 10F;
		}
		
		System.out.println("Porcentajes");
		for(int i=0;i<dados.length;i++) {
			System.out.printf("%-3d %.1f%% \n", i+1, dados[i]);					
		}
	}

}
