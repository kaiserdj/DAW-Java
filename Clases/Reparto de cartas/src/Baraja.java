//Francisco Jesús González Fernández

public class Baraja {
    //Atributos
    private NaipeEspañola[] baraja;
    private Boolean con8y9;
    private int mazo;

    //Constructor
    public Baraja(NaipeEspañola[] baraja, Boolean con8y9, int mazo){
        this.baraja = baraja;
        this.con8y9 = con8y9;
        this.mazo = mazo;
    }

    public void setMazo(int mazo) {
        this.mazo = mazo;
    }

    public int getMazo() {
        return mazo;
    }
}
