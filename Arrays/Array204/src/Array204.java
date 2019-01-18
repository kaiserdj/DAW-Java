//Francisco Jesús González Fernández

import java.util.*;

public class Array204 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int[][] tabla = new int[12][31];
		int mes = 0;
		int dia = 0;
		char x = 'x';
		int persona = 1;
		
		for(int i=0;i<12;i++) {
			if(i==1||i==3||i==5||i==8||i==10) {
				tabla[i][30]=-1;
				if(i==1) {
					tabla[i][29]=-1;
				}
			}
		}
		
		do {
			System.out.println("Introduce datos de las personas:");
			System.out.println("Introduce datos de las persona " + persona + ": ");persona++;
			
			mes = leerMes();
			dia = leerDia(mes,tabla);
			tabla[mes][dia]++;
			
			System.out.print("¿Desea introducir otra persona? S/N: ");
			x = teclado.next().charAt(0);
			x = Character.toUpperCase(x);
			while(x!='S' && x!='N'){
				System.out.print("Porfavor pon S/N: ");
				x = teclado.next().charAt(0);
				x = Character.toUpperCase(x);
			}
			System.out.print("\n");
		}while(x!='N');
		
		teclado.close();
	}

	public static int leerMes() {
		Scanner teclado = new Scanner(System.in);
		int mes = 0;
		
		do {
			System.out.print("Introduce un mes entre 1-12: ");
			mes = teclado.nextInt();
			teclado.nextLine();
		}while(mes>12||mes<1);
		teclado.close();
		return mes-1;
	}
	
	public static int leerDia(int mes, int[][] fechas) {
		Scanner teclado = new Scanner(System.in);
		int dia = 0;
		
		System.out.print("Introduce un día: ");
		dia = teclado.nextInt();
			switch (mes) {
			case 2:
				while(dia>29&&dia<1){
					System.out.print("Introduce un día entre 1-29: ");
					dia = teclado.nextInt();
				};
				teclado.nextLine();
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				while(dia>30&&dia<1){
					System.out.print("Introduce un día entre 1-30: ");
					dia = teclado.nextInt();
				};
				teclado.nextLine();
				break;
			default:
				while(dia>31&&dia<1){
					System.out.print("Introduce un día entre 1-31: ");
					dia = teclado.nextInt();
				};
				teclado.nextLine();
				break;
			}
		teclado.close();
		return dia-1;
	}
}
