//Francisco Jesús González Fernández

import java.util.*;

public class Array12_POO {

	public static void main(String[] args) {
		String nombre = "A";
		int edad = 0;
		int x = 0;
		Corredores corredores = new Corredores(100);
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("INSCRIPCIÓN\n");
		for(int i=0;!(nombre.equals("0"));i++) {			
			System.out.println("Corredor " + (i+1) + ":");
			System.out.print("	¿Nombre (*=FIN)?: ");
			nombre = teclado.next();
			if(!(nombre.equals("0"))) {
				System.out.print("	¿edad?: ");
				edad = teclado.nextInt();
				corredores.introducir(nombre, edad);
			}
		}
		
		do {
			System.out.println("\nCONSULTAS\n");
			System.out.println("1. Visualizar corredores\n");
			System.out.println("2. Nombre corredor de mayor edad\n");
			System.out.println("3. Salir\n");
			System.out.print("Introduce un numero (1-3): ");
			x = teclado.nextInt();
			switch (x) {
			
			case 1:
				String[] names = corredores.getNames();
				int[] years = corredores.getYears();
				
				System.out.println("\nLista de corredores: ");
				System.out.printf("%-15s %-5s \n", "Nombre", "Edad");
				for(int i=0;i<names.length;i++) {
					if(names[i]==null) {
						break;
					}
					System.out.printf("%-15s %-5s \n", names[i], years[i]);
				}
				
				break;
				
			case 2:
				String[] mayor = corredores.listMayorEdad();
				
				System.out.println("\nCorredores con mayor edad: ");
				System.out.printf("%-15s %-5s \n", "Nombre", "Edad");
				for(int i=0;i<mayor.length;i++) {
					System.out.printf("%-15s %-5s \n", mayor[i], mayor[i+1]);
					i++;
				}
				
				break;
			}
		}while(x!=3);
		
		teclado.close();
	}

}
