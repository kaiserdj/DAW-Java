//Francisco Jesús González Fernández

import java.util.Arrays;

public class Baraja {
    //Atributos
    private NaipeEspañola[] baraja;
    private Boolean con8y9;
    private int mazo;

    //Constructor
    public Baraja(int cantidad, Boolean con8y9){
        this.baraja = new NaipeEspañola[cantidad];
        this.con8y9 = con8y9;
        this.mazo = cantidad;
    }

    public void Generar(){
        String[] palos = {"OROS", "COPAS", "ESPADAS", "BASTOS"};
        int palo = mazo/4, cont = 0;

        for(int i=0;i<4;i++){
            for(int x=0;x<palo;x++){
                if(con8y9==false && x>=7) {
                    baraja[cont] = new NaipeEspañola((x + 3), palos[i], 0, false);
                    cont++;
                }else{
                    baraja[cont] = new NaipeEspañola((x + 1), palos[i], 0, false);
                    cont++;
                }
            }
        }
    }

    public String Random(){
        int check=0;
        int total = baraja.length;
        String carta = null;
        if(mazo!=0) {
            do {
                int num = (int) (Math.random() * total);
                if (baraja[num].getReparto() == false) {
                    baraja[num].setReparto(true);
                    check = 1;
                    carta = baraja[num].toString();
                    mazo--;
                }
            } while (check == 0);
            return carta;
        }
        return "No hay mas cartas";
    }

    public void Mezclar(){
        String[] palos = {"OROS", "COPAS", "ESPADAS", "BASTOS"};
        int[] cantidad = new int[4];
        Arrays.fill(cantidad, 12);
        int total = mazo;
        Boolean[][] numeros = new Boolean[4][12];
        Arrays.fill(numeros[1], false);
        Arrays.fill(numeros[2], false);
        Arrays.fill(numeros[3], false);
        Arrays.fill(numeros[4], false);

        if(con8y9 = false){
            Arrays.fill(cantidad, 10);
            for(int i=0;i<3;i++){
                numeros[i][8]=true;
                numeros[i][9]=true;
            }
        }

        for(int i=0;i<total;i++){
            int palo = (int) (Math.random() * 4);
            int num = (int) (Math.random() * 12);
            if(cantidad[palo]!=0){
                if(numeros[palo][num]==false){
                    baraja[i] = new NaipeEspañola(num, palos[palo], 1,false);
                    numeros[palo][num] = true;
                    cantidad[palo]--;
                }
            }
        }
    }
}

