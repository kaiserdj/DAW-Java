//Francisco Jes�s Gonz�lez Fern�ndez

public class NaipeEspa�ola {
    //Atributos
    private int numero;
    private String palo;
    private float valor;
    private Boolean reparto;

    //Constructor
    public NaipeEspa�ola(int numero, String palo, float valor, Boolean reparto){
        this.numero = numero;
        this.palo = palo;
        this.valor = valor;
        this.reparto = reparto;
    }

    public Boolean getReparto() {
        return reparto;
    }

    public void setReparto(Boolean reparto) {
        this.reparto = reparto;
    }

    public float getValor() {return valor;}

    @Override
    public String toString() {
        return "[" + Integer.toString(numero) + ", " + palo + ", " + Float.toString(valor) + ", " + Boolean.toString(reparto) + "]";
    }
}
