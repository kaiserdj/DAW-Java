//Francisco Jesús González Fernández

import java.util.*;

public class Programa {

	public static void main(String[] args) {
		Alumno[] clase = new Alumno[3];
		Scanner teclado = new Scanner(System.in);
		String nombre;
		int nif, length, dia, mes, año;
		char letra ;
		GregorianCalendar fecha = new GregorianCalendar();

		for(int i=0;i<3;i++){
			System.out.println("Alumno " + (i+1));
			do{
				System.out.print("Introduce el NIF: ");
				nif = teclado.nextInt();
				length = String.valueOf(nif).length();

				System.out.print("Introduce la letra: ");
				teclado.nextLine();
				letra = teclado.next().charAt(0);
				letra = Character.toUpperCase(letra);
				if(letra!=Nif.GenLetra(nif)){
					System.out.println("Por favor compruebe su NIF y letra.");
				}
			}while(length!=8 && letra!=Nif.GenLetra(nif));
			Nif NIF = new Nif(nif, letra);

			System.out.print("Introduce el nombre: ");
			teclado.nextLine();
			nombre = teclado.nextLine();

			System.out.println("Introduce la fecha de nacimiento");
			do{
				System.out.print("	Dia: ");
				dia = teclado.nextInt();
			}while(dia<1||dia>31);
			do{
				System.out.print("	Mes: ");
				mes = teclado.nextInt();
			}while(mes<1||mes>12);
			do{
				System.out.print("	Año: ");
				año = teclado.nextInt();
			}while(año<0);

			fecha = new GregorianCalendar(año, (mes - 1), dia);

			clase[i] = new Alumno(NIF, nombre, fecha);
			System.out.print("\n");
		}

		System.out.println("Tabla de alumnos:");
		System.out.printf("%-10s %-20s %-14s \n", "NIF", "Nombre", "Fecha de nac");
		for(int i=0;i<3;i++){
			System.out.printf("%-10s %-20s %-8s \n", clase[i].getDni(), clase[i].getNombre(), clase[i].getFecha());
		}

		teclado.close();
	}

}