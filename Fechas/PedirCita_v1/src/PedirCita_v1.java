import java.util.GregorianCalendar;
import java.util.Scanner;

public class PedirCita_v1 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int dia, mes, a�o, check = 0;
		GregorianCalendar fecha = new GregorianCalendar();
		GregorianCalendar hoy = new GregorianCalendar();

		do{
			System.out.print("�Dia?: ");
			dia = teclado.nextInt();
			System.out.print("�Mes?: ");
			mes = teclado.nextInt();
			System.out.print("�A�o?: ");
			a�o = teclado.nextInt();

			fecha.set(a�o,(mes - 1),dia);

			if(fecha.before(hoy)){
				System.out.println("Error: La fecha introducida es anterior a la fecha actual.");
			}else if(fecha.get(fecha.DAY_OF_WEEK)==1 || fecha.get(fecha.DAY_OF_WEEK)==7){
				System.out.println("Los s�bados y domingos no podemos atenderle");
			}else{
				System.out.println("Su cita para el d�a " + fecha.get(fecha.DAY_OF_MONTH) + "/" + fecha.get(fecha.MONTH) + "/" + fecha.get(fecha.YEAR) + " ha sido aceptada");
				check++;
			}
		}while(check == 0);
	}

}
