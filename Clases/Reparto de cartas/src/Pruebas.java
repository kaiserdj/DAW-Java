import java.lang.reflect.Array;
import java.util.Arrays;

public class Pruebas {
    public static void main(String[] arg) {
        for (int i = 0; i<100; i++) {
            int numero = (int) (Math.random() * 10);
            System.out.println(numero);
        }
        Boolean[][] test = new Boolean[4][20];
        Arrays.fill(test[1], false);
        System.out.println(test[1][10]);
    }
}
