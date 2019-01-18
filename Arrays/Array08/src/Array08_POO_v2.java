//Francisco Jesús González Fernández

import java.util.*;

public class Array08_POO_v2 {

	public static void main(String[] args) {
		int num = 1;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Teclee un nº de lanzamientos (0=FIN): ");
			num = teclado.nextInt();
			
			if(num!=0) {
				ArrayContador dado = new ArrayContador(6);
				
				System.out.printf("%5s %5s \n", "Lanz.", "Dado");
				for(int i=1;i<=num;i++) {
					int random = (int)((Math.random()*6));
					dado.contar(random);
					System.out.printf("%5d %5d \n", i, random+1);
				}
				
				float[] dados = dado.getPorcentajes();
				System.out.println("Porcentajes");
				for(int i=0;i<dados.length;i++) {
					System.out.printf("%-3d %.1f%% \n", i+1, dados[i]);					
				}
			}
		}while(num!=0);
		teclado.close();
	}

}
