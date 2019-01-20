//Francisco Jesús González Fernández

import java.util.*;

public class Alumno {

	//Atributo
	private Nif nif;
	private String nombre;
	private GregorianCalendar fecha_nac;

	public Alumno(Nif nif, String nombre, GregorianCalendar fecha_nac) {
		this.nif = nif;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
	}

	public String getDni(){
		return nif.toString();
	}

	public String getNombre(){
		return nombre;
	}

	public String getFecha(){
		return  fecha_nac.get(fecha_nac.DAY_OF_MONTH) + "/" + (fecha_nac.get(fecha_nac.MONTH) + 1) + "/" + fecha_nac.get(fecha_nac.YEAR);
	}
}
