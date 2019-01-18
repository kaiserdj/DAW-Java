//Francisco Jesús González Fernández

public class Array203 {

	public static void main(String[] args) {
		int[][] tabla = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int suma = 0;
		int d = 0;
		int sumad = 0;
		
		for(int i=0;i<tabla.length;i++) {
			for(int x=0;x<tabla[0].length;x++) {
				System.out.printf("%3d", tabla[i][x]);
				suma = suma + tabla[i][x];
			}
			System.out.println("-->  " + suma);
			sumad = sumad + tabla[i][d];
			d++;
			suma = 0;
		}
		System.out.print("La suma de la diagonal es " + sumad);
	}

}
