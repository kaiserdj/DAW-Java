//Francisco Jesús González Fernández

public class Nif {

	//Atributos
	private int DNI;
	private char letra;

	//Constructor
	public Nif(int DNI, char letra) {
		this.DNI = DNI;
		this.letra = letra;
	}

	@Override
	public String toString() {
		return DNI + Character.toString(letra);
	}
}