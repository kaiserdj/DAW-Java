//Francisco Jes�s Gonz�lez Fern�ndez

import java.util.Arrays;

public class Jugadores {
    //Atributos
    private NaipeEspa�ola[][] cartas;
    private Boolean[][] ocultas;
    private int[] numCartas;

    //Constructor
    public Jugadores(int jugadores){
        this.cartas = new NaipeEspa�ola[jugadores][40];
        this.ocultas = new Boolean[jugadores][40];
        this.numCartas = new int[jugadores];
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

    public int getNumCartasJugador(int jugador){
        return numCartas[jugador];
    }

    public NaipeEspa�ola getCartaJugador(int jugador, int carta){
        return cartas[jugador][carta];
    }

    public Boolean getOcultas(int jugador, int carta) {return ocultas[jugador][carta];}

}
