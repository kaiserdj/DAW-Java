//Francisco Jesús González Fernández

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hoy {

	public static void main(String[] args) {
		Calendar hoy = Calendar.getInstance();
		GregorianCalendar hoy2 = new GregorianCalendar();

		System.out.println("Con Calendar: " + hoy.getTime());
		System.out.print("Con GregorianCalendar: " + hoy2.getTime());
	}
}
