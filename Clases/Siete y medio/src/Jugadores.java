//Francisco Jes�s Gonz�lez Fern�ndez

import java.util.Arrays;

public class Jugadores {
    //Atributos
    private NaipeEspa�ola[][] cartas;
    private Boolean[][] ocultas;
    private int[] numCartas;
    private float[] dinero, apuesta;

    //Constructor
    public Jugadores(int jugadores, float dinero){
        this.cartas = new NaipeEspa�ola[jugadores][40];
        this.ocultas = new Boolean[jugadores][40];
        this.numCartas = new int[jugadores];
        this.dinero = new float[jugadores];
        this.apuesta = new float[jugadores];
        Arrays.fill(this.dinero, dinero);
        Arrays.fill(numCartas, 0);
    }

    //Metodos
    public void a�adir(int jugador, NaipeEspa�ola NaipeEspa�ola, Boolean oculta){
        for(int i=0;i<cartas[jugador].length;i++){
            if(cartas[jugador][i]==null){
                cartas[jugador][i] = NaipeEspa�ola;
                ocultas[jugador][i] = oculta;
                numCartas[jugador]++;
                break;
            }
        }
    }

    public void setOcultas(int jugador, int carta, boolean estado) {
        ocultas[jugador][carta] = estado;
    }

    public void setApuesta(int jugador, float apuesta){ this.apuesta[jugador]=apuesta; }

    public float getApuesta(int jugador){ return apuesta[jugador]; }

    public float getPuntosJugador(int jugador){
        float valor = 0.0f;
        for(int i=0;i<getNumCartasJugador(jugador);i++){
            NaipeEspa�ola carta = getCartaJugador(jugador, i);
            valor = valor + carta.getValor();
        }
        return valor;
    }

    public float getPuntosVisibleJugador(int jugador){
        float valor = 0.0f;
        for(int i=0;i<getNumCartasJugador(jugador);i++){
            if(getOcultas(jugador,i)==false){
                NaipeEspa�ola carta = getCartaJugador(jugador, i);
                valor = valor + carta.getValor();
            }
        }
        return valor;
    }

    public void quitarCartas(){
        for(int i=0;i<cartas.length;i++){
            Arrays.fill(cartas[i], null);
            Arrays.fill(ocultas[i], false);
        }
        Arrays.fill(numCartas, 0);
    }

    public int getNumCartasJugador(int jugador){
        return numCartas[jugador];
    }

    public NaipeEspa�ola getCartaJugador(int jugador, int carta){
        return cartas[jugador][carta];
    }

    public Boolean getOcultas(int jugador, int carta) {return ocultas[jugador][carta];}

    public int getJugadores(){return (cartas.length-1);}

    public float getDineroJugador(int jugador){ return dinero[jugador];}

    public void a�adirDineroJugador(int jugador, float dinero){ this.dinero[jugador]=this.dinero[jugador]+dinero; }

    public void quitarDineroJugador(int jugador, float dinero){ this.dinero[jugador]=this.dinero[jugador]-dinero; }
}
