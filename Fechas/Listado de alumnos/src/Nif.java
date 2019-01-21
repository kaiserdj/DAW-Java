//Francisco Jesús González Fernández

public class Nif {

	//Atributos
	private int DNI;
	private char letra;

	//Constructor
	public Nif(int DNI, char letra) {
		this.DNI = DNI;
		this.letra = GenLetra(DNI);
	}

	public static char GenLetra(int nif){
		int dni = nif%23;
		char[] letra = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		return letra[dni];
	}

	@Override
	public String toString() {
		return DNI + Character.toString(letra);
	}
}