//Francisco Jesús González Fernández

public class NaipeEspañola {
    //Atributos
    private int numero;
    private String palo;
    private float valor;
    private Boolean reparto;

    //Constructor
    public NaipeEspañola(int numero, String palo, float valor, Boolean reparto){
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
        if(numero==10){
            return "Sota de " + palo;
        }
        if (numero == 11) {
            return "Caballo de " + palo;
        }
        if (numero == 12){
            return "Rey de " + palo;
        }
        if (numero == 1){
            return  "As de " + palo;
        }
        return Integer.toString(numero) + " de " + palo;
    }
}
