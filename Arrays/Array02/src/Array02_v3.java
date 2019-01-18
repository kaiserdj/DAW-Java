//Francisco Jesús González Fernández

public class Array02_v3 {

	public static void main(String[] args) {
		int numeros[] = {345,3,2,54,1234,321,6,7,8,6};
		int media = 0;
		
		for(int i=0;i<numeros.length;i++) {
			media = media + numeros[i];
		}
		media=media/numeros.length;
		System.out.println("La media es: " + media);
		
		System.out.print("Los numeros mayores a la media son: ");
		for(int i=0;i<numeros.length;i++) {
			if(numeros[i]>media) {
				System.out.print(numeros[i]+ " ");
			}
		}
	}

}
