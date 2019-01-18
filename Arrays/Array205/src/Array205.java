//Francisco Jesús González Fernández

import java.util.*;

public class Array205 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int sesiones, participantes;
		char asis;
		
		System.out.println("Datos del congreso");
		System.out.println("------------------------");
		System.out.print("¿Nº de sesiones?: ");
		sesiones = teclado.nextInt();
		System.out.print("¿Nº de participantes?: ");
		participantes = teclado.nextInt();
		teclado.nextLine();
		
		String[] asistentes = new String[participantes];
		boolean[][] faltas = new boolean[sesiones][participantes];
		int[] cont = new int[participantes];
		
		System.out.println("Introducir nombre de los participantes");
		System.out.println("----------------------------------------");
		for(int i=0;i<asistentes.length;i++) {
			System.out.println("Participante (" + (i+1) + "):");
			System.out.print("	Nombre: ");
			asistentes[i] = teclado.nextLine();
		}
		System.out.println("Pasar lista en cada sesión");
		System.out.println("--------------------------");
		for(int i=0;i<faltas.length;i++) {
			System.out.println("Sesión nº: " + (i+1));
			for(int x=0;x<faltas[0].length;x++) {
				System.out.print("¿" + asistentes[x] + "? (F=falta, A=asiste): ");
				asis = teclado.next().charAt(0);
				asis = Character.toUpperCase(asis);
				while(asis!='F' && asis!='A'){
					System.out.println("Error, porfavor introduzca F o A.");
					System.out.print("¿" + asistentes[x] + "? (F=falta, A=asiste): ");
					asis = teclado.next().charAt(0);
					asis = Character.toUpperCase(asis);
				}
				if(asis=='F') {
					faltas[i][x] = true;
				}else {
					faltas[i][x] = false;
				}
			}
		}
		System.out.println("Listado de faltas del curso");
		System.out.println("---------------------------");
		System.out.printf("%-19s", "NOMBRE");
		for(int i=0;i<sesiones;i++) {
			System.out.printf("%-10s", "SESION" + (i+1));
		}
		System.out.print("\n");
		for(int i=0;i<asistentes.length;i++) {
			System.out.printf("%-19s", asistentes[i]);
			for(int x=0;x<faltas.length;x++) {
				if(faltas[x][i] == false) {
					System.out.printf("%-10s", "   A");	
				}else {
					System.out.printf("%-10s", "   F");	
					cont[i]++;
				}		
			}
			System.out.print("\n");
		}
		System.out.println("Resumen de asistencia de los participantes");
		System.out.println("------------------------------------------");
		for(int i=0;i<asistentes.length;i++) {
			System.out.println(asistentes[i]);
			if(cont[i]!=0) {
				System.out.print("Faltas: ");
				for(int x=0;x<faltas.length;x++) {
					if(faltas[x][i] != false) {
						System.out.printf("%-5s", " dia " + (x+1));	
					}	
				}
				System.out.print("\n");
			}
			System.out.println("Nº de faltas: "+cont[i]+" Porcentaje de asisitencia= " + ((sesiones-cont[i])*100)/sesiones +"%");
		}
		teclado.close();
	}

}
