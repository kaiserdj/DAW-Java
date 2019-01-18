//Francisco Jesús González Fernández

public class ArrayContador {
	// atributos
	private int[] contadores;

	// Constructor
	public ArrayContador(int length) {
		this.contadores = new int[length];
	}

	// métodos
	public int[] getContadores() {
		return contadores;
	}

	public void contar(int indice) {
		contadores[indice]++;
	}

	public int getContador(int indice) {
		return contadores[indice];
	}

	public float[] getPorcentajes() {
		float[] porcentajes = new float[contadores.length];
		for (int i = 0; i < porcentajes.length; i++) {
			porcentajes[i] = (float) contadores[i] / getTotal() * 100;
			porcentajes[i] = Math.round(porcentajes[i] * 100) / 100F;
		}
		return porcentajes;
	}

	public int maxContador() {
		int masRepetido = 0;// frecuencia mayor
		for (int i = 0; i < contadores.length; i++) {
			if (contadores[i] > masRepetido) {
				masRepetido = contadores[i];
			}
		}
		return masRepetido;
	}

	public int[] listaMasRepetidos() {
		int masRepetido = maxContador();
		int contMasRepetidos = 0;
		for (int i = 0; i < contadores.length; i++) {
			if (contadores[i] == masRepetido) {
				contMasRepetidos++;
			}
		}
		int[] indices = new int[contMasRepetidos];
		int indice = 0;
		for (int i = 0; i < contadores.length; i++) {
			if (contadores[i] == masRepetido) {
				indices[indice] = i+1;
				indice++;
			}
		}
		return indices;
	}

	public int getTotal() {
		int suma = 0;
		for (int i = 0; i < contadores.length; i++) {
			suma = suma + contadores[i];
		}
		return suma;
	}

	@Override
	public String toString() {
		String array = "contadores {";
		for (int i = 0; i < contadores.length - 1; i++) {
			array = array + contadores[i] + ", ";
		}
		array = array + contadores[contadores.length - 1] + "}";
		return array;
	}
}