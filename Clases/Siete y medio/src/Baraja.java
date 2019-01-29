//Francisco Jesús González Fernández

public class Baraja {
    //Atributos
    private NaipeEspañola[] baraja;
    private Boolean con8y9;
    private int mazo;

    //Constructor
    public Baraja(){
        int cantidad = 40;
        this.baraja = new NaipeEspañola[cantidad];
        this.con8y9 = false;
        this.mazo = cantidad;
        Generar();
    }

    //Metodos
    public void Generar(){
        String[] palos = {"OROS", "COPAS", "ESPADAS", "BASTOS"};
        float[] valor =  {1f,2f,3f,4f,5f,6f,7f,0f,0f,0.5f,0.5f,0.5f};
        int palo = mazo/4, cont = 0;

        for(int i=0;i<4;i++){
            for(int x=0;x<palo;x++){
                if(con8y9==false && x>=7) {
                    baraja[cont] = new NaipeEspañola((x + 3), palos[i], valor[x+2], false);
                    cont++;
                }else{
                    baraja[cont] = new NaipeEspañola((x + 1), palos[i], valor[x], false);
                    cont++;
                }
            }
        }
    }

    public NaipeEspañola Random(){
        int[] checker = new int[baraja.length];
        int x = 0;

        for(int i=0;i<baraja.length;i++){
            if(baraja[i].getReparto()==false){
                checker[x]=i;
                x++;
            }
        }
        if(x==0){
            return null;
        }
        int num = (int) (Math.random() * x);
        num = checker[num];
        baraja[num].setReparto(true);
        mazo--;
        return baraja[num];
    }
}

