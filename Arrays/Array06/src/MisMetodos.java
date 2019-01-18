//Francisco Jesús González Fernández
/**
* @author Francisco Jesús González Fernández
* @version 07/11/2018
* 
*/
class MisMetodos{ 
   /**
   * Realiza una suma de dos numeros enteros
   * @param num1 El primer numero a sumar
   * @param num2 El segundo numero a sumar
   * @return Resultado de la suma
   */
   public static double suma(int num1, int num2){
      double suma = num1 + num2;
      return suma;
   }
   
   /**
   * Realiza una resta de dos numeros enteros
   * @param num1 El primer numero a resta
   * @param num2 El segundo numero a resta
   * @return Resultado de la resta
   */
   public static double resta(int num1, int num2){
      double resta = num1 - num2;
      return resta;
   }
   
   /**
   * Realiza una multiplicacion de dos numeros enteros
   * @param num1 El primer numero a multiplicar
   * @param num2 El segundo numero a multiplicar
   * @return Resultado de la multiplicacion
   */
   public static double multiplicacion(int num1, int num2){
      double m = num1 * num2;
      return m;
   }
      
   /**
   * Realiza una division de dos numeros enteros
   * @param num1 El primer numero a dividir
   * @param num2 El segundo numero a dividir
   * @return Resultado de la division
   */
   public static double division(int num1, int num2){
      double d = num1 / num2;
      return d;
   }
           
   /**
   * Realiza una division de dos numeros enteros
   * @param num1 El primer numero a dividir
   * @param num2 El segundo numero a dividir
   * @return Resto de la division
   */  
   public static double resto(int num1, int num2){
      double r = num1 % num2;
      return r;
   }
           
   /**
   * Realiza una division de un numero entre dos
   * @param num1 Numero a dividir
   * @return <b>- true</b> si es par<br><b>- false</b> si es impar
   */     
   public static boolean par(int num1){
      if(num1%2==0)
         return true;
      return false;
   }
              
   /**
   * Realiza una division de un numero entre dos
   * @param num1 Numero a dividir
   * @return <b>- true</b> si es impar<br><b>- false</b> si es par
   */   
   public static boolean impar(int num1){
      if(num1%2!=0)
         return true;
      return false;
   }
                 
   /**
   * Realiza la funcion de factorizar un numero
   * @param num1 Numero a factorizar
   * @return El numero factorizado.
   */   
   public static int factorial(int num1){
      int num2 = 1;
      
      for(int i = 1;i<=num1;i++){
         num2=num2*i;
      }
      return num2;
   }
                    
   /**
   * Calcula la potenica de un numero
   * @param num1 Base de la potencia
   * @param num2 Exponente de la potencia
   * @return Resultado de la potencia
   */   
   public static double potencia(int num1, int num2){
      double res = num1;
      for(int i=2;i<=num2;i++){
         res = res*num1;
      }
      return res;
   }
                       
   /**
   * Calcular si es primo o no
   * @param num Numero para calcular si es primo
   * @return <b>- true</b> si es primo<br><b>- false</b> si no es primo
   */
   public static boolean primo(int num){
      for(int i=2;i<num;i++){
         if(num%i==0)
            return false;
      }
      return true;
   }
   
   /**
   * Detecta si un numero esta dentro de un intervalo, previamente definido
   * @param n Numero
   * @param limInf Limite inferior del intervalo
   * @param limSup Limite superior del intervalo
   * @return <b>- true</b> si esta dentro del intervalo<br><b>- false</b> si no esta dentro del intervalo
   */
   public static boolean enIntervalo(int n, int limInf, int limSup){
      if(n>limInf & n<limSup)
         return true;
      return false;
   }
   
   /**
   * Combierte un numero cualquiera a positivo(absoluto)
   * @param num Numero
   * @return Devuelve el valor abosluto del numero en una variable int
   */
   public static int absoluto(int num){
   if(num<0)
      num = num * (-1);
   return num;
   }
   
