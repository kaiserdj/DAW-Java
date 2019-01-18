//Francisco Jesús González Fernández

import java.util.*;

public class Array07 {

	public static void main(String[] args) {
		String nombre = null;
		int[] notas = new int[5];
		double media = 0;
		int suspensas = 0;
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.print("Nombre y apellids (*=FIN): ");
			nombre = teclado.next();
			if(nombre.charAt(0)!='*') {
				for(int i=0;i<notas.length;i++) {
					System.out.print("Asignatura nº"+(i+1)+". Nota: ");
					notas[i] = teclado.nextInt();
				}
				
				for(int i=0;i<notas.length;i++) {
					media = media + notas[i];
				}
				media = media/notas.length;
				media = MisMetodos.redondeo(media, 2);
				
				System.out.println("La nota media es= " + media);
				
				for(int i=0;i<notas.length;i++) {
					if(notas[i]<5) {
						suspensas++;
					}
				}
				
				if(suspensas<=2) {
					System.out.println("El alumno " + nombre + " PROMOCIONA");
					for(int i=0;i<notas.length;i++) {
						System.out.println("Asignatura nº"+(i+1)+". Nota: " + notas[i]);
					}
				}else {
					System.out.println("El alumno " + nombre + " NO PROMOCIONA");
					for(int i=0;i<notas.length;i++) {
						if(notas[i]<5) {
							System.out.println("Asignatura nº"+(i+1)+". Nota: " + notas[i]);
						}
					}
				}
				
			}
		}while(nombre.charAt(0)!='*');
		teclado.close();
	}

}
