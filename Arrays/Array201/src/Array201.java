//Francisco Jesús González Fernández

import java.util.*;

public class Array201 {

	public static void main(String[] args) {
		int[][] tabla = new int[3][4];
		int suma = 0;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Carga tabla");
		System.out.println("-----------");
		for(int i=0;i<tabla.length;i++) {
			System.out.println("fila: " + i);
			for(int x=0;x<tabla[0].length;x++) {
				System.out.print("m[" + i + "][" + x + "]: ");
				tabla[i][x]=teclado.nextInt();
			}
		}
		
		System.out.println("Tabla");
		System.out.println("-----------");
		for(int i=0;i<tabla.length;i++) {
			for(int x=0;x<tabla[0].length;x++) {
				System.out.printf("%3d", tabla[i][x]);
				suma = suma + tabla[i][x];
			}
			System.out.print("\n");
		}
		System.out.print("Suma total= " + suma);	
		
		teclado.close();
	}

}
