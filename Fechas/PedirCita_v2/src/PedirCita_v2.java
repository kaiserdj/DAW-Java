//Francisco Jesús González Fernández

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PedirCita_v2 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int dia, mes, año, hora, min, check = 0;
		GregorianCalendar fecha = new GregorianCalendar();
		GregorianCalendar hoy = new GregorianCalendar();

		do{
			System.out.print("¿Dia?: ");
			dia = teclado.nextInt();
			System.out.print("¿Mes?: ");
			mes = teclado.nextInt();
			System.out.print("¿Año?: ");
			año = teclado.nextInt();

			fecha.set(año,(mes - 1),dia);

			if(fecha.before(hoy)){
				System.out.println("Error: La fecha introducida es anterior a la fecha actual.");
			}else if(fecha.get(fecha.DAY_OF_WEEK)==1 || fecha.get(fecha.DAY_OF_WEEK)==7){
				System.out.println("Los sábados y domingos no podemos atenderle");
			}else{
				check++;
			}
		}while(check == 0);

		do{
			System.out.print("¿Hora (de 9 a 13)?: ");
			hora = teclado.nextInt();
			System.out.print("¿Minutos (0 ó 30)?: ");
			min = teclado.nextInt();

			fecha.set(fecha.HOUR, hora);
			fecha.set(fecha.MINUTE, min);

			if(hora<9 || hora>13){
				System.out.println("Error: La hora no entra dentro del rango 9-13");
			}else if(!(min==0 || min==30)){
				System.out.println("Error: Los minutos tienen que ser 0 ó 30");
			}else{
				System.out.println("Su cita para el día " + fecha.get(fecha.DAY_OF_MONTH) + "/" + fecha.get(fecha.MONTH) + "/" + fecha.get(fecha.YEAR) + " y hora " + fecha.get(fecha.HOUR) + ":" + fecha.get(fecha.MINUTE) + "ha sido aceptada");
				check++;
			}
		}while(check == 1);

		teclado.close();
		
	}

}
