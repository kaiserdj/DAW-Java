//Francisco Jesús González Fernández

import java.util.Arrays;

public class Jugadores {
    //Atributos
    private NaipeEspañola[][] cartas;
    private Boolean[][] ocultas;
    private int[] numCartas;

    //Constructor
    public Jugadores(int jugadores){
        this.cartas = new NaipeEspañola[jugadores][40];
        this.ocultas = new Boolean[jugadores][40];
        this.numCartas = new int[jugadores];
        Arrays.fill(numCartas, 0);
    }

    //Metodos
    public void añadir(int jugador, NaipeEspañola NaipeEspañola, Boolean oculta){
        for(int i=0;i<cartas[jugador].length;i++){
            if(cartas[jugador][i]==null){
                cartas[jugador][i] = NaipeEspañola;
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
            NaipeEspañola carta = getCartaJugador(jugador, i);
            valor = valor + carta.getValor();
        }
        return valor;
    }

    public float getPuntosVisibleJugador(int jugador){
        float valor = 0.0f;
        for(int i=0;i<getNumCartasJugador(jugador);i++){
            if(getOcultas(jugador,i)==false){
                NaipeEspañola carta = getCartaJugador(jugador, i);
                valor = valor + carta.getValor();
            }
        }
        return valor;
    }

    public int getNumCartasJugador(int jugador){
        return numCartas[jugador];
    }

    public NaipeEspañola getCartaJugador(int jugador, int carta){
        return cartas[jugador][carta];
    }

    public Boolean getOcultas(int jugador, int carta) {return ocultas[jugador][carta];}

}
