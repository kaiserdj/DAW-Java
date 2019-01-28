public class Pruebas {
    public static void main(String[] arg){
        String text = "¿Dónde estoy...?";

        for(int i=0;i<text.length();i++){
            System.out.print(text.charAt(i));
            pausa(200);
        }
        limpiar();
        System.out.print(text);
    }

    public static void pausa(int mill){
        try {
            Thread.sleep(mill);
        } catch(InterruptedException ex){

            System.exit(0);
        }
    }

    public static void limpiar(){
        for(int a=0;a<50;a++){
            System.out.println();
        }
    }
}
