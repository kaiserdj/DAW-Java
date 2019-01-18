//Francisco Jesús González Fernández

import java.util.*;

public class Corredores {

	// atributos
	private String[] names;
	private int[] years;
	
	// contructor
	public Corredores(int lenght) {
		this.names = new String[lenght];
		this.years = new int[lenght];
	}
	
	public void introducir(String name, int year) {
		int x = 0;
		for(int i=0;i<names.length && x != 1;i++) {
			if(names[i] == null) {
				names[i] = name;
				years[i] = year;
				x = 1;
			}
		}
	}
	
	public int mayorEdad() {
		int[] check = years.clone();
		int mayoryear = 0;
		
		Arrays.sort(check);
		mayoryear = check[check.length-1];
		
		return mayoryear;
	}
	
	public int[] positionMayorEdad() {
		int checkPositions = 0;
		int mayoryear = mayorEdad();
		
		for(int i=0;i<years.length;i++) {
			if(years[i]==mayoryear) {
				checkPositions++;
			}
		}
		
		int[] Positions = new int[checkPositions];
		int PositionPos = 0;
		for(int i=0;i<years.length;i++) {
			if(years[i]==mayoryear) {
				Positions[PositionPos] = i;
				PositionPos++;
			}
		}
		
		return Positions;
	}
	
	public String[] listMayorEdad() {
		int[] Positions = positionMayorEdad();
		
		String[] mayorEdad = new String[Positions.length*2];
		int x=0;
		for(int i=0;i<Positions.length;i++) {
			mayorEdad[x]=names[Positions[i]];
			x++;
			mayorEdad[x]=Integer.toString(years[Positions[i]]);
			x++;	
		}
		return mayorEdad;
	}
	
	public String getName(int dorsal) {
		return names[dorsal];
	}
	
	public int getYear(int dorsal) {
		return years[dorsal];
	}

	public String[] getNames() {
		return names;
	}
	
	public int[] getYears( ) {
		return years;
	}
}
