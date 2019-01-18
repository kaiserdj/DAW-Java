//Francisco Jesús González Fernández

public class Array202 {

	public static void main(String[] args) {
		int[][] tabla = {{10, 11, 12, 13}, {20, 21, 22, 23}, {30, 31, 32, 33}};
		
		for(int i=0;i<tabla.length;i++) {
			for(int x=0;x<tabla[0].length;x++) {
				System.out.printf("%3d", tabla[i][x]);
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		
		for(int i=0;i<tabla[0].length;i++) {
			for(int x=0;x<tabla.length;x++) {
				System.out.printf("%3d", tabla[x][i]);
			}
			System.out.print("\n");
		}
	}

}