   /**
   * Detecta si un numero es multiplo de tres
   * @param n Numero
   * @return <b>- true</b> si es multiplo de 3<br><b>- false</b> si no es multiplo de 3
   */
   public static boolean esMultiplo3(int n){
      int num2;
      num2 = n%3;
      if(num2==0)
         return true;
      return false;
   } 
         
   /**
   * Transforma letras mayusculas a minusculas
   * @param let Un caracter
   * @return La letra minuscula equivalente de la mayuscula introducida o el mismo caracter si no es una letra mayuscula 
   */
   public static char minus(char let){
      int num = let;
      if((num >= 65 && num <= 90) || num == 209 || num == 193 || num == 201 || num == 205 || num == 211 || num == 218){
         num = num + 32;
         let =(char) num;
      }
      return let;
   }
   
   /**
   * Transforma letras minusculas a mayusculas
   * @param let Un caracter
   * @return La letra mayusculas equivalente de la minuscula introducida o el mismo caracter si no es una letra minuscula 
   */
   public static char mayus(char let){
      int num = let;
      if((num >= 97 && num <= 122) || num == 241 || num == 225 || num == 233 || num == 237 || num == 243 || num == 250){
         num = num - 32;
         let =(char) num;
      }
      return let; 
   }
   
   /**
   * Detecta si el caracter introducido es una vocal
   * @param ch Un caracter
   * @return <b>- true</b> si es una vocal<br><b>- false</b> si no es una vocal
   */
   public static boolean esVocal(char ch){
      ch = minus(ch);
      if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='á'||ch=='é'||ch=='í'||ch=='ó'||ch=='ú')
         return true;
      return false;
   }
   
   /**
    * Cuenta el numero de palabras que hay en un string
    * @param frase Una variable String que contiene una frase
    * @return Una variable int que contiene el numero de palabras
    */
   public static int contarPalabras(String frase) {
	   String arrayString[] = frase.split("\\s+");
	   return arrayString.length;
   }
   
   /**
    * Cuenta el numero de veces que se repite una palabras que hay en un string
    * @param frase Una variable String que contiene una frase
    * @param palabra Una variable String que contiene la palabra que se va a calcular cuantas veces esta
    * @return Una variable int que contiene el numero de veces que se repite la palabras
    */
   public static int buscarPalabra(String frase, String palabra) {
	   int cont = 0;
	   String arrayString[] = frase.split("\\s+");
	   for(int i=0;i<=arrayString.length-1;i++) {
	   		if(arrayString[i].equals(palabra)) {
	   			cont++;
	   		}
	   }
	   return cont;
   }
   
   /**
    * 
    * Redondea un numero al numero de decimales que le digas
    * @param numero Es una variable float que contiene el numero que se desea redondear
    * @param decimales Es una variable int que contiene el nuemro de decimales que se desee que tenga el numero
    * @return Una variable float con el numero redondeado
    */
   public static float redondeo(float numero, int decimales) {
	   float redondeo;
	   redondeo = numero - (float) Math.floor(numero);
	   redondeo = (float) (redondeo * Math.pow(10, decimales));
	   redondeo = Math.round(redondeo);
	   redondeo = (float) ((float) Math.floor(numero) + (Math.floor(redondeo)/Math.pow(10, decimales)));
	   return redondeo;
   }
   
   /**
    * 
    * Redondea un numero al numero de decimales que le digas
    * @param numero Es una variable double que contiene el numero que se desea redondear
    * @param decimales Es una variable int que contiene el nuemro de decimales que se desee que tenga el numero
    * @return Una variable double con el numero redondeado
    */
   public static double redondeo(double numero, int decimales) {
	   double redondeo;
	   redondeo = (float) (numero - (float) Math.floor(numero));
	   redondeo = (float) (redondeo * Math.pow(10, decimales));
	   redondeo = Math.round(redondeo);
	   redondeo = (float) ((float) Math.floor(numero) + (Math.floor(redondeo)/Math.pow(10, decimales)));
	   return redondeo;
   }
}